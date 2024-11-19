package com.example.cdpezsierra.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.cdpezsierra.modelos.alumnos.Asistencia;

@Repository
public interface IAsistenciaRepository extends JpaRepository<Asistencia, Integer>{

}
