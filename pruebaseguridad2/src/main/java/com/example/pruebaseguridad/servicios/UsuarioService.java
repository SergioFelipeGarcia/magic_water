package com.example.pruebaseguridad.servicios;

import com.example.pruebaseguridad.entidad.Usuario;
import com.example.pruebaseguridad.repositorio.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public Optional<Usuario> buscarPorNif(String nif) {
        return usuarioRepository.findById(nif);
    }

    public List<Usuario> obtenerTodosUsuarios() {
        return usuarioRepository.findAll();
    }

    public void eliminarUsuario(String nif) {
        usuarioRepository.deleteById(nif);
    }
}