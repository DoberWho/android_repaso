package com.castelao.aplicacion.repaso.net;

import com.castelao.aplicacion.repaso.interfaces.PeliculasInterfaces;
import com.castelao.aplicacion.repaso.models.PeliculaRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkRetrofit {
    //https://www.omdbapi.com/?apikey=9fea2342&s=cars
    private final Retrofit retrofit;

    private NetworkRetrofit(){
        retrofit = new Retrofit.Builder()
                .baseUrl("https://www.omdbapi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    private static NetworkRetrofit instance;

    public static NetworkRetrofit init(){
        if (instance == null){
            instance = new NetworkRetrofit();
        }
        return instance;
    }

    // https://www.omdbapi.com/?apikey=9fea2342&s=cars
    public void peticionGET(String search, Integer page, final PeliculasInterfaces interfaz) throws IOException {
        OmdbService service = retrofit.create(OmdbService.class);

        Call<PeliculaRequest> obj3 = service.listWithQuery(search, "9fea2342", page);

        obj3.enqueue(new Callback<PeliculaRequest>() {
            @Override
            public void onResponse(Call<PeliculaRequest> call, Response<PeliculaRequest> response) {
                PeliculaRequest body = response.body();
                if (interfaz != null){
                    interfaz.getPeliculas(body.getPeliculas(), body.getContador());
                }
            }

            @Override
            public void onFailure(Call<PeliculaRequest> call, Throwable t) {
                t.printStackTrace();
            }
        });


    }
}
