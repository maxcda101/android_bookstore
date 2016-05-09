package com.example.anhquan.bookstore.Services;

import android.util.Log;

import com.example.anhquan.bookstore.Entity.book.Book;
import com.example.anhquan.bookstore.Entity.book.Category;

import java.io.IOException;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by AnhQuan on 09/05/2016.
 */
public class ServiceGenerator {
    public static final String API_BASE_URL =Services.BASE_URL;

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create());

    public static <S> S createService(Class<S> serviceClass) {
        Retrofit retrofit = builder.client(httpClient.build()).build();
        return retrofit.create(serviceClass);
    }
    public interface BookStoreService {
        @GET("category/getAll")
        Call<List<Category>> getAllCategory( );
        @POST("book/get20newbooks")
        Call<List<Book>> get20newbooks();
        @GET("category")
        Call<List<Book>> getAllBookByCategory(@Query("idCt") int idCt);
        @POST("search")
        Call<List<Book>> searchBook(@Query("vl") String vl);
    }
//    public static String getAllCategory(){
//        BookStoreService bookStoreService=ServiceGenerator.createService(BookStoreService.class);
//        Call<List<Book>> call=bookStoreService.searchBook("Thu");
//        call.enqueue(new Callback<List<Book>>() {
//            @Override
//            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
//                Log.v("dm minh", response.body().size()+"");
//            }
//            @Override
//            public void onFailure(Call<List<Book>> call, Throwable t) {
//
//            }
//        });
//
//        return " dm minh beo";
//    }
}
