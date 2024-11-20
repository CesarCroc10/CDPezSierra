package com.example.cdpezsierra.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.cdpezsierra.modelos.Usuario;
import com.example.cdpezsierra.modelos.alumnos.Alumno;
import com.example.cdpezsierra.modelos.alumnos.Contacto;
import com.example.cdpezsierra.modelos.alumnos.InscripcionAlumno;
import com.example.cdpezsierra.modelos.alumnos.Pago;
import com.example.cdpezsierra.modelos.clases.Club;
import com.example.cdpezsierra.modelos.clases.InscripcionClub;
import com.example.cdpezsierra.repositorios.IAlumnoContactoRepository;
import com.example.cdpezsierra.repositorios.IAlumnoRepository;
import com.example.cdpezsierra.repositorios.IClubRepository;
import com.example.cdpezsierra.repositorios.IContactoRepository;
import com.example.cdpezsierra.repositorios.IInscripcionAlumnoRepository;
import com.example.cdpezsierra.repositorios.IInscripcionClubRepository;
import com.example.cdpezsierra.repositorios.IPagoRepository;
import com.example.cdpezsierra.repositorios.IUsuarioRepository;

import jakarta.transaction.Transactional;

@Service
public class AlumnoService {
    
    List<Alumno> lista=null;

    @Autowired
    private IAlumnoRepository alumnoRepository;

    @Autowired
    private IContactoRepository contactoRepository;

    @Autowired
    private IInscripcionAlumnoRepository inscripcionAlumnoRepository;

    @Autowired
    private IPagoRepository pagoRepository;

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Autowired
    private IAlumnoContactoRepository alumnoContactoRepository; 

    @Autowired
    private IClubRepository clubRepository;

    @Autowired
    private IInscripcionClubRepository inscripcionClubRepository;

    @Transactional
    public void crearAlumnoConDatosRelacionados() {

        Usuario usuario = new Usuario();
        usuario.setId(1);
        usuario.setCorreo("ejemplo@correo.com");
        usuario.setContrasena("contraseña123");
        usuarioRepository.save(usuario);

        Alumno alumno = new Alumno();
        alumno.setId_alumno(1);
        alumno.setNombre("Juan");
        alumno.setSegundo_nombre("Carlos");
        alumno.setApellido("Pérez");
        alumno.setSegundo_apellido("López");
        alumno.setTelefono(123456789);
        alumno.setFecha_nacimiento(new Date(2000, 1, 15)); 
        alumno.setInfo_medica("Sin alergias conocidas");
        alumno.setUsuario(usuario); 
        alumnoRepository.save(alumno);

        Contacto contacto = new Contacto();
        contacto.setId_contacto(1);
        contacto.setNombre("María");
        contacto.setApellido("Pérez");
        contacto.setTelefono(987654321);
        contacto.setParentesco("Madre");
        contactoRepository.save(contacto);

        alumnoContactoRepository.insertAlumnoContacto(alumno.getId_alumno(), contacto.getId_contacto());


        InscripcionAlumno inscripcionAlumno = new InscripcionAlumno();
        inscripcionAlumno.setId_inscripcion(1);
        inscripcionAlumno.setAlumno(alumno);
        inscripcionAlumno.setFecha_inscripcion(new Date(2000, 1, 15)); // Usa la fecha deseada
        inscripcionAlumno.setEstado("Activo");
        inscripcionAlumno.setFecha_actualizacion(new Date(2000, 1, 20));
        inscripcionAlumnoRepository.save(inscripcionAlumno);

        Club club = new Club();
        club.setId_club(1);
        club.setNombre_club("Fútbol");
        clubRepository.save(club);

        InscripcionClub inscripcionClub = new InscripcionClub();
        inscripcionClub.setId(1);
        inscripcionClub.setInscripcionAlumno(inscripcionAlumno);
        inscripcionClub.setClub(club);
        inscripcionClubRepository.save(inscripcionClub);

        // Crear un pago para el alumno
        Pago pago = new Pago();
        pago.setId_pago(1);
        pago.setAlumno(alumno);
        pago.setMonto(100.00); // Monto de pago ejemplo
        pago.setEstado("Pendiente");
        pago.setFecha_pago("2024-11-15"); // Fecha de pago en formato de texto
        pago.setFecha_vencimiento(new Date(2024, 11, 25)); // Usa la fecha deseada
        pagoRepository.save(pago);

        System.out.println("Alumno y datos relacionados guardados exitosamente.");
    }

