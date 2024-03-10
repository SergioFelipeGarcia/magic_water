package com.example.pruebaseguridad.control;


import com.example.pruebaseguridad.entidad.Proyecto;
import com.example.pruebaseguridad.entidad.Usuario;
import com.example.pruebaseguridad.repositorio.ProyectoRepository;
import com.example.pruebaseguridad.repositorio.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/proyecto")
public class ProyectoController {

    @Autowired
    private ProyectoRepository proyectoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping()
    public String mostrarProyectos(Model model, Authentication authentication) {
        String nif = authentication.getName(); // Obtener el nombre de usuario
        Usuario usuario = usuarioRepository.findByNif(nif); // Suponiendo que tienes un método para buscar un usuario por su nombre de usuario
        List<Proyecto> proyectos = null;

        if (usuario.getPermiso().equals("supervisor")) {
            proyectos = proyectoRepository.findAll(); // Obtener todos los proyectos para un supervisor
        } else {
            // Aquí puedes personalizar la búsqueda de proyectos asignados al usuario no supervisor según tu lógica de negocio
            // proyectos = proyectoRepository.findBy...;
        }
        model.addAttribute("proyectos", proyectos);
        return "proyecto"; // Vista para mostrar la lista de proyectos
    }
}