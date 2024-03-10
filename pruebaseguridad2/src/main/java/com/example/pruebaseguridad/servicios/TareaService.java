package com.example.pruebaseguridad.servicios;

import com.example.pruebaseguridad.entidad.Tarea;
import com.example.pruebaseguridad.repositorio.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TareaService {
    @Autowired
    private final TareaRepository tareaRepository;

    @Autowired
    public TareaService(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    public Tarea guardarTarea(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    public Optional<Tarea> buscarPorId(Integer id) {
        return tareaRepository.findById(id);
    }

    public List<Tarea> obtenerTodasTareas() {
        return tareaRepository.findAll();
    }

    public void eliminarTarea(Integer id) {
        tareaRepository.deleteById(id);
    }
}