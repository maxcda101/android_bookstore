//package com.example.anhquan.bookstore.Services;
//
//import android.os.AsyncTask;
//
//import org.apache.http.HttpEntity;
//import org.apache.http.HttpResponse;
//import org.apache.http.client.ClientProtocolException;
//import org.apache.http.client.methods.HttpPost;
//import org.apache.http.impl.client.DefaultHttpClient;
//import org.apache.http.protocol.HTTP;
//import org.apache.http.util.EntityUtils;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import java.io.IOException;
//import java.io.UnsupportedEncodingException;
//
///**
// * Created by taphuong on 5/4/2016.
// */
//public class Services {
//    public static boolean dangNhap(String username, String password){
//        ///linh tinh
//        return true;
//    }
//    private class ReadJSON extends AsyncTask<String, Integer, String> {
//        @Override
//        protected String doInBackground(String... params) {
//            return getXmlFromUrl(params[0]);
//        }
//
//        @Override
//        protected void onPostExecute(String s) {
//            super.onPostExecute(s);
//        }
//
//        //        @Override
////        protected void onPostExecute(String s) {
////            try {
////                JSONObject root=new JSONObject(s);
//////                JSONArray arr=new JSONArray(s);
//////                String result="";
//////                for(int i=0; i<arr.length(); i++){
//////                    JSONObject json=arr.getJSONObject(i);
//////                    result += json.getString("name");
//////                }
//////                txt.setText(result);
//////                Toast.makeText(AsyncActivity.this, String.valueOf(root.getString("title")), Toast.LENGTH_LONG);
////            } catch (JSONException e) {
////                e.printStackTrace();
////            }
////        }
////    }
//    private String getXmlFromUrl(String url){
//        String xml=null;
//        try{
//            // Lấy dữ liệu vào chuỗi String xml
//            DefaultHttpClient httpClient=new DefaultHttpClient();
//            HttpPost httpPost=new HttpPost(url);
//            HttpResponse httpResponse=httpClient.execute(httpPost);
//            HttpEntity httpEntity=httpResponse.getEntity();
//            // Set UTF-8
//            xml = EntityUtils.toString(httpEntity, HTTP.UTF_8);
//        }catch(UnsupportedEncodingException e){
//            e.printStackTrace();
//        }catch(ClientProtocolException e){
//            e.printStackTrace();
//        }catch(IOException e){
//            e.printStackTrace();
//        }
//        return xml;
//    }
//
//}
