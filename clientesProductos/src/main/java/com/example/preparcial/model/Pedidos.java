package com.example.preparcial.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Pedidos implements Serializable {
    private LocalDate fecha;
    private Cliente cliente;
    private Productos productos;
    private float total ;

    public Pedidos(LocalDate fecha, Cliente cliente, Productos productos,float total) {
        this.fecha = fecha;
        this.cliente = cliente;
        this.productos = productos;
        this.total=total;
    }

    public Pedidos() {
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }
}
