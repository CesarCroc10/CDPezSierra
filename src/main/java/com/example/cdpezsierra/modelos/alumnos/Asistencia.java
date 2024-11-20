package com.example.cdpezsierra.modelos.alumnos;

import java.util.Date;

import com.example.cdpezsierra.modelos.clases.Clase;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Asistencia")
public class Asistencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_asistencia;

    @ManyToOne
    @JoinColumn(name = "id_alumno", referencedColumnName = "id_alumno")
    private Alumno alumno;

    @ManyToOne
    @JoinColumn(name = "id_clase", referencedColumnName = "id_clase")
    private Clase clase;

    private Date fecha;
    private Date asistio;

    public Integer getId_asistencia() {
        return id_asistencia;
    }
    public void setId_asistencia(Integer id_asistencia) {
        this.id_asistencia = id_asistencia;
    }
    public Alumno getAlumno() {
        return alumno;
    }
    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }
    public Clase getClase() {
        return clase;
    }
    public void setClase(Clase clase) {
        this.clase = clase;
    }
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public Date getAsistio() {
        return asistio;
    }
    public void setAsistio(Date asistio) {
        this.asistio = asistio;
    }
}

