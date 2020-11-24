package com.castelao.aplicacion.repaso.net;

import android.util.Log;

import com.castelao.aplicacion.repaso.interfaces.PeliculasInterfaces;
import com.castelao.aplicacion.repaso.models.Pelicula;
import com.castelao.aplicacion.repaso.models.PeliculaRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class Network {
    private OkHttpClient client;
    private Network(){
        client = new OkHttpClient();
    }
    private static Network instance;

    public static Network init(){
        if (instance == null){
            instance = new Network();
        }
        return instance;
    }

    // https://www.omdbapi.com/?apikey=9fea2342&s=cars
    public void peticionGET(String url, final PeliculasInterfaces interfaz) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        // ASINCRONA
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String data = response.body().string();
                Log.d("OKHTTP", "DATA: "+data);


                Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
                PeliculaRequest dataReq = gson.fromJson(data, PeliculaRequest.class);
                List<Pelicula> lista = dataReq.getPeliculas();
                Integer contador = dataReq.getContador();
                Log.d("OKHTTP", "Peliculas: "+lista.size());

                if (interfaz != null){
                    interfaz.getPeliculas(lista, contador);
                }
            }

            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                //java.net.SocketException: socket failed: EPERM (Operation not permitted)
                 e.printStackTrace();
            }
        });
    }


}
