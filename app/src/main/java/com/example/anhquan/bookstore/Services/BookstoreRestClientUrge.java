package com.example.anhquan.bookstore.Services;

import android.util.Log;

import com.example.anhquan.bookstore.Entity.book.Book;
import com.example.anhquan.bookstore.Entity.book.BookSet;
import com.example.anhquan.bookstore.Entity.book.Category;
import com.google.gson.JsonObject;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;
import com.loopj.android.http.TextHttpResponseHandler;

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

    public boolean login(String username, String password){
        RequestParams params = new RequestParams();
        params.put("username", username);
        params.put("password", password);
        Services.post("member/login",params, new TextHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, String responseString) {
                Log.v("REsult", responseString);
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                Log.e("ERROR", throwable.toString());
            }
        });
        return false;
    }
    public ArrayList<Book> get20NewBook(){
        final ArrayList<Book> books=new ArrayList<Book>();
        Services.post("book/get20newbooks",null,new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                try {
                    for(int i=0; i<response.length(); i++){
                        JSONObject jObject=response.getJSONObject(i);
                        Book book=new Book();
                        book.setIdBook(jObject.getInt("idBook"));
                        book.setImage(jObject.getString("image"));
                        book.setTitle(jObject.getString("title"));
                        book.setAuthor(jObject.getString("author"));
                        book.setPublisher(jObject.getString("publisher"));
                        book.setPublishYear(jObject.getString("publishYear"));
                        book.setDescription(jObject.getString("description"));
                        book.setOriginalPrice(jObject.getString("originalPrice"));
                        book.setSalePrice(jObject.getString("salePrice"));
                        book.setQuantity(jObject.getInt("quantity"));
                        JSONObject jC=jObject.getJSONObject("category");
                        Category category=new Category(jC.getInt("idCategory"), jC.getString("name"), jC.getString("description"));
                        book.setCategory(category);
                        JSONObject jBS=jObject.getJSONObject("set");
                        BookSet bookSet=new BookSet(jBS.getInt("idBookSet"), jBS.getString("name"), jBS.getString("description"));
                        book.setSet(bookSet);
                        book.setSortLink(jObject.getString("sortLink"));
                        books.add(book);
                    }
                    Log.v("BookSet", books.get(1).getCategory().getName());
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable t, JSONObject e)  {
                Log.e("ERROR", e.toString());
            }
        });
        return books;
    }
    public ArrayList<Book> getAllBookbyIdCategory(String idCategory){
        final ArrayList<Book> books=new ArrayList<Book>();
        RequestParams params = new RequestParams();
        params.put("idCt", idCategory);
        Services.post("category",params,new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                try {
                    for(int i=0; i<response.length(); i++){
                        JSONObject jObject=response.getJSONObject(i);
                        Book book=new Book();
                        book.setIdBook(jObject.getInt("idBook"));
                        book.setImage(jObject.getString("image"));
                        book.setTitle(jObject.getString("title"));
                        book.setAuthor(jObject.getString("author"));
                        book.setPublisher(jObject.getString("publisher"));
                        book.setPublishYear(jObject.getString("publishYear"));
                        book.setDescription(jObject.getString("description"));
                        book.setOriginalPrice(jObject.getString("originalPrice"));
                        book.setSalePrice(jObject.getString("salePrice"));
                        book.setQuantity(jObject.getInt("quantity"));
                        JSONObject jC=jObject.getJSONObject("category");
                        Category category=new Category(jC.getInt("idCategory"), jC.getString("name"), jC.getString("description"));
                        book.setCategory(category);
                        JSONObject jBS=jObject.getJSONObject("set");
                        BookSet bookSet=new BookSet(jBS.getInt("idBookSet"), jBS.getString("name"), jBS.getString("description"));
                        book.setSet(bookSet);
                        book.setSortLink(jObject.getString("sortLink"));
                        books.add(book);
                    }
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
    public ArrayList<Book> getAllBookbyIdBookSet(String idBookSet){
        final ArrayList<Book> books=new ArrayList<Book>();
        RequestParams params = new RequestParams();
        params.put("idBS", idBookSet);
        Services.post("bookset",params,new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                try {
                    for(int i=0; i<response.length(); i++){
                        JSONObject jObject=response.getJSONObject(i);
                        Book book=new Book();
                        book.setIdBook(jObject.getInt("idBook"));
                        book.setImage(jObject.getString("image"));
                        book.setTitle(jObject.getString("title"));
                        book.setAuthor(jObject.getString("author"));
                        book.setPublisher(jObject.getString("publisher"));
                        book.setPublishYear(jObject.getString("publishYear"));
                        book.setDescription(jObject.getString("description"));
                        book.setOriginalPrice(jObject.getString("originalPrice"));
                        book.setSalePrice(jObject.getString("salePrice"));
                        book.setQuantity(jObject.getInt("quantity"));
                        JSONObject jC=jObject.getJSONObject("category");
                        Category category=new Category(jC.getInt("idCategory"), jC.getString("name"), jC.getString("description"));
                        book.setCategory(category);
                        JSONObject jBS=jObject.getJSONObject("set");
                        BookSet bookSet=new BookSet(jBS.getInt("idBookSet"), jBS.getString("name"), jBS.getString("description"));
                        book.setSet(bookSet);
                        book.setSortLink(jObject.getString("sortLink"));
                        books.add(book);
                    }
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
    public ArrayList<BookSet> getAllBookSet(){
        final ArrayList<BookSet> bookSets=new ArrayList<BookSet>();
        Services.post("bookset/getAll",null,new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                try {
                    for(int i=0; i<response.length(); i++){
                        JSONObject jObject=response.getJSONObject(i);
                        BookSet bookset=new BookSet(
                                jObject.getInt("idBookSet"),
                                jObject.getString("name"),
                                jObject.getString("description"));
                        bookSets.add(bookset);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable t, JSONObject e)  {
                Log.e("ERROR", e.toString());
            }
        });
        return bookSets;
    }
    public ArrayList<Category> getAllCategory(){
        final ArrayList<Category> categories=new ArrayList<Category>();
        Services.post("category/getAll",null,new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                try {
                    for(int i=0; i<response.length(); i++){
                        JSONObject jObject=response.getJSONObject(i);
                        Category category=new Category(
                                jObject.getInt("idCategory"),
                                jObject.getString("name"),
                                jObject.getString("description"));
                        categories.add(category);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable t, JSONObject e)  {
                Log.e("ERROR", e.toString());
            }
        });
        return categories;
    }
//    public ArrayList<Book> getNew20Book(){
//
//    }
    public Book getBookById(String id){
        final Book book=new Book();
        RequestParams params = new RequestParams();
        params.put("idBook", id);

        Services.post("book/getbook",params,new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject jObject) {
                try {
                    book.setIdBook(jObject.getInt("idBook"));
                    book.setImage(jObject.getString("image"));
                    book.setTitle(jObject.getString("title"));
                    book.setAuthor(jObject.getString("author"));
                    book.setPublisher(jObject.getString("publisher"));
                    book.setPublishYear(jObject.getString("publishYear"));
                    book.setDescription(jObject.getString("description"));
                    book.setOriginalPrice(jObject.getString("originalPrice"));
                    book.setSalePrice(jObject.getString("salePrice"));
                    book.setQuantity(jObject.getInt("quantity"));
                    JSONObject jC=jObject.getJSONObject("category");
                    Category category=new Category(jC.getInt("idCategory"), jC.getString("name"), jC.getString("description"));
                    book.setCategory(category);
                    JSONObject jBS=jObject.getJSONObject("set");
                    BookSet bookSet=new BookSet(jBS.getInt("idBookSet"), jBS.getString("name"), jBS.getString("description"));
                    book.setSet(bookSet);
                    book.setSortLink(jObject.getString("sortLink"));
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
        return book;
    }
}
