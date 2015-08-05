package com.rpolicante.exampleusespermission;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.rpolicante.checkmanifestusespermisson.CheckManifest;

public class IntroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        if (!CheckManifest.cameraIsAllowed(this)){
            Log.i("INTROACTIVIY","Camera is not Allowed");
        }else{
            Log.i("INTROACTIVIY","Camera is Allowed");
        }

    }

}
