package com.example.anhquan.bookstore.Services;

import android.util.Log;

import com.example.anhquan.bookstore.Entity.book.Book;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

/**
 * Created by AnhQuan on 05/05/2016.
 */
public class BookstoreRestClientUrge {
    public BookstoreRestClientUrge() {
    }

    public ArrayList<Book> getBookById(String id){
        final ArrayList<Book> books=new ArrayList<>();

        RequestParams params = new RequestParams();
        params.put("idBook", id);
        Log.v("JsonArray","hello");

        Services.post("category/getAll",null,new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                // Root JSON in response is an dictionary i.e { "data : [ ... ] }
                // Handle resulting parsed JSON response here
                try {
                    Log.v("JsonArray",response.getJSONObject(0).getString("description"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable t, JSONObject e)  {
                // Handle the failure and alert the user to retry
                Log.e("ERROR", e.toString());
            }
        });
          return books;
    }
}
