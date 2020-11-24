package com.castelao.aplicacion.repaso;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.StrictMode;

import com.castelao.aplicacion.repaso.adapters.PeliculaAdapter;
import com.castelao.aplicacion.repaso.adapters.ProductoAdapter;
import com.castelao.aplicacion.repaso.interfaces.PeliculasInterfaces;
import com.castelao.aplicacion.repaso.models.Pelicula;
import com.castelao.aplicacion.repaso.models.Producto;
import com.castelao.aplicacion.repaso.net.Network;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AdapterActivity extends AppCompatActivity {

    private RecyclerView contendor;
    private Activity ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_adapter);
        ctx = this;

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        initViews();
        updateAdapter();
    }

    private void updateAdapter() {


        PeliculasInterfaces interfaz = new PeliculasInterfaces() {
            @Override
            public void getPeliculas(final List<Pelicula> lista) {

                runOnUiThread(new Runnable() {
                    public void run() {
                        PeliculaAdapter adapter = new PeliculaAdapter(ctx, lista);
                        contendor.setAdapter(adapter);
                    }
                });
            }
        };

        String url = "https://www.omdbapi.com/?apikey=9fea2342&s=cars";
        Network net = Network.init();
        try {
            net.peticionGET(url, interfaz);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initViews() {
        contendor = findViewById(R.id.act_adapter_content_rec);

        // Lista Vertical
        RecyclerView.LayoutManager manageVertical1 = new LinearLayoutManager(this);
        LinearLayoutManager manageVertical2 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        // Lista Horizontal
        LinearLayoutManager manageHorizontal = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        // Parrilla de 3 Columnas
        GridLayoutManager managerGrid = new GridLayoutManager(this, 3);

        contendor.setLayoutManager(managerGrid);

    }
}