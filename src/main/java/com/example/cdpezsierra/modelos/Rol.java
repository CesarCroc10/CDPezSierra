package com.example.cdpezsierra.modelos;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Roles")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_rol;

    private String nombre_rol;

    @OneToMany(mappedBy = "rol")
    private List<RolesUsuario> rolesUsuarios;

    public Integer getId_rol() {
        return id_rol;
    }

    public void setId_rol(Integer id_rol) {
        this.id_rol = id_rol;
    }

    public String getNombre_rol() {
        return nombre_rol;
    }

    public void setNombre_rol(String nombre_rol) {
        this.nombre_rol = nombre_rol;
    }

    public List<RolesUsuario> getRolesUsuarios() {
        return rolesUsuarios;
    }

    public void setRolesUsuarios(List<RolesUsuario> rolesUsuarios) {
        this.rolesUsuarios = rolesUsuarios;
    }

    
}

