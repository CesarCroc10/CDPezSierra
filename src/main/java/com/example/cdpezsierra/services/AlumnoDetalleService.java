package com.example.cdpezsierra.services;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cdpezsierra.modelos.alumnos.Alumno;
import com.example.cdpezsierra.repositorios.IAlumnoRepository;

@Service
public class AlumnoDetalleService {

    @Autowired
    private IAlumnoRepository alumnoRepository;

    public Alumno obtenerAlumnoConRelaciones(int id_alumno) {
        return alumnoRepository.findById(id_alumno)
                .orElse(null);
    }

    // Método para calcular la edad basado en la fecha de nacimiento
    public int calcularEdad(Date fechaNacimiento) {
        if (fechaNacimiento == null) {
            return 0;
        }
        LocalDate birthDate = fechaNacimiento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        return Period.between(birthDate, LocalDate.now()).getYears();
    }
}

