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

    public String[] answers = new String[30];
    private AdView mAdView;
    ActionBar actionBar;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        answers[0] = getString(R.string.answer1);
        answers[1] = getString(R.string.answer2);
        answers[2] = getString(R.string.answer3);
        answers[3] = getString(R.string.answer4);
        answers[4] = getString(R.string.answer5);
        answers[5] = getString(R.string.answer6);
        answers[6] = getString(R.string.answer7);
        answers[7] = getString(R.string.answer8);
        answers[8] = getString(R.string.answer9);
        answers[9] = getString(R.string.answer10);
        answers[10] = getString(R.string.answer11);
        answers[23] = getString(R.string.answer12);
        answers[11] = getString(R.string.answer13);
        answers[12] = getString(R.string.answer14);
        answers[13] = getString(R.string.answer15);
        answers[14] = getString(R.string.answer16);
        answers[15] = getString(R.string.answer17);
        answers[16] = getString(R.string.answer18);
        answers[17] = getString(R.string.answer19);
        answers[18] = getString(R.string.answer20);
        answers[19] = getString(R.string.answer21);
        answers[20] = getString(R.string.answer22);
        answers[21] = getString(R.string.answer23);
        answers[22] = getString(R.string.answer24);
        answers[24] = getString(R.string.answer25);
        answers[25] = getString(R.string.answer26);
        answers[26] = getString(R.string.answer27);
        answers[27] = getString(R.string.answer28);
        answers[28] = getString(R.string.answer29);
        answers[29] = getString(R.string.answer30);

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

                int  n = rand.nextInt(28) + 0;

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