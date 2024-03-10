package com.example.pruebaseguridad.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;

@Entity
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idproyecto;

    private String nombre;
    private String descripcion;
    private String zona;
    private Date fecha;

    // Constructor, getters y setters

    public Proyecto() {
        // Constructor vacío necesario para JPA
    }

    public Proyecto(String nombre, String descripcion, String zona, Date fecha) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.zona = zona;
        this.fecha = fecha;
    }

    // Getters y Setters

    public Long getIdproyecto() {
        return idproyecto;
    }

    public void setIdproyecto(Long idproyecto) {
        this.idproyecto = idproyecto;
    }

    // Otros getters y setters...

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}