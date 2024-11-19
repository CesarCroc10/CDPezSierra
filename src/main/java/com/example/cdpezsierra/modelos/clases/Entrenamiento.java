package com.example.cdpezsierra.modelos.clases;

import java.sql.Time;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Entrenamiento")
public class Entrenamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_entrenamiento;

    @ManyToOne
    @JoinColumn(name = "id_clase", referencedColumnName = "id_clase")
    private Clase clase;

    @ManyToOne
    @JoinColumn(name = "id_descripcion", referencedColumnName = "id_descripcion")
    private DescripcionEntrenamiento descripcionEntrenamiento;

    private Date fecha;
    private Time hora_inicio;
    private Time hora_fin;
    private String ubicacion;
    
    public Integer getId_entrenamiento() {
        return id_entrenamiento;
    }
    public void setId_entrenamiento(Integer id_entrenamiento) {
        this.id_entrenamiento = id_entrenamiento;
    }
    public Clase getClase() {
        return clase;
    }
    public void setClase(Clase clase) {
        this.clase = clase;
    }
    public DescripcionEntrenamiento getDescripcionEntrenamiento() {
        return descripcionEntrenamiento;
    }
    public void setDescripcionEntrenamiento(DescripcionEntrenamiento descripcionEntrenamiento) {
        this.descripcionEntrenamiento = descripcionEntrenamiento;
    }
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public Time getHora_inicio() {
        return hora_inicio;
    }
    public void setHora_inicio(Time hora_inicio) {
        this.hora_inicio = hora_inicio;
    }
    public Time getHora_fin() {
        return hora_fin;
    }
    public void setHora_fin(Time hora_fin) {
        this.hora_fin = hora_fin;
    }
    public String getUbicacion() {
        return ubicacion;
    }
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
}

