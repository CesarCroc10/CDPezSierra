package com.example.cdpezsierra.modelos.alumnos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.List;

import com.example.cdpezsierra.modelos.clases.InscripcionClub;

@Entity
@Table(name = "InscripcionAlumno")
public class InscripcionAlumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_inscripcion;

    @ManyToOne
    @JoinColumn(name = "id_alumno", referencedColumnName = "id_alumno")
    private Alumno alumno;

    private Date fecha_inscripcion;
    private String estado;
    private Date fecha_actualizacion;

    @OneToMany(mappedBy = "inscripcionAlumno")
    private List<InscripcionClub> inscripcionesClub;

    public Integer getId_inscripcion() {
        return id_inscripcion;
    }

    public void setId_inscripcion(Integer id_inscripcion) {
        this.id_inscripcion = id_inscripcion;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Date getFecha_inscripcion() {
        return fecha_inscripcion;
    }

    public void setFecha_inscripcion(Date fecha_inscripcion) {
        this.fecha_inscripcion = fecha_inscripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFecha_actualizacion() {
        return fecha_actualizacion;
    }

    public void setFecha_actualizacion(Date fecha_actualizacion) {
        this.fecha_actualizacion = fecha_actualizacion;
    }

    public List<InscripcionClub> getInscripcionesClub() {
        return inscripcionesClub;
    }

    public void setInscripcionesClub(List<InscripcionClub> inscripcionesClub) {
        this.inscripcionesClub = inscripcionesClub;
    }
}

