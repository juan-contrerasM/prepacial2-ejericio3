package com.example.preparcial.model;

import java.io.Serializable;

public class Productos implements Serializable {
    private String codigo;
    private String nombre;
    private float precio;


    public Productos(String nombre, String codigo, float precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;

    }



    public Productos(){

    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
}
