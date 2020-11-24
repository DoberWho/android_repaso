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
    private Integer contador;

    @Expose
    @SerializedName("Response")
    private Boolean sinError;

    public List<Pelicula> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(List<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }

    public Integer getContador() {
        return contador;
    }

    public void setContador(Integer contador) {
        this.contador = contador;
    }

    public Boolean getSinError() {
        return sinError;
    }

    public void setSinError(Boolean sinError) {
        this.sinError = sinError;
    }
}
