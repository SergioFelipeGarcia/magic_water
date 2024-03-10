package com.example.pruebaseguridad.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Usuario {

    @Id
    private String nif;
    private String password;
    private boolean activo;
    private String permiso;
    private String categoria;
    private String nombre;
    private String apellidos;
    private String email;
    private String tlf;

    // Constructor vacío necesario para JPA
    public Usuario() {
    }

    // Constructor con todos los campos
    public Usuario(String nif, String password, boolean activo, String permiso, String categoria, String nombre, String apellidos, String email, String tlf) {
        this.nif = nif;
        this.password = password;
        this.activo = activo;
        this.permiso = permiso;
        this.categoria = categoria;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.tlf = tlf;
    }
    @OneToMany(mappedBy = "usuario") // Nombre del atributo en la clase Tarea que representa la relación con Usuario
    private List<Tarea> tareas;

    // Getters y setters
    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getPermiso() {
        return permiso;
    }

    public void setPermiso(String permiso) {
        this.permiso = permiso;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTlf() {
        return tlf;
    }

    public void setTlf(String tlf) {
        this.tlf = tlf;
    }
}
