package com.castelao.aplicacion.repaso.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PeliculaRequest {

    @Expose
    @SerializedName("Search")
    private List<Pelicula> peliculas;

    @Expose
    @SerializedName("totalResults")
    private String contador;

    @Expose
    @SerializedName("Response")
    private String sinError;

    public List<Pelicula> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(List<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }

    public String getContador() {
        return contador;
    }

    public void setContador(String contador) {
        this.contador = contador;
    }

    public String getSinError() {
        return sinError;
    }

    public void setSinError(String sinError) {
        this.sinError = sinError;
    }
}
