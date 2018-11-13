package tr.com.mskr.sunshine22;

import android.content.Intent;

public interface ListItemClickListener {
    void onListItemClick (int clickedItemIndex);
    void onListItemClick(int clickedPosition, Intent forecastIntent);
}
