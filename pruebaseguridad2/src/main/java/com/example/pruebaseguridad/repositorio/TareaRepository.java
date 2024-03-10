package com.example.pruebaseguridad.repositorio;

import com.example.pruebaseguridad.entidad.Tarea;
import com.example.pruebaseguridad.entidad.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TareaRepository extends JpaRepository<Tarea, Integer> {
    @Query
    List<Tarea> findByUsuario_nif(String nif);




}

