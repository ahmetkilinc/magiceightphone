package com.gobletsoft.magiceightphone;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.hardware.SensorManager;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.singh.daman.gentletoast.GentleToast;
import com.squareup.seismic.ShakeDetector;

import java.util.Random;

import pl.droidsonroids.gif.GifImageView;

public class maincontent extends AppCompatActivity implements ShakeDetector.Listener{

    public String[] answers = new String[25];
    private AdView mAdView;
    ActionBar actionBar;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        answers[0] = "It is certain!";
        answers[1] = "It is decidedly so...";
        answers[2] = "Without a doubt!";
        answers[3] = "Yes definitely.";
        answers[4] = "You may rely on it :)";
        answers[5] = "As I see it, yes!";
        answers[6] = "Most likely.";
        answers[7] = "lol. No way. ";
        answers[8] = "Yep!";
        answers[9] = "Signs point to yes. You lucky!";
        answers[10] = "Reply hazy try again :/";
        answers[23] = "Shake harder and ask again. ihi.";
        answers[11] = "Ask again later, I need to cool down.";
        answers[12] = "Better not tell you now. o.O";
        answers[13] = "Cannot predict now, sorry.";
        answers[14] = "Concentrate and ask again :|";
        answers[15] = "Don't count on it.";
        answers[16] = "My reply is no!";
        answers[17] = "My sources say no!";
        answers[18] = "Outlook not so good.";
        answers[19] = "Very doubtful!";
        answers[20] = "Maybe, but just maybe.";
        answers[21] = "Is water wet? Is the Sky Blue?";
        answers[22] = "Stop it. You know it's not gonna happen.";
        answers[24] = "I liked what you doin with your hands, #doitagain :#";

        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        ShakeDetector sd = new ShakeDetector(this);
        sd.start(sensorManager);

        setContentView(R.layout.activity_maincontent);

        actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#1C2331")));

        mAdView = (AdView) findViewById(R.id.adView2);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-0063127843759701/7441769079");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        GifImageView giv = findViewById(R.id.gifImageView);

        giv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Random rand = new Random();

                int  n = rand.nextInt(25) + 0;

                GentleToast.with(getApplicationContext())
                        .longToast(answers[n])
                        .setTextColor(R.color.white)
                        .setBackgroundColor(R.color.black)
                                .setBackgroundRadius(17)
                                .setStrokeColor(R.color.toastLines)
                                .setStrokeWidth(10)
                                .setImage(R.mipmap.ic_launcher)
                                .show();

                //Toast.makeText(getApplicationContext(), answers[n], Toast.LENGTH_LONG).show();

                if((n == 5) || (n == 10) || (n == 15)){

                    if (mInterstitialAd.isLoaded()) {

                        mInterstitialAd.show();
                    } else {

                        Log.d("TAG", "The interstitial wasn't loaded yet.");
                    }
                }
            }
        });

    }

    @Override public void hearShake() {

        Random rand = new Random();

        int  n = rand.nextInt(25) + 0;

        GentleToast.with(getApplicationContext())
                .longToast(answers[n])
                .setTextColor(R.color.white)
                .setBackgroundColor(R.color.black)
                .setBackgroundRadius(17)
                .setStrokeColor(R.color.toastLines)
                .setStrokeWidth(10)
                .setImage(R.mipmap.ic_launcher)
                .show();

        //Toast.makeText(this, answers[n], Toast.LENGTH_LONG).show();

        if((n == 5) || (n == 10) || (n == 15)){

            if (mInterstitialAd.isLoaded()) {

                mInterstitialAd.show();
            } else {

                Log.d("TAG", "The interstitial wasn't loaded yet.");
            }
        }
    }
}