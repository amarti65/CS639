package com.example.anthony.circle;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.Window;


public class    Main extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_main);

        final View button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            View myView = findViewById(R.id.viewId);
            Boolean isRevealed = false;

            @Override
            public void onClick(View v) {

                isRevealed = !isRevealed;

                int cx = (myView.getLeft() + myView.getRight())/ 2;
                int cy = (myView.getTop() + myView.getBottom())/ 2;
                float radius = myView.getWidth();

                if (isRevealed)
                {
                    Animator animator =
                            ViewAnimationUtils.createCircularReveal(findViewById(R.id.viewId),cx,cy,radius,0);

                    animator.addListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);
                            myView.setVisibility(View.INVISIBLE);
                        }
                    });
                    animator.start();
                }else{
                    myView.setVisibility(View.VISIBLE);
                    Animator animator =  ViewAnimationUtils.createCircularReveal(myView, cx,cy,0,radius);
                    animator.start();
                }
            }
        });
    }
}
