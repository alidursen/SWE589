package tr.com.mskr.sunshine22;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.JsonReader;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;

public class GreenAdapter extends RecyclerView.Adapter<ForecastViewHolder> {

/*      As far as adapters go, this one is fairly tame: it has a String[] which binds to holders
*   and it has its own ClickListener, which is obtained from MainActivity via constructor.
*   This ClickListener is then passed onto ViewHolders (like a child with grandparent's STD.)     */

    private int                   mNumberItems;
    private String[]              items;
    private ListItemClickListener mOnClickListener;

    public GreenAdapter(int numberOfItems, String[] itemList, ListItemClickListener listener) {
        mNumberItems     = numberOfItems;
        items            = itemList;
        mOnClickListener = listener;
    }

    @Override
    public ForecastViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context        context                         = parent.getContext();
        int            layoutIdForListItem             = R.layout.forecast_list_item;
        LayoutInflater inflater                        = LayoutInflater.from(context);
        boolean        shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, parent, shouldAttachToParentImmediately);
        ForecastViewHolder viewHolder = new ForecastViewHolder(view, mOnClickListener);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ForecastViewHolder holder, int position) {
        try {
            holder.bind(items[position]);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return mNumberItems;
    }

    public void setWeatherData(String[] weatherData) {
        items        = weatherData;
        mNumberItems = weatherData.length;
        notifyDataSetChanged();
    }

    public void setWeatherData(JSONArray jItems) {
        mNumberItems = jItems.length();
        items = new String[mNumberItems];
        for(int i=0; i<mNumberItems; i++){
            try{ items[i] = jItems.getString(i); }
            catch (JSONException e){ Log.e("onPostExecute", e.getMessage(), e); }
        }
        notifyDataSetChanged(); //DO NOT FORGET!!
    }
}
