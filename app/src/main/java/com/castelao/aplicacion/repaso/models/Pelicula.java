package com.castelao.aplicacion.repaso.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pelicula {

    @Expose
    @SerializedName("Title")
    private String titulo = "";


    @Expose
    @SerializedName("Year")
    private String lanzamiento = "";

    @Expose
    @SerializedName("imdbID")
    private String imdb = "";

    @Expose
    @SerializedName("Type")
    private String tipo = "";

    @Expose
    @SerializedName("Poster")
    private String imagen = "";

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getLanzamiento() {
        return lanzamiento;
    }

    public void setLanzamiento(String lanzamiento) {
        this.lanzamiento = lanzamiento;
    }

    public String getImdb() {
        return imdb;
    }

    public void setImdb(String imdb) {
        this.imdb = imdb;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
