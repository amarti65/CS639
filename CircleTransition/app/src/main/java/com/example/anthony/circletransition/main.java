package com.example.anthony.circletransition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.Window;


public class main extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
   //Enable extended screen features. This must be called before setContentView().
   // //May be called as many times as desired as long as it is before setContentView().
   // If not called, no extended features will be available. You can not turn off a
   // feature once it is requested.
   //at least one approach needed for transitions to work
        getWindow().requestFeature((Window.FEATURE_CONTENT_TRANSITIONS));
        setContentView(R.layout.activity_main);

        //make a View object to represent the button on screen
        //
        final View button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            View myView = findViewById(R.id.firstId);
            Boolean isRevealed = false;

            @Override
            public void onClick(View v) {

                //conditional statement operator
                isRevealed = !isRevealed;

                // get the center for the clipping circle
                int cx = (myView.getLeft() + myView.getRight()) / 2;
                int cy = (myView.getTop() + myView.getBottom()) / 2;
                int radius = myView.getWidth();

                if(isRevealed){
                    //superclass for animation objects and methods like addListener

                    Animator anim =
                            ViewAnimationUtils.createCircularReveal(findViewById(R.id.firstId), cx, cy, radius, 0);
                    anim.addListener(new AnimatorListenerAdapter()
                    {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);
                            myView.setVisibility(View.INVISIBLE);
                        }//end onAnimationEnd
                    });// end parameters for animation
                    anim.start();
                }else{
                    myView.setVisibility(View.VISIBLE);

                    int finalRadius = myView.getWidth();

                    Animator anim = ViewAnimationUtils.createCircularReveal(myView,cx,cy,0,radius);
                    anim.start();
                }// end else condition
            }// end onClickView
        });//end onClickListener
    }//end onCreate
}// end class main
