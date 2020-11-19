package com.castelao.aplicacion.repaso;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.castelao.aplicacion.repaso.adapters.ProductoAdapter;
import com.castelao.aplicacion.repaso.models.Producto;

import java.util.ArrayList;
import java.util.List;

public class AdapterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_adapter);

        initViews();
    }

    private void initViews() {
        RecyclerView contendor = findViewById(R.id.act_adapter_content_rec);

        // Lista Vertical
        RecyclerView.LayoutManager manageVertical1 = new LinearLayoutManager(this);
        LinearLayoutManager manageVertical2 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        // Lista Horizontal
        LinearLayoutManager manageHorizontal = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        // Parrilla de 3 Columnas
        GridLayoutManager managerGrid = new GridLayoutManager(this, 3);

        contendor.setLayoutManager(manageHorizontal);


        List<Producto> items = new ArrayList<>();

        Producto prod1 = new Producto();
        prod1.setName("Producto 1");
        prod1.img = getDrawable(R.mipmap.alien_walk);
        items.add(prod1);

        Producto prod2 = new Producto();
        prod2.setName("Producto 2");
        prod2.img = getDrawable(R.mipmap.ic_launcher);
        items.add(prod2);

        Producto prod3 = new Producto();
        prod3.setName("Producto 3");
        prod3.img = getDrawable(R.drawable.ic_launcher_foreground);
        items.add(prod3);

        Producto prod4 = new Producto();
        prod4.setName("Producto 4");
        prod4.img = getDrawable(R.drawable.ic_launcher_background);
        items.add(prod4);

        Producto prod5 = new Producto();
        prod5.setName("Producto 5");
        prod5.img = getDrawable(R.mipmap.ic_launcher_round);
        items.add(prod5);

        ProductoAdapter adapter = new ProductoAdapter(this, items);
        contendor.setAdapter(adapter);

    }
}