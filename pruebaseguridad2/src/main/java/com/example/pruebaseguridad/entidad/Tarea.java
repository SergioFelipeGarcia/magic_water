package com.example.pruebaseguridad.entidad;



import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idtarea;

    private String titulo;
    private String descripcion;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date inicioprevisto;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date finprevisto;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date inicioreal;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date finreal;

    private String estado;


    @ManyToOne
    @JoinColumn(name = "nif") // Nombre del campo en la tabla Tarea que referencia al Usuario
    private Usuario usuario; // Relación ManyToOne con Usuario

    @ManyToOne
    @JoinColumn(name = "idproyecto") // Nombre del campo en la tabla Tarea que referencia al Proyecto
    private Proyecto proyecto; // Relación ManyToOne con Proyecto


    // Constructor, getters y setters

    public Tarea() {
        // Constructor vacío necesario para JPA
    }

    public Tarea(String titulo, String descripcion, Date inicioprevisto, Date finprevisto, String estado, Date inicioReal, Date finReal, Usuario usuario, Proyecto proyecto) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.inicioprevisto = inicioprevisto;
        this.finprevisto = finprevisto;
        this.estado = estado;
        this.inicioreal = inicioReal;
        this.finreal = finReal;
        this.usuario = usuario;
        this.proyecto = proyecto;
    }

    public Integer getIdtarea() {
        return idtarea;
    }

    public void setIdtarea(Integer idtarea) {
        this.idtarea = idtarea;
    }

    // Otros getters y setters...

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getInicioReal() {
        return inicioreal;
    }

    public void setInicioReal(Date inicioreal) {
        this.inicioreal = inicioreal;
    }

    public Date getInicioprevisto() {
        return inicioprevisto;
    }

    public void setInicioprevisto(Date inicioprevisto) {
        this.inicioprevisto = inicioprevisto;
    }

    public Date getFinprevisto() {
        return finprevisto;
    }

    public void setFinprevisto(Date finprevisto) {
        this.finprevisto = finprevisto;
    }

    public Date getInicioreal() {
        return inicioreal;
    }

    public void setInicioreal(Date inicioreal) {
        this.inicioreal = inicioreal;
    }

    public Date getFinreal() {
        return finreal;
    }

    public void setFinreal(Date finreal) {
        this.finreal = finreal;
    }
}

