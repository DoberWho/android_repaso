package com.castelao.aplicacion.repaso;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String hello = this.getString(R.string.hola);
        Log.d("I18N", hello);

        int colotInt = R.color.colorPrimary;
        int color = getColor(R.color.colorPrimary);
        Color colorData = Color.valueOf(color);
        Log.d("COLOR", "COlor1: "+colotInt);
        Log.d("COLOR", "COlor2: "+color);
        Log.d("COLOR", "COlor3: "+colorData.toString());
        Log.d("COLOR", "COlor4: "+colorData.toArgb());
    }
}