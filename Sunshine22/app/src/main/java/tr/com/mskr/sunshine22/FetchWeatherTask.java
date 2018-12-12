package tr.com.mskr.sunshine22;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;

public class FetchWeatherTask extends AsyncTask<String, Void, JSONArray> {

/*     When MainActivity executes weatherTask.execute() there ALREADY EXISTS an active adapter.
*   This class merely alters it. What does it do? It runs doInBackground() which returns a String[].
*
*       Note: to obtain/format that string we run custom getWeatherDataFromJson().
*       Until then, it is pure JSON.
*
*       When doInBackground() is complete, onPostExecute() takes that string[] and THEN alters
*   adapter by feeding it to the adapter, ie. a new string for ForecastViewHolder class.          */

// QUESTION: What are parameters on AsyncTask<X, Y, Z> ?

    private GreenAdapter mWeatherAdapter;
    Context mContext;
    ContentResolver mResolver;

    public FetchWeatherTask(GreenAdapter weatherAdapter) {
        mWeatherAdapter = weatherAdapter;
    }

    public FetchWeatherTask(GreenAdapter mWeatherAdapter, Context context){
        this.mWeatherAdapter=mWeatherAdapter;
        mContext = context;
        mResolver = mContext.getContentResolver();
    }

    @Override
    protected JSONArray doInBackground(String... urlStrings) {

        HttpURLConnection urlConnection   = null;
        BufferedReader    reader          = null;
        String 		      forecastJsonStr = null;

        try {
            URL weatherURL = new URL(urlStrings[0]);
            urlConnection  = (HttpURLConnection) weatherURL.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            InputStream inputStream = urlConnection.getInputStream();
            StringBuffer buffer     = new StringBuffer();

            if (inputStream != null) {
                reader = new BufferedReader(new InputStreamReader(inputStream));

                String line;
                while ((line = reader.readLine()) != null) {
                    buffer.append(line + "\n");
                }
                if (buffer.length() != 0) {
                    forecastJsonStr = buffer.toString();
                }
            }
        } catch (IOException e) {
            Log.e("MainActivity", "Error ", e);
        } finally{
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (final IOException e) {
                    Log.e("MainActivity", "Error closing stream", e);
                }
            }
        }

        try {
            return (new JSONObject(forecastJsonStr)).getJSONArray("list");
        } catch (JSONException e) {
            Log.e("FetchWeatherTask", e.getMessage(), e);
        }

        // This will only happen if there was an error getting or parsing the forecast.
        return null;
    }

    @Override
    protected void onPostExecute(JSONArray weatherInfo) {
        super.onPostExecute(weatherInfo);
        // ALSO, DON'T BE A DUMBFUCK AND CONFUSE .length VS .length(): ONE IS A FIELD OF ARRAYS,
        // THE OTHER A METHOD OF JSONArrayS AND WE'RE USING THE LATTER AND NOT THE FORMER!
        // (This is why program was't compiling yesternight, so that's where the anger is coming from.)
        for(int i=0; i<weatherInfo.length(); i++){
            try {
                Log.v("FetchWeatherTask", weatherInfo.getString(i));
            } catch (JSONException e){
                Log.e("onPostExecute", e.getMessage(), e);
            }
        }
        mWeatherAdapter.setWeatherData(weatherInfo);
    }

    public long addLocation(String locationSetting, String cityName, double lat, double lon){
        long locationId;
        Uri insertedUri;

        ContentValues locationValues = new ContentValues();

        locationValues.put(LocationEntry.COLUMN_CITY_NAME), cityName;
        locationValues.put(LocationEntry.COLUMN_LOCATION_SETTING, locationSetting);
        locationValues.put(LocationEntry.COLUMN_COORD_LAT, lat);
        locationValues.put(LocationEntry.COLUMN_COORD_LONG, lon);

        insertedUri = mResolver.insert(LocationEntry.CONTENT_URI, locationValues);

        return ContentUris.parseId(insertedUri);
    }

}