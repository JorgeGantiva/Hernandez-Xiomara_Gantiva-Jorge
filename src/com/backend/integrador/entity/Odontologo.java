package com.backend.integrador.entity;

public class Odontologo {
    private int numeroMatricula;
    private String nombre;
    private String apellido;
    private int Id;

    public Odontologo(int numeroMatricula, String nombre, String apellido, int id) {
        this.numeroMatricula = numeroMatricula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.Id = id;
    }

    public int getNumeroMatricula() {
        return numeroMatricula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getId() {
        return Id;
    }

    public void setNumeroMatricula(int numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setId(int id) {
        Id = id;
    }
}

