package com.example.cdpezsierra.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.cdpezsierra.modelos.alumnos.InscripcionAlumno;

@Repository
public interface IInscripcionAlumnoRepository extends JpaRepository<InscripcionAlumno, Integer>{

}
