package com.example.cdpezsierra.modelos;

import jakarta.persistence.*;
import java.util.List;

import com.example.cdpezsierra.modelos.alumnos.Alumno;
import com.example.cdpezsierra.modelos.clases.Instructor;

@Entity
@Table(name = "Usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String correo;
    private String contrasena;

    @OneToMany(mappedBy = "usuario")
    private List<Alumno> alumnos;

    @OneToMany(mappedBy = "usuario")
    private List<Instructor> instructores;

    @OneToMany(mappedBy = "usuario")
    private List<RolesUsuario> roles;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public List<Instructor> getInstructores() {
        return instructores;
    }

    public void setInstructores(List<Instructor> instructores) {
        this.instructores = instructores;
    }

    public List<RolesUsuario> getRoles() {
        return roles;
    }

    public void setRoles(List<RolesUsuario> roles) {
        this.roles = roles;
    }

   
}
