package com.example.cdpezsierra.modelos.clases;

import jakarta.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "Rendimiento")
public class Rendimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_rendimiento;

    private Time tiempo;
    private Double peso;
    private String comentarios_instructor;
    private String progreso;
    
    public Integer getId_rendimiento() {
        return id_rendimiento;
    }
    public void setId_rendimiento(Integer id_rendimiento) {
        this.id_rendimiento = id_rendimiento;
    }
    public Time getTiempo() {
        return tiempo;
    }
    public void setTiempo(Time tiempo) {
        this.tiempo = tiempo;
    }
    public Double getPeso() {
        return peso;
    }
    public void setPeso(Double peso) {
        this.peso = peso;
    }
    public String getComentarios_instructor() {
        return comentarios_instructor;
    }
    public void setComentarios_instructor(String comentarios_instructor) {
        this.comentarios_instructor = comentarios_instructor;
    }
    public String getProgreso() {
        return progreso;
    }
    public void setProgreso(String progreso) {
        this.progreso = progreso;
    }
}

