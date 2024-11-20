package com.example.cdpezsierra.modelos.clases;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Club")
public class Club {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_club;

    private String nombre_club;

    @OneToMany(mappedBy = "club")
    private List<Instructor> instructores;

    @OneToMany(mappedBy = "club")
    private List<InscripcionClub> inscripcionesClub;

    public Integer getId_club() {
        return id_club;
    }

    public void setId_club(Integer id_club) {
        this.id_club = id_club;
    }

    public String getNombre_club() {
        return nombre_club;
    }

    public void setNombre_club(String nombre_club) {
        this.nombre_club = nombre_club;
    }

    public List<Instructor> getInstructores() {
        return instructores;
    }

    public void setInstructores(List<Instructor> instructores) {
        this.instructores = instructores;
    }

    public List<InscripcionClub> getInscripcionesClub() {
        return inscripcionesClub;
    }

    public void setInscripcionesClub(List<InscripcionClub> inscripcionesClub) {
        this.inscripcionesClub = inscripcionesClub;
    }

}

