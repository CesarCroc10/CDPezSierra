package com.example.cdpezsierra.modelos.clases;

import com.example.cdpezsierra.modelos.alumnos.InscripcionAlumno;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "InscripcionClub")
public class InscripcionClub {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_inscripcion", referencedColumnName = "id_inscripcion")
    private InscripcionAlumno inscripcionAlumno;

    @ManyToOne
    @JoinColumn(name = "id_club", referencedColumnName = "id_club")
    private Club club;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public InscripcionAlumno getInscripcionAlumno() {
        return inscripcionAlumno;
    }

    public void setInscripcionAlumno(InscripcionAlumno inscripcionAlumno) {
        this.inscripcionAlumno = inscripcionAlumno;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    
}

