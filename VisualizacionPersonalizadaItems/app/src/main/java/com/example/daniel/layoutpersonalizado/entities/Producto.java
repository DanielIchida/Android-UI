package com.example.daniel.layoutpersonalizado.entities;


public class Producto {

    private String nombre;
    private int imagen;

    public Producto(String nombre, int imagen) {
        this.nombre = nombre;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public int getImagen() {
        return imagen;
    }
}
