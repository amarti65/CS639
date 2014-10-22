package com.example.anthony.threadexample;

import android.app.Activity;
import android.app.Fragment;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class ImageDownloader extends Activity {

    public void ImageDownloader(Fragment myActivity)
    {myActivity = myActivity;}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_downloader);
    }


}