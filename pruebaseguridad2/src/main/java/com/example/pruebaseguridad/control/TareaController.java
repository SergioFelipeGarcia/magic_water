package com.example.pruebaseguridad.control;
import com.example.pruebaseguridad.repositorio.ProyectoRepository;
import org.springframework.format.annotation.DateTimeFormat;
import com.example.pruebaseguridad.entidad.Tarea;
import com.example.pruebaseguridad.entidad.Usuario;
import com.example.pruebaseguridad.repositorio.TareaRepository;
import com.example.pruebaseguridad.repositorio.UsuarioRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/tareas")
public class TareaController {

    @Autowired
    private TareaRepository tareaRepository;

    @Autowired
    private ProyectoRepository proyectoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping()
    public String mostrarTareas(Model model, Authentication authentication) {
        String nif = authentication.getName(); // Obtener el nombre de usuario
        Usuario usuario = usuarioRepository.findByNif(nif); // Suponiendo que tienes un método para buscar un usuario por su nombre de usuario
        List<Tarea> tareas = null;

        if (usuario.getPermiso().equals("supervisor")) {
            tareas = tareaRepository.findAll(); // Obtener todas las tareas para un supervisor
        } else {
            tareas = tareaRepository.findByUsuario_nif(nif); // Obtener las tareas asignadas al usuario
        }
        model.addAttribute("tareas", tareas);
        return "tareas"; // Vista para mostrar la lista de tareas
    }

    @RequestMapping("/editar")
    public ModelAndView peticionEditar(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        String idTarea = request.getParameter("id");
        int id = Integer.parseInt(idTarea);
        Optional<Tarea> optTarea = tareaRepository.findById(id);
        System.out.println("Id tarea buscada: " + id);
        System.out.println(optTarea.get());
        if (optTarea.isPresent()) {
            Tarea tarea = optTarea.get();
            System.out.println(tarea);
            mv.addObject("tarea", tarea);
            mv.setViewName("editartarea");
        } else {
            // Manejar el caso en que no se encuentra la tarea
            mv.setViewName("error");
            mv.addObject("mensaje", "La tarea con el ID " + id + " no se encontró.");
        }
        return mv;
    }
    @RequestMapping("/guardar")
    public String peticionGuardar( @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") Tarea t) {
        // Los atributos no incluidos en el formulario vienen vacíos
        Optional<Tarea> optTarea = tareaRepository.findById(t.getIdtarea());
        if (optTarea.isPresent()) {
            Tarea editado = optTarea.get();
            editado.setIdtarea(t.getIdtarea());
            editado.setTitulo(t.getTitulo());
            editado.setDescripcion(t.getDescripcion());
            editado.setEstado(t.getEstado());
            editado.setInicioprevisto(t.getInicioprevisto());
            editado.setFinprevisto(t.getFinprevisto());
            editado.setInicioreal(t.getInicioreal());
            editado.setFinreal(t.getFinreal());
            tareaRepository.save(editado);
        }

        return "redirect:/tareas";
    }


    @GetMapping("/nueva")
    public String mostrarFormularioNuevaTarea(Model model) {
        // Crear una nueva tarea
        Tarea nuevaTarea = new Tarea();

        // Formatear las fechas en el formato requerido
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");


        if (nuevaTarea.getInicioprevisto() != null && nuevaTarea.getFinprevisto() != null) {
            String formattedInicioPrevisto = formatter.format(nuevaTarea.getInicioprevisto());
            String formattedFinPrevisto = formatter.format(nuevaTarea.getFinprevisto());
            // Agregar las tareas formateadas al modelo
            model.addAttribute("formattedInicioPrevisto", formattedInicioPrevisto);
            model.addAttribute("formattedFinPrevisto", formattedFinPrevisto);
        }

        // Agregar la tarea al modelo
        model.addAttribute("tarea", new Tarea());

        return "nueva_tarea";
    }
    @PostMapping("/guardarTarea")
    public String guardarTarea(@ModelAttribute("tarea") Tarea tarea) {
        // Guardar la tarea en la base de datos
        tareaRepository.save(tarea);

        // Redirigir a una página de confirmación o a donde desees
        return "redirect:/tareas";
    }


    @RequestMapping("/eliminar")
    public String peticionEliminar(HttpServletRequest request) {
        ModelAndView mv = new ModelAndView();
        String idTarea = request.getParameter("id");
        int id = Integer.parseInt(idTarea);
        try {
            tareaRepository.deleteById(id); // Llamada al método deleteById en una instancia válida de TareaRepository
        } catch (Exception e) {
            e.printStackTrace();
            return "error";
        }
        return "redirect:/";
    }



}