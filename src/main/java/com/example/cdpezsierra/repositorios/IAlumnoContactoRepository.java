package com.example.cdpezsierra.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.cdpezsierra.modelos.alumnos.Alumno;
import jakarta.transaction.Transactional;

@Repository
public interface IAlumnoContactoRepository extends JpaRepository<Alumno, Integer> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO AlumnoContacto (id_alumno, id_contacto) VALUES (?1, ?2)", nativeQuery = true)
    void insertAlumnoContacto(Integer idAlumno, Integer idContacto);

    @Modifying 
    @Transactional 
    @Query(value = "DELETE FROM AlumnoContacto WHERE id_alumno = ?1", nativeQuery = true) 
    void deleteAllByAlumnoId(Integer idAlumno);
}
