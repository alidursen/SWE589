package com.example.geyik.hw1;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView txt = findViewById(R.id.txt);

        FloatingActionButton fU = findViewById(R.id.fabUp);
        fU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt.setTextSize(24);
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:47.6, -122.3"));
                if (intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                }
            }
        });

        FloatingActionButton fL = findViewById(R.id.fabDown);
        fL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt.setTextSize(12);
            }
        });
    }

}
