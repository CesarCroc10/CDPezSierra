package com.example.cdpezsierra.modelos.clases;

import jakarta.persistence.*;
import java.util.List;

import com.example.cdpezsierra.modelos.Usuario;

@Entity
@Table(name = "Instructor")
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_instructor;

    private String nombre;
    private String segundo_nombre;
    private String apellido;
    private String segundo_apellido;
    private Integer telefono;

    @ManyToOne
    @JoinColumn(name = "id_club", referencedColumnName = "id_club")
    private Club club;

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    private Usuario usuario;

    @OneToMany(mappedBy = "instructor")
    private List<InstructorEntrenamiento> instructorEntrenamientos;

    public Integer getId_instructor() {
        return id_instructor;
    }

    public void setId_instructor(Integer id_instructor) {
        this.id_instructor = id_instructor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSegundo_nombre() {
        return segundo_nombre;
    }

    public void setSegundo_nombre(String segundo_nombre) {
        this.segundo_nombre = segundo_nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getSegundo_apellido() {
        return segundo_apellido;
    }

    public void setSegundo_apellido(String segundo_apellido) {
        this.segundo_apellido = segundo_apellido;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<InstructorEntrenamiento> getInstructorEntrenamientos() {
        return instructorEntrenamientos;
    }

    public void setInstructorEntrenamientos(List<InstructorEntrenamiento> instructorEntrenamientos) {
        this.instructorEntrenamientos = instructorEntrenamientos;
    }

    
}

