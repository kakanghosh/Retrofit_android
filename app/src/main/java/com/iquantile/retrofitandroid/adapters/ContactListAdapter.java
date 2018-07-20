package com.iquantile.retrofitandroid.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.iquantile.retrofitandroid.R;
import com.iquantile.retrofitandroid.models.Contact;

import java.util.List;

public class ContactListAdapter extends BaseAdapter {

    private Context context;
    private List<Contact> contactList;

    public ContactListAdapter(Context context, List<Contact> contactList) {
        this.context = context;
        this.contactList = contactList;
    }

    @Override
    public int getCount() {
        return contactList.size();
    }

    @Override
    public Object getItem(int i) {
        return contactList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return contactList.get(i).getId();
    }

    @Override
    public View getView(int index, View convertView, ViewGroup parent) {
        View view;
        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.simple_contact_list_row, parent, false);
        }else {
            view = convertView;
        }

        TextView nameTextView = view.findViewById(R.id.textView_contact_name);
        TextView emailTextView = view.findViewById(R.id.textView_contact_email);
        nameTextView.setText(contactList.get(index).getName());
        emailTextView.setText(contactList.get(index).getEmail());
        return view;
    }
}
