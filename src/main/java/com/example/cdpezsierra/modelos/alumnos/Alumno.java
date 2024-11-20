package com.example.cdpezsierra.modelos.alumnos;

import java.util.Date;
import java.util.List;

import com.example.cdpezsierra.modelos.Usuario;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "alumnos")
public class Alumno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_alumno;

    private String nombre;
    private String segundo_nombre;
    private String apellido;
    private String segundo_apellido;
    private Integer telefono;
    private Date fecha_nacimiento;
    private String info_medica;

    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    private Usuario usuario;

    @OneToMany(mappedBy = "alumno")
    private List<InscripcionAlumno> inscripciones;

    @OneToMany(mappedBy = "alumno")
    private List<Pago> pagos;

    @OneToMany(mappedBy = "alumno")
    private List<Asistencia> asistencias;

    @OneToMany(mappedBy = "alumno")
    private List<AlumnoEntrenamiento> entrenamientos;

    @ManyToMany
    @JoinTable(
        name = "AlumnoContacto",
        joinColumns = @JoinColumn(name = "id_alumno"),
        inverseJoinColumns = @JoinColumn(name = "id_contacto")
    )
    private List<Contacto> contactos;

    public Integer getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(Integer id_alumno) {
        this.id_alumno = id_alumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSegundo_nombre() {
        return segundo_nombre;
    }

    public void setSegundo_nombre(String segundo_nombre) {
        this.segundo_nombre = segundo_nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getSegundo_apellido() {
        return segundo_apellido;
    }

    public void setSegundo_apellido(String segundo_apellido) {
        this.segundo_apellido = segundo_apellido;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getInfo_medica() {
        return info_medica;
    }

    public void setInfo_medica(String info_medica) {
        this.info_medica = info_medica;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<InscripcionAlumno> getInscripciones() {
        return inscripciones;
    }

    public void setInscripciones(List<InscripcionAlumno> inscripciones) {
        this.inscripciones = inscripciones;
    }

    public List<Pago> getPagos() {
        return pagos;
    }

    public void setPagos(List<Pago> pagos) {
        this.pagos = pagos;
    }

    public List<Asistencia> getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(List<Asistencia> asistencias) {
        this.asistencias = asistencias;
    }

    public List<AlumnoEntrenamiento> getEntrenamientos() {
        return entrenamientos;
    }

    public void setEntrenamientos(List<AlumnoEntrenamiento> entrenamientos) {
        this.entrenamientos = entrenamientos;
    }

    public List<Contacto> getContactos() {
        return contactos;
    }

    public void setContactos(List<Contacto> contactos) {
        this.contactos = contactos;
    }

}
