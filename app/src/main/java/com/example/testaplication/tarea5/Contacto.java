package com.example.testaplication.tarea5;

import java.io.Serializable;

public class Contacto implements Serializable {

    public static final String MASCULINO = "M";
    public static final String FEMENINO = "F";

    public static final long serialVersionUID = 7687628768732L;

    private Integer id;
    private String nombre;
    private String paterno;
    private String materno;
    private String telefono;
    private String sexo;

    public Contacto() {
        this.id = 0;
        this.nombre = "";
        this.paterno = "";
        this.materno = "";
        this.telefono = "";
        this.sexo = MASCULINO;
    }

    private Contacto(Integer id) {
        this.id = id;
    }

    private Contacto(Integer id, String nombre) {
        this(id);
        this.nombre = nombre;
    }

    private Contacto(Integer id, String nombre, String paterno) {
        this(id, nombre);
        this.paterno = paterno;
    }

    private Contacto(Integer id, String nombre, String paterno, String materno) {
        this(id,nombre, paterno);
        this.materno = materno;
    }

    public Contacto(Integer id, String nombre, String paterno, String materno, String telefono) {
        this(id, nombre, paterno, materno);
        this.telefono = telefono;
    }

    public Contacto(Integer id, String nombre, String paterno, String materno, String telefono, String sexo) {
        this(id, nombre, paterno, materno, telefono);
        this.sexo = sexo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNombreCompleto() {
        return this.getNombre()+" "+this.getPaterno()+" "+this.getMaterno();
    }

}
