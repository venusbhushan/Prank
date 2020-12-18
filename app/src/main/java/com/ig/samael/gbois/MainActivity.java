package com.ig.samael.gbois;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {

    private AdView mAdView;

    public void btnclick(View view){
        EditText dollaramount = (EditText) findViewById(R.id.name);
        String dollars = dollaramount.getText().toString();
        Double doubleDollars = Double.parseDouble(dollars);
        if (doubleDollars == 1830097){
            MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.gha);
            mediaPlayer.start();
            String toasttext = "Congrats \nYou are a Gay!!!";

            Toast.makeText(this, toasttext, Toast.LENGTH_SHORT).show();
        }
        else if (doubleDollars == 1830198){
            String toasttext = "Sorry \n You are only Mallu";
            Toast.makeText(this, toasttext, Toast.LENGTH_SHORT).show();

        }
        else if (doubleDollars == 1830083){

            String toasttext = "Sorry \n You are only porny";
            Toast.makeText(this, toasttext, Toast.LENGTH_SHORT).show();

        }
        else{
            String toasttext = "Sorry You are neither gay nor porny nor mallu";
            Toast.makeText(this, toasttext, Toast.LENGTH_SHORT).show();
        }
    }

    ViewFlipper v_flipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//Start
        int images[] = {R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four, R.drawable.five,
                R.drawable.six, R.drawable.seven, R.drawable.eight, R.drawable.nine};

        v_flipper = findViewById(R.id.v_flipper);

        for(int image: images){
            flipperImages(image);
        }
    }
    public void flipperImages(int image){
        ImageView imageView= new ImageView(this);
        imageView.setBackgroundResource(image);

        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(1500);   //Timing
        v_flipper.setAutoStart(true);
//Animation h yaha
        v_flipper.setInAnimation(this,android.R.anim.slide_in_left);
        v_flipper.setOutAnimation(this,android.R.anim.slide_out_right);

        //End
        MobileAds.initialize(this,"ca-app-pub-7017995785445102~4063706584");
        mAdView=findViewById(R.id.adView);
        AdRequest adRequest=new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);
    }
}
