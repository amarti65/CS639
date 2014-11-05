package com.example.anthony.kevincircletransition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.os.Build;
import android.view.Window;


public class Main extends Activity {


    Boolean isRevealed = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature((Window.FEATURE_CONTENT_TRANSITIONS));
        setContentView(R.layout.fragment_main);

        //make a button View
        button.setOnClickListener(new View.OnClickListener() {

            View myView = findViewById(R.id.firstId);

            @Override
            public void onClick(View v) {

                isRevealed = !isRevealed;

                if(isRevealed){

                    // get the center for the clipping circle
                    int cx = (myView.getLeft() + myView.getRight()) / 2;
                    int cy = (myView.getTop() + myView.getBottom()) / 2;
                    int initialRadius = myView.getWidth();
                    // create and start the animator for this view
                    // (the start radius is zero)
                    Animator anim =
                           ViewAnimationUtils.createCircularReveal(findViewById(R.id.firstId), cx, cy, initialRadius, 0);


                    anim.addListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);
                            myView.setVisibility(View.INVISIBLE);
                        }
                    });
                    anim.start();
                }else{
                    myView.setVisibility(View.VISIBLE);
                    // get the center for the clipping circle
                    // get the center for the clipping circle
                    int cx = (myView.getLeft() + myView.getRight()) / 2;
                    int cy = (myView.getTop() + myView.getBottom()) / 2;
                    int finalRadius = myView.getWidth();

                    Animator anim = ViewAnimationUtils.createCircularReveal(myView,cx,cy,0,finalRadius);
                    anim.start();

                }

            }

        });

    }
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.main, menu);
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
                View rootView = inflater.inflate(R.layout.fragment_main, container, false);
                return rootView;
            }
        }
    }

