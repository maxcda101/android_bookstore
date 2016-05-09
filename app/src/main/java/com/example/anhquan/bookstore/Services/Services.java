
package com.example.anhquan.bookstore.Services;

import android.util.Log;

import com.example.anhquan.bookstore.Entity.book.Category;
import com.loopj.android.http.*;


import org.json.*;

import java.io.IOException;
import java.util.List;

import cz.msebera.android.httpclient.Header;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by AnhQuan on 05/05/2016.
 */

public class Services {
    public  static final String BASE_URL = "http://anhquanpc:8081/AndroidServer/";
    private static AsyncHttpClient client = new AsyncHttpClient();

    public static void get(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.get(getAbsoluteUrl(url), params, responseHandler);
    }

    public static void post(String url, RequestParams params, AsyncHttpResponseHandler responseHandler) {
        client.setTimeout(3000);
        client.post(getAbsoluteUrl(url), params, responseHandler);
    }

    private static String getAbsoluteUrl(String relativeUrl) {
        return BASE_URL + relativeUrl;
    }


}
