package com.example.cdpezsierra.modelos.clases;

import jakarta.persistence.*;

@Entity
@Table(name = "DescripcionEntrenamiento")
public class DescripcionEntrenamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_descripcion;

    private String nombre_ejercicio;
    private String descripcion_ejercicio;
    private Integer repeticiones;
    private String objetivo;
    private String duracion_estimada;
    private String materiales;
    private String dificultad;
    
    public Integer getId_descripcion() {
        return id_descripcion;
    }
    public void setId_descripcion(Integer id_descripcion) {
        this.id_descripcion = id_descripcion;
    }
    public String getNombre_ejercicio() {
        return nombre_ejercicio;
    }
    public void setNombre_ejercicio(String nombre_ejercicio) {
        this.nombre_ejercicio = nombre_ejercicio;
    }
    public String getDescripcion_ejercicio() {
        return descripcion_ejercicio;
    }
    public void setDescripcion_ejercicio(String descripcion_ejercicio) {
        this.descripcion_ejercicio = descripcion_ejercicio;
    }
    public Integer getRepeticiones() {
        return repeticiones;
    }
    public void setRepeticiones(Integer repeticiones) {
        this.repeticiones = repeticiones;
    }
    public String getObjetivo() {
        return objetivo;
    }
    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }
    public String getDuracion_estimada() {
        return duracion_estimada;
    }
    public void setDuracion_estimada(String duracion_estimada) {
        this.duracion_estimada = duracion_estimada;
    }
    public String getMateriales() {
        return materiales;
    }
    public void setMateriales(String materiales) {
        this.materiales = materiales;
    }
    public String getDificultad() {
        return dificultad;
    }
    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }
}

