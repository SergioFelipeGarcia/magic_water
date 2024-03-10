package com.example.pruebaseguridad.repositorio;

import com.example.pruebaseguridad.entidad.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    @Query
    Usuario findByNif(String nif);
}