    public void crearAlumnoConDatosRelacionados2() {

        Usuario usuario = new Usuario();
        usuario.setId(2);
        usuario.setCorreo("ejemplo2@correo.com");
        usuario.setContrasena("contraseña123");
        usuarioRepository.save(usuario);

        Alumno alumno = new Alumno();
        alumno.setId_alumno(2);
        alumno.setNombre("Maria");
        alumno.setSegundo_nombre("Luisa");
        alumno.setApellido("Gómez");
        alumno.setSegundo_apellido("Martinez");
        alumno.setTelefono(987654321);
        alumno.setFecha_nacimiento(new Date(1999, 3, 22)); 
        alumno.setInfo_medica("Alergia al agua");
        alumno.setUsuario(usuario); 
        alumnoRepository.save(alumno);

        Contacto contacto = new Contacto();
        contacto.setId_contacto(2);
        contacto.setNombre("Pablo");
        contacto.setApellido("Gómez");
        contacto.setTelefono(987754321);
        contacto.setParentesco("Padre");
        contactoRepository.save(contacto);

        alumnoContactoRepository.insertAlumnoContacto(alumno.getId_alumno(), contacto.getId_contacto());

        InscripcionAlumno inscripcionAlumno = new InscripcionAlumno();
        inscripcionAlumno.setId_inscripcion(2);
        inscripcionAlumno.setAlumno(alumno);
        inscripcionAlumno.setFecha_inscripcion(new Date(2000, 1, 15)); 
        inscripcionAlumno.setEstado("Activo");
        inscripcionAlumno.setFecha_actualizacion(new Date(2000, 1, 20));
        inscripcionAlumnoRepository.save(inscripcionAlumno);

        Club club = new Club();
        club.setId_club(2);
        club.setNombre_club("Natación");
        clubRepository.save(club);

        InscripcionClub inscripcionClub = new InscripcionClub();
        inscripcionClub.setId(2);
        inscripcionClub.setInscripcionAlumno(inscripcionAlumno);
        inscripcionClub.setClub(club);
        inscripcionClubRepository.save(inscripcionClub);

        Pago pago = new Pago();
        pago.setId_pago(2);
        pago.setAlumno(alumno);
        pago.setMonto(100.00); // Monto de pago ejemplo
        pago.setEstado("Pendiente");
        pago.setFecha_pago("2024-11-15"); // Fecha de pago en formato de texto
        pago.setFecha_vencimiento(new Date(2024, 11, 25)); // Usa la fecha deseada
        pagoRepository.save(pago);

        System.out.println("Alumno y datos relacionados guardados exitosamente.");
    }

    public List<Alumno> getAllAlumnos(){

        lista=alumnoRepository.findAll();

        return lista;
    }

    public Alumno getAlumno(int id_alumno){
        Optional<Alumno> all= alumnoRepository.findById(id_alumno);
        if(all != null){
            return all.get();
        }else{
            return null;
        }
    }

    public void guardar(Alumno alumno){
        alumnoRepository.save(alumno);
    }

    public void updateContactos(int idAlumno, List<Contacto> updatedContactos) {
        Alumno alumno = getAlumno(idAlumno);
        if (alumno == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Alumno no encontrado");
        }
    
        // Guardar contactos actualizados (o nuevos) para asegurar que tienen IDs válidos
        List<Contacto> savedContactos = new ArrayList<>();
        for (Contacto contacto : updatedContactos) {
            Contacto savedContacto = contactoRepository.save(contacto);
            savedContactos.add(savedContacto);
        }
    
        // Actualizar la relación ManyToMany
        alumno.setContactos(savedContactos);
        alumnoContactoRepository.deleteAllByAlumnoId(idAlumno);  // Eliminar relaciones existentes
        for (Contacto contacto : savedContactos) {
            alumnoContactoRepository.insertAlumnoContacto(idAlumno, contacto.getId_contacto());
        }
    
        // Guardar cambios en el alumno
        guardar(alumno);
    }

    public void updateInscripciones(Integer idAlumno, List<Map<String, Object>> inscripciones) {
        List<InscripcionAlumno> updatedInscripciones = new ArrayList<>();
        for (Map<String, Object> inscripcionMap : inscripciones) {
            Integer inscripcionId = null;
    
            if (inscripcionMap.get("id") instanceof Integer) {
                inscripcionId = (Integer) inscripcionMap.get("id");
            } else if (inscripcionMap.get("id") instanceof String) {
                inscripcionId = Integer.parseInt((String) inscripcionMap.get("id"));
            }
    
            if (inscripcionId == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ID de inscripción inválido");
            }
    
            String estado = (String) inscripcionMap.get("estado");
    
            InscripcionAlumno inscripcion = inscripcionAlumnoRepository.findById(inscripcionId)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Inscripción no encontrada"));
    
            inscripcion.setEstado(estado);
            updatedInscripciones.add(inscripcion);
        }
    
        inscripcionAlumnoRepository.saveAll(updatedInscripciones);
    }       
    
}
