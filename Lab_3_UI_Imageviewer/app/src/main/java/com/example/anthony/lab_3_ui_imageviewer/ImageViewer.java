package com.example.anthony.lab_3_ui_imageviewer;

import android.app.Activity;
import android.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class ImageViewer extends Activity {


    //private Button buttOne, buttTwo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_viewer);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }

    public void exampleToast(View view)
    {
        Toast toast = Toast.makeText(this, "Cheers", Toast.LENGTH_SHORT);
        toast.show();

        Log.i("ImageViewer","Message");
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment implements View.OnClickListener{

        View rootView;
        // reference as an integer
        int[] imageIntArray ={R.drawable.one, R.drawable.two,R.drawable.three};
        // Titles above the image associated with each corresponding image R.drawable.
        String[] imageStrArray = {"one", "two","three"};

        int count = 1;

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // defined rootView Globally
            rootView = inflater.inflate(R.layout.fragment_image_viewer, container, false);
            // Create the button object in this class
            Button buttonright = (Button)rootView.findViewById(R.id.prev);
            // define the action for the button
             buttonright.setOnClickListener((View.OnClickListener) this);
            //and the left side.
            Button buttonleft = (Button)rootView.findViewById(R.id.next);
            buttonleft.setOnClickListener(this);

            ImageView imageView = (ImageView) rootView.findViewById(R.id.imageViewLens);
            imageView.setImageResource(imageIntArray[count]);
            TextView textView = (TextView) rootView.findViewById(R.id.text_view);
            textView.setText(imageStrArray[count]);

        // thats it

            return rootView;

        }

        @Override
        public void onClick(View v) {


            if(v.getId() == R.id.prev && count > 0)
            {
                count --;
                ImageView imageView = (ImageView) rootView.findViewById(R.id.imageViewLens);
                imageView.setImageResource(imageIntArray[count]);
                TextView textView = (TextView) rootView.findViewById(R.id.text_view);
                textView.setText(imageStrArray[count]);
            }
            else if (v.getId() == R.id.next && count < (imageIntArray.length - 1))
            {
                count++;
                ImageView imageView = (ImageView) rootView.findViewById(R.id.imageViewLens);
                imageView.setImageResource(imageIntArray[count]);
                TextView textView = (TextView) rootView.findViewById(R.id.text_view);
                textView.setText(imageStrArray[count]);
            }
            else{
                Toast toast = Toast.makeText(getActivity().getApplicationContext(), "You have reached the end of the slideshow.", Toast.LENGTH_SHORT);
                toast.show();}
        }
    }
}
