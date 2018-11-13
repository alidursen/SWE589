package tr.com.mskr.sunshine22;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;

import static android.content.Intent.EXTRA_TEXT;

public class ForecastViewHolder extends RecyclerView.ViewHolder
implements View.OnClickListener{

    private  ListItemClickListener mListener;
    public   TextView              listItemForecastView;
    public Intent forecastIntent = new Intent();

    public ForecastViewHolder(View itemView, ListItemClickListener listener) {
        super(itemView);
        listItemForecastView = itemView.findViewById(R.id.tv_item_forecast);
        mListener            = listener;
        itemView.setOnClickListener(this);
    }

    void bind(String s)
            throws JSONException {
        if (s.charAt(0)=='{'){
            JSONObject weather = new JSONObject(s);
            getWeatherDataFromJson(weather);
        }
        else listItemForecastView.setText(s);
    }

    @Override
    public void onClick(View view) {
        mListener.onListItemClick(getAdapterPosition(), forecastIntent);
    }

    private void getWeatherDataFromJson(JSONObject jWeather)
            throws JSONException {
        final String OWM_WEATHER        = "weather";
        final String OWM_TEMPERATURE    = "temp";
        final String OWM_MAX            = "max";
        final String OWM_MIN            = "min";
        final String OWM_DESCRIPTION    = "main";
        final String OWM_DATETIME       = "dt";
        final String OWM_HUMID          = "humidity";
        final String OWM_PRESS          = "pressure";
        final int    SEC_TO_MILISEC     = 1000;

        JSONObject    weatherObject     = jWeather.getJSONArray(OWM_WEATHER).getJSONObject(0);
        JSONObject    temperatureObject = jWeather.getJSONObject(OWM_TEMPERATURE);

        double high       = temperatureObject.getDouble(OWM_MAX);
        double low        = temperatureObject.getDouble(OWM_MIN);
        double day        = temperatureObject.getDouble("day");
        String icon       = weatherObject.getString("icon");
        String highAndLow = formatHighLows(high, low);
        double humid      = jWeather.getDouble(OWM_HUMID);
        double press      = jWeather.getDouble(OWM_PRESS);
        long   dateTime   = jWeather.getLong(OWM_DATETIME)*SEC_TO_MILISEC;
        String desc     = weatherObject.getString(OWM_DESCRIPTION);
        String dayt = getReadableDateString(dateTime);
        String sDisplay = dayt + " | " + Math.round(press) + " hPa | " + Math.round(humid) + "%";
        String dayFormatted = String.valueOf(Math.round(day)) + '\u00b0';
        String[] sExtra = { dayt, dayFormatted, highAndLow, desc, icon };
        forecastIntent.putExtra(EXTRA_TEXT, sExtra);
        listItemForecastView.setText(sDisplay);
    }

    private String formatHighLows(double high, double low) {
        String   DEGREE   = "\u00b0";

        long roundedHigh  = Math.round(high);
        long roundedLow   = Math.round(low);

        String highLowStr = roundedHigh + DEGREE + "/" + roundedLow + DEGREE;

        return highLowStr;
    }

    private String getReadableDateString(long time){
        SimpleDateFormat shortenedDateFormat = new SimpleDateFormat("EEE MMM dd");
        return shortenedDateFormat.format(time);
    }
}