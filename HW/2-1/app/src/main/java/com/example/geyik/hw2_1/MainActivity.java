package com.example.geyik.hw2_1;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

/*      Let this be a note keeping section. So what is going on here?
*   In MAIN we have an instance mrv of class RecyclerView. We contextualize it to rv_img_n_txt.
*   We then create a LayoutManager llm and assign it to manage mrv. This so far is only related to RV.
*
*       Next: create an instance mrv_a of this new class we constructed, RV_Adapter.
*   What's the deal with RV_Adapter? It is a class extending RecyclerView.Adapter's of type VH.
*   THEN what is VH? (Besides being another class that we constructed)
*
*       VH is simply a class extending RecyclerView.ViewHolder
*   Thus going backwards: Each item will be held in an instance of VH.
*   Communication between those and mrv will be managed by adapter mrv_a.
*   This means how each item will appear within RV is responsibility of VH.
*   AND that is why it needs to be informed of rv_layout.xml (On that note it may have
*   been a poor name, given that it's not of rv but vh. Regardless, keep it as it is.)
*
*       Additional resources in addition to lecture slides:
*   https://developer.android.com/guide/topics/ui/layout/recyclerview
*   https://stackoverflow.com/a/40584425
*
*       For a long while app crashed on startup. Finally checking "Run" tab at the bottom
*   showed me the fault: getResources(), which is in fact this.getResources() was trying to
*   reach a null object. So question is: is there a practical way to statically create
*   image files before initializing onCreate?
*/

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //DATA INITIALIZATION
        int COUNT = 16;
        final Bitmap[] RECYCLER_IMAGES = {
                BitmapFactory.decodeResource(getResources(), R.drawable.motorhead),
                BitmapFactory.decodeResource(getResources(), R.drawable.overkill),
                BitmapFactory.decodeResource(getResources(), R.drawable.bomber),
                BitmapFactory.decodeResource(getResources(), R.drawable.ace_of_spades),
                BitmapFactory.decodeResource(getResources(), R.drawable.iron_fist),
                BitmapFactory.decodeResource(getResources(), R.drawable.another_perfect_day),
                BitmapFactory.decodeResource(getResources(), R.drawable.orgasmatron),
                BitmapFactory.decodeResource(getResources(), R.drawable.rock_n_roll),
                BitmapFactory.decodeResource(getResources(), R.drawable._1916),
                BitmapFactory.decodeResource(getResources(), R.drawable.march_or_die),
                BitmapFactory.decodeResource(getResources(), R.drawable.bastards),
                BitmapFactory.decodeResource(getResources(), R.drawable.sacrifice),
                BitmapFactory.decodeResource(getResources(), R.drawable.overnight_sensation),
                BitmapFactory.decodeResource(getResources(), R.drawable.snake_bite_love),
                BitmapFactory.decodeResource(getResources(), R.drawable.we_are_motorhead),
                BitmapFactory.decodeResource(getResources(), R.drawable.hammered)
        };
        final String[] RECYCLER_BOTTOM_TEXT = {"1977","1979","1979","1980","1982","1983","1986","1987",
                "1991","1992","1993","1995","1996","1998","2000","2002"};
        final String[] RECYCLER_TOP_TEXT = {"Motörhead","Overkill","Bomber","Ace of Spades",
                "Iron Fist","Another Perfect Day","Orgasmatron","Rock 'n' Roll",
                "1916","March ör Die","Bastards","Sacrifice",
                "Overnight Sensation","Snake Bite Love","We Are Motörhead","Hammered"};


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //SETTING RecyclerView UP; mrv STANDING FOR MainRecyclerView
        RecyclerView mrv = findViewById(R.id.rv_img_n_txt);
        StaggeredGridLayoutManager sglm = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mrv.setLayoutManager(sglm);
        mrv.setHasFixedSize(true); // Do we need that?

        //SETTING Adapter UP;
        RV_Adapter mrv_a = new RV_Adapter(COUNT, RECYCLER_TOP_TEXT, RECYCLER_BOTTOM_TEXT, RECYCLER_IMAGES, this);
        mrv.setAdapter(mrv_a);
    }
}
