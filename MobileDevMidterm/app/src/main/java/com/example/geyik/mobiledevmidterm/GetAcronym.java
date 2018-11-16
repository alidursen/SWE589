package com.example.geyik.mobiledevmidterm;

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

public class GetAcronym extends AsyncTask<String, Void, JSONArray> {

    String acronymURL;

    public GetAcronym(String acronym) {
        this.acronymURL = "http://www.nactem.ac.uk/software/acromine/dictionary.py?sf=" + acronym;
    }

    @Override
    protected JSONArray doInBackground(String... inStrings) {
        HttpURLConnection urlConnection   = null;
        BufferedReader reader          = null;
        String 		      forecastJsonStr = null;

        try {
            URL weatherURL = new URL(acronymURL);
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
            return (new JSONArray(forecastJsonStr));
        } catch (JSONException e) {
            Log.e("midterm", e.getMessage(), e);
        }

        // This will only happen if there was an error getting or parsing the forecast.
        return null;
    }
}
