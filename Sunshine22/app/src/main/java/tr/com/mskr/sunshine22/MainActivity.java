package tr.com.mskr.sunshine22;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements ListItemClickListener {

/*      ASSIGNMENT DESCRIPTION                                                                  *//*
 Modify the FetchWeatherTask class so that the RecyclerView object should show the pressure and
 humidity information for each day instead of minimum temperature, maximum temperature and the
 weather information.
    EXAMPLE: Each item in RecyclerView should say: "Sun Oct 22 Pr: 1018.6, Hum: 0%"
    HINT: You have to change the part where you get the max, min, main items inside the JSON object.

 Modify the whole project so that when an item in the RecyclerView is touched, the DetailActivity
 is opened with the following information of the touched item is shown as in the image given below:
    Date
    Day (the big temperature), Min, and Max temperatures
    Description of the weather information (e.g., Sunny, Rainy...)
    The weather icon corresponding to the openweathermap icons                                    */

//      PROPOSED SOLUTION
/*      The easiest and most sensible solution (though more data-consuming) is to feed ViewHolders
*   not only their displayed data, but whole JSON object for them to process instead. This way,
*   FetchWeatherTask does only what the name implies and leaves the formatting to whomever cares. */

//      ENCOUNTERED PROBLEMS AND DOCUMENTATION
/*  For general description, see:
*     * FetchWeatherTask.java; l:20
*     * GreenAdapter.java;     l:16
*     * On ForecastViewHolder.java, everything below l:44
*       is moved and modified from FetchWeatherTask.java
*   For problems (both solved and unsolved), see:
*     * FetchWeatherTask.java; l:29     (What are parameters on AsyncTask<X, Y, Z> ?)
*           For documentation, see:     https://developer.android.com/reference/android/os/AsyncTask
*     * FetchWeatherTask.java; l:92     (Be mindful of .length vs .length() )
*     * GreenAdapter.java;     l:70     (After data update, call notifyDataSetChanged() )
*     * DetailActivity.java;   l:50     (AsyncTask's come with their exceptions. How to handle?)
*     * FetchWeatherIcon.java; l:12     (Solution to draw from URL found at StackOverflow)        */


    private static final String   DEGREE              = "\u00b0";
    private static final int      FORECAST_LIST_ITEMS = 12;
    private              String[] FORECASTS           = {
            "Mon, Oct  9: 15"+DEGREE, "Tue, Oct 10: 17"+DEGREE, "Wed, Oct 11: 17"+DEGREE,
            "Thu, Oct 12: 19"+DEGREE, "Fri, Oct 13: 19"+DEGREE, "Sat, Oct 14: 18"+DEGREE,
            "Sun, Oct 15: 19"+DEGREE, "Mon, Oct 16: 22"+DEGREE, "Tue, Oct 17: 18"+DEGREE,
            "Wed, Oct 18: 21"+DEGREE, "Thu, Oct 19: 12"+DEGREE, "Fri, Oct 20: 22"+DEGREE};

    private GreenAdapter          mAdapter;
    private RecyclerView          mNumbersList;
    private DividerItemDecoration mDividerItemDecoration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mNumbersList                      = (RecyclerView) findViewById(R.id.rv_forecast);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        mNumbersList.setLayoutManager(layoutManager);
        mNumbersList.setHasFixedSize(true);
        mDividerItemDecoration = new DividerItemDecoration(mNumbersList.getContext(), layoutManager.getOrientation());
        mNumbersList.addItemDecoration(mDividerItemDecoration);

        mAdapter = new GreenAdapter(FORECAST_LIST_ITEMS, FORECASTS, this);
        mNumbersList.setAdapter(mAdapter);

        String weatherAPIKey    = "1b3a6d183e0681e26f960c86ee271000";
        String weatherURLString = "http://api.openweathermap.org/data/2.5/forecast/" +
                "daily?" +
                "q=London" +
                "&mode=JSON" +
                "&units=metric" +
                "&cnt=12" +
                "&APPID="+weatherAPIKey;

        FetchWeatherTask weatherTask = new FetchWeatherTask(mAdapter);
        weatherTask.execute(weatherURLString);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onListItemClick(int clickedItemIndex, Intent source) {
        Log.v("MainActivity.onCreate", "Item#"+Integer.toString(clickedItemIndex));
        Intent detailActivityIntent = new Intent(MainActivity.this, DetailActivity.class);
        detailActivityIntent.putExtras(source);
        startActivity(detailActivityIntent);
    }

    @Override
    public void onListItemClick(int clickedItemIndex){
        Log.v("MainActivity.onCreate", "Item#"+Integer.toString(clickedItemIndex));
        Intent detailActivityIntent = new Intent(MainActivity.this, DetailActivity.class);
        detailActivityIntent.putExtra(Intent.EXTRA_TEXT, "DETAILED WEATHER INFO");
        startActivity(detailActivityIntent);
    }
}