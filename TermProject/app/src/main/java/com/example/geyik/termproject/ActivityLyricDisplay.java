package com.example.geyik.termproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.android.welyre.R;

import org.w3c.dom.Text;

public class ActivityLyricDisplay extends AppCompatActivity {
    private TextView lyricView;

    String lyrics = "Woo! Di club is getting warmer\n" +
            "Guess who is back up in your corner\n" +
            "Love to see the girls dem winding up with dem Dolce and dem Gabbana\n" +
            "This is Elephant Man and Rihanna\n" +
            "Can I hear you say turn it up!\n" +
            "Mr. DJ Mr. DJ Mr. DJ Mr. DJ!\n" +
            "Tun it up! Mr. DJ Mr. DJ Mr. DJ Mr. DJ!\n" +
            "Can I hear everybody say (Tun it up!)\n" +
            "When you hear this tune a play (Tun it up!)\n" +
            "Tun it up Mr. DJ (Turn it up!)\n" +
            "This is Elephant Man and Rihanna, come on!\n" +
            "It goes one by one even two by two\n" +
            "Everybody on the floor let me show you how we do\n" +
            "Let's go dip it low then you bring it up slow\n" +
            "Wine it up one time wine it back once more\n" +
            "Come run, run, run, run, everybody move run\n" +
            "Let me see you move and rock it till the groove done\n" +
            "Shake it till the moon becomes the sun (SUN!)\n" +
            "Everybody in the club give me a run (RUN!)\n" +
            "If you ready to move say it (Yeah!)\n" +
            "One time for your mind say it (Yeah, Yeah!)\n" +
            "Well I'm ready for ya come let me show ya\n" +
            "You want to groove I'm a show you how to move, come come\n" +
            "Come Mr. DJ song pon de replay\n" +
            "Come Mr. DJ won't you turn the music up\n" +
            "All de gal pon de dancefloor wantin some more\n" +
            "Come Mr. DJ won't you turn the music up\n" +
            "Come Mr. DJ song pon de replay\n" +
            "Come Mr. DJ won't you turn the music up\n" +
            "All de gal pon de dancefloor wantin some more\n" +
            "Come Mr. DJ won't you turn the music up\n" +
            "Tun it up some more!\n" +
            "Tun it up! Tun it up! Tun it up! Tun it up! Tun it up! Tun it up! Tun it up! Tun it up!\n" +
            "Tun it up some more!\n" +
            "Tun it up! Tun it up! Tun it up! Tun it up! Tun it up! Tun it up! Tun it up! Tun it up! Tun it up!\n" +
            "Tun it up some more!\n" +
            "Tun it up! Tun it up! Tun it up! Tun it up! Tun it up! Tun it up! Tun it up! Tun it up! Tun it up!\n" +
            "Tun it up some more!\n" +
            "Tun it up! Tun it up! Tun it up! Tun it up! Tun it up! Tun it up! Tun it up! Tun it up! Tun it up!\n" +
            "It goes one by one even two by two\n" +
            "Everybody in the club 'gon be rockin when I'm through\n" +
            "Let the bass from the speakers run through ya sneakers\n" +
            "Move both ya feet and run to the beat\n" +
            "Come run, run, run, run , everybody move run\n" +
            "Let me see you move and rock it till the groove done\n" +
            "Shake it till the moon becomes the sun (SUN!)\n" +
            "Everybody in the club give me a run (RUN!)\n" +
            "If you ready to move say it (Yeah!)\n" +
            "One time for your mind say it (Yeah Yeah!)\n" +
            "Well I'm ready for ya come let me show ya\n" +
            "You want to groove I'm a show you how to move\n" +
            "Come Mr. DJ song pon de replay\n" +
            "Come Mr. DJ won't you turn the music up\n" +
            "All de gal pon de dancefloor wantin some more\n" +
            "Come Mr. DJ won't you turn the music up\n" +
            "Come Mr. DJ song pon de replay\n" +
            "Come Mr. DJ won't you turn the music up\n" +
            "All de gal pon de dancefloor wantin some more\n" +
            "Come Mr. DJ won't you turn the music up\n" +
            "Come on! Can I hear everybody say (Tun it up!)\n" +
            "When yuh hear this tune a play (Tun it up!)\n" +
            "Tun it up Mr. DJ (Tun it up!)\n" +
            "Tun it up tun it up till yuh bun it up, well!\n" +
            "Come on! Well, if yuh can take the pressure\n" +
            "Girls whinnin up and getting wetta\n" +
            "When you say fi turn it up we turn it up turn it up fi di betta\n" +
            "Dem haffi take we out pon a stretcha, come on\n" +
            "Ok, everybody get down if you feel me\n" +
            "Put your hands up to the ceiling\n" +
            "Everybody get down if you feel me\n" +
            "Come and put your hands up to the ceiling\n" +
            "Everybody get down if you feel me\n" +
            "Come and put your hands up to the ceiling\n" +
            "Everybody get down if you feel me\n" +
            "Come and put your hands up to the ceiling\n" +
            "Come Mr. DJ song pon de replay\n" +
            "Come Mr. DJ won't you turn the music up\n" +
            "All de gal pon de dancefloor wantin some more\n" +
            "Come Mr. DJ won't you turn the music up\n" +
            "Come Mr. DJ song pon de replay\n" +
            "Come Mr. DJ won't you turn the music up\n" +
            "All de gal pon de dancefloor wantin some more\n" +
            "Come Mr. DJ won't you turn the music up";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent starter;

        setContentView(R.layout.lyrics);
        lyricView = findViewById(R.id.lyricHolder);

        starter = getIntent();
        if (starter.hasExtra(Intent.EXTRA_TEXT)){
            //get data from API(EXTRA_TEXT)
            lyricView.setText(lyrics);
        }
        else lyricView.setText("Hello bug; my old friend.");
    }
}
