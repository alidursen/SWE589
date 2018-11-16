package tr.com.mskr.sunshine22;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static android.content.Intent.EXTRA_TEXT;

public class DetailActivity extends AppCompatActivity {

    private TextView mDayTemp;
    private TextView mMinmaxTemp;
    private TextView mDescr;
    private TextView mDate;
    private ImageView mIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Intent   intentThatStartedThisActivity;
        String[] forecastDetailStr;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mDayTemp = findViewById(R.id.tv_detail_dayTemp);
        mMinmaxTemp = findViewById(R.id.tv_detail_minmaxTemp);
        mDescr = findViewById(R.id.tv_detail_wDescription);
        mDate = findViewById(R.id.tv_detail_date);
        mIcon = findViewById(R.id.iv_detail_wIcon);
        intentThatStartedThisActivity = getIntent();

        if (intentThatStartedThisActivity.hasExtra(EXTRA_TEXT)){
            forecastDetailStr = intentThatStartedThisActivity.getStringArrayExtra(EXTRA_TEXT);
            if(forecastDetailStr.length == 5){
                mDayTemp.setText(forecastDetailStr[1]);
                mDescr.setText(forecastDetailStr[3]);
                mMinmaxTemp.setText(forecastDetailStr[2]);

                String iconLoc = "http://openweathermap.org/img/w/" + forecastDetailStr[4] + ".png";
                try {
                    mIcon.setImageBitmap((new FetchWeatherIcon())
                            .execute(iconLoc).get(2, TimeUnit.SECONDS));
                }   //What are these exceptions?
                catch (InterruptedException | TimeoutException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
            mDate.setText(forecastDetailStr[0]);
            Log.v("DetailActivity.onCreate", forecastDetailStr[0]);
        }
        else{
            mDayTemp.setText("NO WEATHER DATA");
        }
    }
}
