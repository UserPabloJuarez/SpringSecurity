package edu.cibertec.cursoseguro.controller;

import edu.cibertec.cursoseguro.dao.entity.CursoEntity;
import edu.cibertec.cursoseguro.service.CursoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CursoController {

    Logger logger = LoggerFactory.getLogger(CursoController.class);
    @Autowired
    private CursoService cursoService;

    @RequestMapping("cursoListar")
    public ModelAndView cursoMostrar() {
        logger.debug("Listando los cursos");
        return new ModelAndView("curso", "lista", cursoService.listarTodos());
    }

    @RequestMapping("cursoGrabar")
    public ModelAndView cursoGrabar(CursoEntity ce) {
        logger.info("Antes de insertar un curso");
        cursoService.insertar(ce);
        logger.warn("Después de insertar un curso");
        return new ModelAndView("redirect:cursoListar");
    }

    @RequestMapping("cursoEliminar")
    public ModelAndView cursoEliminar(@RequestParam("codigo") int codigo) {
        logger.info("Antes de eliminar un curso");
        cursoService.eliminar(codigo);
        logger.warn("Después de eliminar un curso");
        return new ModelAndView("redirect:cursoListar");
    }
}
