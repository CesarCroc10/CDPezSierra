package com.example.cdpezsierra.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.cdpezsierra.modelos.alumnos.Alumno;

@Repository
public interface IAlumnoRepository  extends JpaRepository<Alumno, Integer>{

    @EntityGraph(attributePaths = {"inscripciones", "contactos", "pagos", "asistencias"})
    Optional<Alumno> findById(int id_alumno);
    
}
