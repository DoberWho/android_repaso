package com.castelao.aplicacion.repaso;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.castelao.aplicacion.repaso.models.Producto;

public class ProductoActivity extends AppCompatActivity {

    public static String INTENT_PRODUCTO = "producto enviado por el intent a través del eter";
    private Producto prod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_producto);

        prod = (Producto) getIntent().getExtras().get(INTENT_PRODUCTO);
        initViews();
    }

    private void initViews() {
        TextView txtName = findViewById(R.id.act_producto_name);
        txtName.setText(prod.getName());
    }
}