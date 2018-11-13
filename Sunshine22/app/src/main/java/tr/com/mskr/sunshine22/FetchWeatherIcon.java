package tr.com.mskr.sunshine22;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.net.URL;

public class FetchWeatherIcon extends AsyncTask<String, Void, Bitmap> {
    @Override
    protected Bitmap doInBackground(String... strings) {
        // Solution found at: https://stackoverflow.com/a/16293557
        URL iconUrl;
        try {
            iconUrl = new URL(strings[0]);
            return BitmapFactory.decodeStream(iconUrl.openConnection().getInputStream());
        } catch (java.io.IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
