package com.castelao.aplicacion.repaso;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.castelao.aplicacion.repaso.adapters.PeliculaAdapter;
import com.castelao.aplicacion.repaso.adapters.ProductoAdapter;
import com.castelao.aplicacion.repaso.interfaces.PeliculasInterfaces;
import com.castelao.aplicacion.repaso.models.Pelicula;
import com.castelao.aplicacion.repaso.models.Producto;
import com.castelao.aplicacion.repaso.net.Network;
import com.castelao.aplicacion.repaso.net.NetworkRetrofit;
import com.castelao.aplicacion.repaso.net.NetworkVolley;
import com.castelao.aplicacion.repaso.tools.BaseActivity;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AdapterActivity extends BaseActivity {

    private RecyclerView contendor;
    private Activity ctx;
    private ImageButton btnPrev, btnNext;
    private TextView txtCurrentPage, amountItems, maxPage;

    private int currentPage = 1;
    private int maxPages = 1;
    private int totalItems = 1;
    private String search = "";
    private EditText edtSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_adapter);
        ctx = this;

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        initViews();
        initButtons();
        updateAdapter();
    }

    private void initButtons() {

        edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    search = charSequence.toString();
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (search == null || search.trim().isEmpty()){
                    return;
                }

                updateAdapter();
            }
        });

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentPage = currentPage - 1;
                if (currentPage <= 0){
                    currentPage = 1;
                }
                updateAdapter();
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                currentPage = currentPage + 1;
                updateAdapter();
            }
        });

    }

    private void updateAdapter() {

        PeliculasInterfaces interfaz = new PeliculasInterfaces() {
            @Override
            public void getPeliculas(final List<Pelicula> lista, final Integer maxItems) {

                if (maxItems == null || lista == null){
                    return;
                }

                runOnUiThread(new Runnable() {
                    public void run() {

                        totalItems = maxItems;
                        maxPages = (maxItems / lista.size());

                        txtCurrentPage.setText(""+currentPage);
                        amountItems.setText(""+totalItems);
                        maxPage.setText(""+maxPages);

                        PeliculaAdapter adapter = new PeliculaAdapter(ctx, lista);
                        contendor.setAdapter(adapter);
                    }
                });
            }
        };

        NetworkRetrofit net = NetworkRetrofit.init();
        try {
            net.peticionGET(search, currentPage, interfaz);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void initViews() {
        edtSearch = findViewById(R.id.act_adapter_search_edt);

        contendor = findViewById(R.id.act_adapter_content_rec);

        // Lista Vertical
        RecyclerView.LayoutManager manageVertical1 = new LinearLayoutManager(this);
        LinearLayoutManager manageVertical2 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        // Lista Horizontal
        LinearLayoutManager manageHorizontal = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);

        // Parrilla de 3 Columnas
        GridLayoutManager managerGrid = new GridLayoutManager(this, 3);

        contendor.setLayoutManager(managerGrid);


        btnPrev = findViewById(R.id.act_adapter_prev_btn);
        btnNext = findViewById(R.id.act_adapter_next_btn);
        txtCurrentPage = findViewById(R.id.act_adapter_current);
        amountItems = findViewById(R.id.act_adapter_total );
        maxPage = findViewById(R.id.act_adapter_max);


        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }
}