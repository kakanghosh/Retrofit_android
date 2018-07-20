package com.iquantile.retrofitandroid.api.interfaces;

import com.iquantile.retrofitandroid.models.Contact;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ContactAPIInterface {

    @GET("contacts.php")
    Call<List<Contact>> getAllContacts();
}
