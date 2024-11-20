package com.example.cdpezsierra.controller;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

import com.example.cdpezsierra.modelos.alumnos.Alumno;
import com.example.cdpezsierra.modelos.alumnos.Contacto;
import com.example.cdpezsierra.services.AlumnoDetalleService;
import com.example.cdpezsierra.services.AlumnoService;




@RequestMapping(value="/Estudiantes")

@Controller
public class AlumnoController {

	@Autowired
    private AlumnoService alumnoService;

	@Autowired
	private AlumnoDetalleService alumnoDetalleService;

	@GetMapping("/listado")
	public String mostrarIndex(Model model) {

		List<Alumno> lista = alumnoService.getAllAlumnos();

		for (Alumno alumno : lista) {
			System.out.println(alumno.getInscripciones());
		}

		model.addAttribute("Alumnos", lista);
		
		return "alumnos/estudiantes";
	}

	@GetMapping("/Detalle/{id_alumno}")
	public String getMethodName(@PathVariable("id_alumno") int id_alumno, Model model) {
		// Obtener los detalles del alumno por ID
		Alumno alumno = alumnoDetalleService.obtenerAlumnoConRelaciones(id_alumno);
    
		if (alumno == null) {
			// Redirigir o mostrar un mensaje de error si el alumno no se encuentra
			return "redirect:/estudiantes";
		}
	
		// Calcular la edad del alumno
		int edad = alumnoDetalleService.calcularEdad(alumno.getFecha_nacimiento());
	
		// Agregar datos al modelo
		model.addAttribute("alumno", alumno);
		model.addAttribute("edad", edad);
	
		return "alumnos/detalleEst";
	}

	@PostMapping("/update")
	public ResponseEntity<?> updateAlumno(@RequestBody Map<String, String> payload) {
		System.out.println("Payload recibido: " + payload);

		String telefono = payload.get("telefono");
		String infoMedica = payload.get("infoMedica");
		String idAlumno = payload.get("idAlumno");

		try {
			int telefonoInt = Integer.parseInt(telefono);
			int idAlumnoInt = Integer.parseInt(idAlumno);

			System.out.println("Obteniendo alumno con ID: " + idAlumnoInt);
			Alumno alumno = alumnoService.getAlumno(idAlumnoInt);
			if (alumno == null) {
				System.out.println("Alumno no encontrado");
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.singletonMap("error", "Alumno no encontrado"));
			}

			alumno.setTelefono(telefonoInt);
			alumno.setInfo_medica(infoMedica);

			System.out.println("Guardando cambios...");
			alumnoService.guardar(alumno);

			return ResponseEntity.ok(Collections.singletonMap("message", "Datos actualizados correctamente."));
		} catch (NumberFormatException e) {
			System.out.println("Error en la conversión de datos numéricos: " + e.getMessage());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.singletonMap("error", "Datos numéricos inválidos."));
		} catch (Exception e) {
			System.out.println("Error interno del servidor: " + e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.singletonMap("error", "Error interno del servidor."));
		}
	}

	@PostMapping("/updateContacto")
	public ResponseEntity<?> actualizarContactos(@RequestBody Map<String, Object> payload) {
		try {
			// Extraer y convertir datos del payload
			List<Map<String, String>> contactos = (List<Map<String, String>>) payload.get("contactos");
			Integer idAlumno = null;
			
			if (payload.get("idAlumno") instanceof Integer) {
				idAlumno = (Integer) payload.get("idAlumno");
			} else if (payload.get("idAlumno") instanceof String) {
				idAlumno = Integer.parseInt((String) payload.get("idAlumno"));
			}

			if (idAlumno == null) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.singletonMap("error", "ID de alumno inválido."));
			}

			// Depuración
			System.out.println("ID de Alumno: " + idAlumno);
			System.out.println("Contactos recibidos: " + contactos);

			// Procesar contactos
			List<Contacto> updatedContactos = new ArrayList<>();
			for (Map<String, String> contactoMap : contactos) {
				Contacto contacto = new Contacto();
				contacto.setNombre(contactoMap.get("nombre"));
				contacto.setApellido(contactoMap.get("apellido")); // Manejar el apellido
				contacto.setParentesco(contactoMap.get("relacion"));
				contacto.setTelefono(Integer.parseInt(contactoMap.get("telefono")));

				updatedContactos.add(contacto);
			}

			// Actualizar contactos en el servicio
			alumnoService.updateContactos(idAlumno, updatedContactos);
			return ResponseEntity.ok(Collections.singletonMap("message", "Contactos actualizados correctamente."));
		} catch (ClassCastException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.singletonMap("error", "Tipo de dato incorrecto en el payload."));
		} catch (NumberFormatException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.singletonMap("error", "Formato de número inválido en el payload."));
		} catch (Exception e) {
			e.printStackTrace(); // Añadir traza de la excepción para depuración
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.singletonMap("error", "Error al actualizar los contactos."));
		}
	}

	@PostMapping("/updateInscripcion")
	public ResponseEntity<?> actualizarInscripciones(@RequestBody Map<String, Object> payload) {
		try {
			// Extraer y convertir datos del payload
			List<Map<String, Object>> inscripciones = (List<Map<String, Object>>) payload.get("inscripciones");
			Integer idAlumno = null;

			if (payload.get("id_alumno") instanceof Integer) {
				idAlumno = (Integer) payload.get("id_alumno");
			} else if (payload.get("id_alumno") instanceof String) {
				idAlumno = Integer.parseInt((String) payload.get("id_alumno"));
			}

			// Llamar al servicio para actualizar las inscripciones
			alumnoService.updateInscripciones(idAlumno, inscripciones);

			return ResponseEntity.ok(Collections.singletonMap("message", "Inscripciones actualizadas correctamente."));
		} catch (ClassCastException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.singletonMap("error", "Tipo de dato incorrecto en el payload."));
		} catch (NumberFormatException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Collections.singletonMap("error", "Formato de número inválido en el payload."));
		} catch (Exception e) {
			e.printStackTrace(); // Añadir traza de la excepción para depuración
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.singletonMap("error", "Error al actualizar las inscripciones."));
		}
	}
	
}
