
package com.example.anhquan.bookstore.Services;

import android.util.Log;

import com.loopj.android.http.*;

import org.json.*;

import cz.msebera.android.httpclient.Header;

/**
 * Created by AnhQuan on 05/05/2016.
 */

public class Services {
    private static final String BASE_URL = "http://192.168.1.6:8080/AndroidServer/";
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
