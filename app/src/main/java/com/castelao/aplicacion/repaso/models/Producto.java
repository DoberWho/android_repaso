package com.castelao.aplicacion.repaso.models;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.widget.ImageButton;

import java.io.Serializable;

public class Producto implements Serializable {
    private int id;
    private String name;
    private int stock;
    private int precio;
    public Drawable img;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
