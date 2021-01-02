package edu.cibertec.cursoseguro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @RequestMapping("/")
    public ModelAndView loginMostrar() {
        return new ModelAndView("login");
    }

    @RequestMapping("/login")
    public ModelAndView loginConErrorMostrar(@RequestParam(value = "error", required = false) boolean error) {
        return new ModelAndView("login", "error", error);
    }
}
