package com.example.anhquan.bookstore.Services;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.anhquan.bookstore.Entity.book.Book;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * Created by AnhQuan on 05/05/2016.
 */
public class Store {
    public Store() {
    }

    public static void setString(String key, String value, Context context) {
        SharedPreferences pre = context.getSharedPreferences("bookstore", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = pre.edit();
        edit.putString(key, value);
        edit.commit();
    }
    public static void deleteString(String key, Context context){
        SharedPreferences pre = context.getSharedPreferences("bookstore", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = pre.edit();
        edit.remove(key);
        edit.commit();
    }

    public static String getString(String key, Context context) {
        SharedPreferences pre = context.getSharedPreferences("bookstore", context.MODE_PRIVATE);
        return pre.getString(key,"");

    }
    public void saveCart(Context context, ArrayList<Book> favorites){
        SharedPreferences settings;
        SharedPreferences.Editor editor;

        settings = context.getSharedPreferences("bookstore",
                Context.MODE_PRIVATE);
        editor = settings.edit();

        Gson gson = new Gson();
        String jsonFavorites = gson.toJson(favorites);

        editor.putString("cart", jsonFavorites);

        editor.commit();
    }
    public ArrayList<Book> getCart (Context context){
        SharedPreferences settings;
        List<Book> favorites;

        settings = context.getSharedPreferences("bookstore",
                Context.MODE_PRIVATE);

        if (settings.contains("cart")) {
            String jsonFavorites = settings.getString("cart", null);
            Gson gson = new Gson();
            Book[] favoriteItems = gson.fromJson(jsonFavorites,
                    Book[].class);

            favorites = Arrays.asList(favoriteItems);
            favorites = new ArrayList<Book>(favorites);
        } else
            return new ArrayList<Book>();

        return (ArrayList<Book>) favorites;
    }
    public void addElementToCart(Context context, Book product) {
        ArrayList<Book> favorites = getCart(context);
        if (favorites == null)
            favorites = new ArrayList<Book>();
        favorites.add(product);
        saveCart(context, favorites);
    }
    public void removeBookInCart(Context context, Book product) {
        ArrayList<Book> favorites = getCart(context);
        if (favorites != null) {
            favorites.remove(product);
            saveCart(context, favorites);
        }
    }
    public void removeAllCart(Context context){
        SharedPreferences settings;
        SharedPreferences.Editor editor;

        settings = context.getSharedPreferences("bookstore",
                Context.MODE_PRIVATE);
        editor = settings.edit();
        editor.remove("cart");
        editor.commit();
    }


}
