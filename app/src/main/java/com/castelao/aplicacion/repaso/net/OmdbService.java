package com.castelao.aplicacion.repaso.net;

import com.castelao.aplicacion.repaso.models.PeliculaRequest;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OmdbService {

    //?apikey=9fea2342&s=cars&page=1
    @GET("/")
    Call<PeliculaRequest> listWithQuery(@Query("s") String search, @Query("apikey") String apikey, @Query("page") Integer page);


}
