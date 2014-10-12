package com.example.anthony.lab_2_intents_smstelwebmapshare;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;



public class MyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_my, container, false);
            return rootView;
        }
    }

    //Added for lab

    public void sendSMS(View view)
    {
        final Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("smsto:" + Uri.encode("18457424596")));
        intent.putExtra("sms_body","Hey baby ");
        startActivity(intent);

    }
    public void sendWEB (View view)
    {
        final Intent websiteIntent = new Intent(Intent.ACTION_VIEW,
                Uri.parse("http://google.com"));
        startActivity((websiteIntent));

    }

    public void sendSHARE(View view)
    {
        final Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT,"CS639");
        intent.putExtra(Intent.EXTRA_TEXT,"Join CS639");
        startActivity(Intent.createChooser(intent,"Share the love"));

    }
    public void sendMAP(View view)
    {
        String geoUri = String.format("geo:40.771569, -74.05000");
        Uri geo = Uri.parse(geoUri);
        Intent geoMap = new Intent(Intent.ACTION_VIEW,geo);
        startActivity(geoMap);
    }

    public void sendTEL(View view)
    {
        final Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:2123630830"));
        startActivity(intent);
    }
}
