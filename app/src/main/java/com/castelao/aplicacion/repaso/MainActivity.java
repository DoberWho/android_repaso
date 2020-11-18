package com.castelao.aplicacion.repaso;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.castelao.aplicacion.repaso.models.Producto;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Z
        initButtons();
        ejemplosCodigo();
    }

    private void ejemplosCodigo() {
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

    private void initButtons() {
        final EditText edt = this.findViewById(R.id.act_main_edt);

        Button btn = this.findViewById(R.id.act_main_boton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt = edt.getText().toString();
                cambiarDeActivity();
            }
        });


    }

    private void cambiarDeActivity() {

        Producto prod = new Producto();

        Intent intent = new Intent(this, ProductoActivity.class);
        intent.putExtra(ProductoActivity.INTENT_PRODUCTO, prod);
        startActivity(intent);
    }
}