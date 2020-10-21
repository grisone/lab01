package com.example.testaplication.tarea4;

import java.io.Serializable;

public class Distro implements Serializable {

    public static final long serialVersionUID = 987654321L;

    private String nombre;
    private Integer ano;
    private String descripcion;

    public Distro(String nombre, Integer ano, String descripcion) {
        this.nombre = nombre;
        this.ano = ano;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
