package com.example.testaplication.tarea4;

import java.io.Serializable;

public class Distro implements Serializable {

    public static final long serialVersionUID = 987654321L;

    private Integer imagen;
    private String nombre;
    private String descripcion;
    private String paquete;
    private String lanzamiento;

    private Distro() {
        this.imagen = 0;
        this.nombre = "";
        this.descripcion = "";
        this.paquete = "";
        this.lanzamiento = "";
    }

    private Distro(Integer imagen) {
        this.imagen = imagen;
    }

    private Distro(Integer imagen, String nombre) {
        this(imagen);
        this.nombre = nombre;
    }

    private Distro(Integer imagen, String nombre, String paquete) {
        this(imagen,nombre);
        this.paquete = paquete;
    }

    private Distro(Integer imagen, String nombre, String paquete, String lanzamiento) {
        this(imagen,nombre, paquete);
        this.lanzamiento = lanzamiento;
    }

    public Distro(Integer imagen, String nombre, String paquete, String lanzamiento, String descripcion) {
        this(imagen,nombre, paquete, lanzamiento);
        this.descripcion = descripcion;
    }

    public Integer getImagen() {
        return imagen;
    }

    public void setImagen(Integer imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPaquete() {
        return paquete;
    }

    public void setPaquete(String paquete) {
        this.paquete = paquete;
    }

    public String getLanzamiento() {
        return lanzamiento;
    }

    public void setLanzamiento(String lanzamiento) {
        this.lanzamiento = lanzamiento;
    }
}
