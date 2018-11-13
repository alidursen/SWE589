package com.example.geyik.hw2_1;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class VH extends RecyclerView.ViewHolder {

    private TextView txtTop;
    private TextView txtBot;
    private ImageView img;

    public VH(View v){
        super(v);

        txtBot = v.findViewById(R.id.textViewBottom);
        txtTop = v.findViewById(R.id.textViewTop);
        img = v.findViewById(R.id.imageView);
    }

    void bindBotTxt(String s){ txtBot.setText(s); }
    void bindTopTxt(String s){ txtTop.setText(s); }
    void bindImg(Bitmap b){ img.setImageBitmap(b); }
}
