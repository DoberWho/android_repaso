package com.castelao.aplicacion.repaso.net;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.castelao.aplicacion.repaso.interfaces.PeliculasInterfaces;
import com.castelao.aplicacion.repaso.models.Pelicula;
import com.castelao.aplicacion.repaso.models.PeliculaRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.List;

public class NetworkVolley {
    private final Gson gson;
    private RequestQueue queue;
    private NetworkVolley(Context ctx){
        queue= Volley.newRequestQueue(ctx);
        gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
    }
    private static NetworkVolley instance;
    
    public static NetworkVolley init(Context ctx){
        if (instance == null){
            instance = new NetworkVolley(ctx);
        }
        return instance;
    }

    // https://www.omdbapi.com/?apikey=9fea2342&s=cars
    public void peticionGET(String url, final PeliculasInterfaces interfaz) throws IOException {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                PeliculaRequest dataReq = gson.fromJson(response, PeliculaRequest.class);
                List<Pelicula> lista = dataReq.getPeliculas();
                Integer contador = dataReq.getContador();
                if (interfaz != null){
                    interfaz.getPeliculas(lista, contador);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        queue.add(stringRequest);
    }

}
