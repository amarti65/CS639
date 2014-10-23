package com.example.anthony.asynchinsert;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by anthony on 10/21/14.
 */
public class AsynchronousInput extends AsyncTask<String,Integer,Bitmap>

{


    @Override
    protected Bitmap doInBackground(String... params) {

        try{
            URL url = new URL("http://wanderingoak.net/bridge.png");
            HttpURLConnection con =(HttpURLConnection)url.openConnection();
            if ((con.getResponseCode() != 200))
            {throw new Exception(("Failed to connect"));}
            InputStream is = con.getInputStream();
            is.close();
            Bitmap bmap = BitmapFactory.decodeStream(is);
            return bmap;
        }catch(Exception e){
            Log.e("Image", "Failed to load image", e);
            Log.e("error", e.getMessage());
        }


        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }




}
