package com.example.pruebaseguridad.servicios;

import com.example.pruebaseguridad.entidad.Proyecto;
import com.example.pruebaseguridad.repositorio.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProyectoService {

    private final ProyectoRepository proyectoRepository;

    @Autowired
    public ProyectoService(ProyectoRepository proyectoRepository) {
        this.proyectoRepository = proyectoRepository;
    }

    public Proyecto guardarProyecto(Proyecto proyecto) {
        return proyectoRepository.save(proyecto);
    }

    public Optional<Proyecto> buscarPorId(Long id) {
        return proyectoRepository.findById(id);
    }

    public List<Proyecto> obtenerTodosProyectos() {
        return proyectoRepository.findAll();
    }

    public void eliminarProyecto(Long id) {
        proyectoRepository.deleteById(id);
    }
}