package com.example.pruebaseguridad.control;

import org.springframework.security.core.Authentication;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Controlador {

    @RequestMapping({"/","index"})
    public ModelAndView peticion1(Authentication aut) {
        ModelAndView mv = new ModelAndView();
        if(aut==null)
            mv.addObject("user", "No se ha iniciado sesión");
        else
            mv.addObject("user", aut.getName());
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping("/login")
    public ModelAndView peticionSesion() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("login");
        return mv;
    }

    @RequestMapping("/tareas")
    public ModelAndView peticionTareas() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("tareas");
        return mv;
    }

    @RequestMapping("/proyecto")
    public ModelAndView peticionProyecto() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("proyecto");
        return mv;
    }

    @RequestMapping("/denegado")
    public ModelAndView peticionDenegado() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("denegado");
        return mv;
    }

    @RequestMapping("/editar")
    public ModelAndView peticionEditar() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("editartarea");
        return mv;
    }
    @RequestMapping("/nueva_tarea")
    public ModelAndView peticionNueva() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("nueva_tarea");
        return mv;
    }

}
