package com.example.anthony.async;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpConnection;

import java.io.IOException;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by anthony on 10/15/14.
 */
public class AscyncTaskSample extends AsyncTask<String, Integer,Bitmap>

{
    @Override
    protected Bitmap doInBackground(String...params) {
        try {
            URL url = new URL(params[0]);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            if (con.getResponseCode() != HttpURLConnection.HTTP_OK)
                throw new Exception("Failed to connect");
            InputStream is = con.getInputStream();
            is.close();
            Bitmap bmap = BitmapFactory.decodeStream(is);
            return bmap;
        } catch (Exception e) {
            Log.e("Image", "Failed to load image", e);
            Log.e("error", e.getMessage());
        }
        return null;
    }

    @Override
    protected void onPostExecute(Bitmap img)
    {
        super.onPostExecute(img);
    }
    @Override protected void onPreExecute()
    {
        super.onPreExecute();
    }
    @Override
    protected void onProgressUpdate(Integer...values)
    {
        super.onProgressUpdate(values);
    }


}