package com.example.geyik.hw1_3;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView img = findViewById(R.id.imageView);

/*      NOTE TO SELF: THIS IS NOT WHAT YOU THINK IT IS
*       ie. it does not create a "color state list" (whatever that means)
*       with only the input color.
*
*       img.setImageTintList(ColorStateList.valueOf(0x00ffffff));
*
*       On that note, let it be known that, instead of creating a COLOR folder
*       under RES and then placing colors in, we can use COLORS.XML under VALUES.
*       This may be IDE specific, but doing so places a small rectangle next to
*       line it was used.
*       Of course, it's possible that color folder and ColorStateList's may be needed
*       for more complex situations. */

//      WHITE  = 0xFFFFFF;
//      ORANGE = 0xFFA500;

        Switch visib = findViewById(R.id.switch1);
        visib.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) img.setVisibility(View.VISIBLE);
                else img.setVisibility(View.INVISIBLE);
            }
        });

        Switch tint = findViewById(R.id.switch2);
        tint.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) img.setImageTintList(getResources().getColorStateList(R.color.orange));
//      You want to obtain NO_TINT by... not by setImageTintList(~WHITE~) but by setImageTintList(null)
                else img.setImageTintList(null);
            }
        });


        final Switch tintMode = findViewById(R.id.switch3);
        tintMode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) img.setImageTintMode(PorterDuff.Mode.SCREEN);
                else img.setImageTintMode(PorterDuff.Mode.MULTIPLY);
            }
        });

    }
}
