package cs639.pace.com.cs639threadsample;

import android.graphics.Bitmap;
import android.os.AsyncTask;

/**
 * Created by cscharff on 10/15/2014.
 */
public class AsyncTaskSample extends AsyncTask<String,Integer,Bitmap>{
    @Override
    protected Bitmap doInBackground(String... urls) {
        return null;
    }

    @Override
    protected void onPostExecute(Bitmap img) {
        super.onPostExecute(img);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }
}
