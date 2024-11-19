package com.example.cdpezsierra.modelos.alumnos;

import com.example.cdpezsierra.modelos.clases.Entrenamiento;
import com.example.cdpezsierra.modelos.clases.Rendimiento;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ALumnoEntrenamiento")
public class AlumnoEntrenamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_alumno", referencedColumnName = "id_alumno")
    private Alumno alumno;

    @ManyToOne
    @JoinColumn(name = "id_entrenamiento", referencedColumnName = "id_entrenamiento")
    private Entrenamiento entrenamiento;

    @ManyToOne
    @JoinColumn(name = "id_rendimiento", referencedColumnName = "id_rendimiento")
    private Rendimiento rendimiento;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Entrenamiento getEntrenamiento() {
        return entrenamiento;
    }

    public void setEntrenamiento(Entrenamiento entrenamiento) {
        this.entrenamiento = entrenamiento;
    }

    public Rendimiento getRendimiento() {
        return rendimiento;
    }

    public void setRendimiento(Rendimiento rendimiento) {
        this.rendimiento = rendimiento;
    }
}

