package com.example.pruebaseguridad.repositorio;

import com.example.pruebaseguridad.entidad.Proyecto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProyectoRepository extends JpaRepository<Proyecto, Long> {
    // Puedes agregar consultas personalizadas si es necesario
}