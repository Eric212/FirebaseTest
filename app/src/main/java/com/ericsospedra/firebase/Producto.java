package com.ericsospedra.firebase;

public class Producto {
    private String nombre;
    private String imagen;
    private Categoria categoria;
    private float precio;

    public Producto() {
   }


    public Producto(String nombre, String imagen, Categoria categoria, float precio) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.categoria = categoria;
        this.precio = precio;
    }

    public float getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", imagen='" + imagen + '\'' +
                ", categoria=" + categoria +
                ", precio=" + precio +
                '}';
    }
}
