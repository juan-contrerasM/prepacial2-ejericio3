package com.example.preparcial.model;

import java.io.Serializable;

public class Cliente implements Serializable {
    private String nombre;
    private String apellido;
    private String codigo;
    private String cedula;
    private String tipoDeId;
    private String telefono;

    public Cliente() {
    }

    public Cliente(String codigo, String cedula, String tipoDeId, String nombre, String apellido, String telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.codigo = codigo;
        this.cedula = cedula;
        this.tipoDeId = tipoDeId;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTipoDeId() {
        return tipoDeId;
    }

    public void setTipoDeId(String tipoDeId) {
        this.tipoDeId = tipoDeId;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
