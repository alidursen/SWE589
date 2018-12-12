package tr.com.mskr.sunshine22;

import SQLiteOpenHelper;

public class WeatherDbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "weather.db";

    public WeatherDbHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase){
        final String SQL_CREATE_LOCATION=TABLE = "CREATE TABLE " ...
        final String SQL_CREATE_WEATHER_TABLE = "CREATE TABLE " ...

        sqLite
    }
}
