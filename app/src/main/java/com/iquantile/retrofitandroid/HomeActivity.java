package com.iquantile.retrofitandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.google.gson.Gson;
import com.iquantile.retrofitandroid.adapters.ContactListAdapter;
import com.iquantile.retrofitandroid.api.APIClient;
import com.iquantile.retrofitandroid.api.interfaces.ContactAPIInterface;
import com.iquantile.retrofitandroid.models.Contact;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {
    ListView contactListView;
    List<Contact> contactList;
    ContactListAdapter contactListAdapter;
    ContactAPIInterface contactAPIInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initWidget();
        initAPI();
    }

    private void initWidget() {
        contactListView = findViewById(R.id.listView_contacts);
    }

    private void initAPI() {
        contactAPIInterface = APIClient.getAPIClient().create(ContactAPIInterface.class);

        Call<List<Contact>> call = contactAPIInterface.getAllContacts();
        call.enqueue(new Callback<List<Contact>>() {
            @Override
            public void onResponse(Call<List<Contact>> call, Response<List<Contact>> response) {
                contactList = response.body();
                contactListAdapter = new ContactListAdapter(HomeActivity.this, contactList);
                contactListView.setAdapter(contactListAdapter);
                Log.d("response", "Passed");
            }

            @Override
            public void onFailure(Call<List<Contact>> call, Throwable t) {
                Log.d("response fail", t.getMessage());
            }
        });
    }
}
