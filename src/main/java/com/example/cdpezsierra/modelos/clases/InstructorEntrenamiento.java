package com.example.cdpezsierra.modelos.clases;

import jakarta.persistence.*;

@Entity
@Table(name = "InstructorEntrenamiento")
public class InstructorEntrenamiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_instructor", referencedColumnName = "id_instructor")
    private Instructor instructor;

    @ManyToOne
    @JoinColumn(name = "id_entrenamiento", referencedColumnName = "id_entrenamiento")
    private Entrenamiento entrenamiento;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Entrenamiento getEntrenamiento() {
        return entrenamiento;
    }

    public void setEntrenamiento(Entrenamiento entrenamiento) {
        this.entrenamiento = entrenamiento;
    }

   
}

