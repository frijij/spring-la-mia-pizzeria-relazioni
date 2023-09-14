package org.learning.pizzeriacrud.controller;

import org.learning.pizzeriacrud.model.Pizza;
import org.learning.pizzeriacrud.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class PizzaController {

    @Autowired
    private PizzaRepository repository;

    @GetMapping
    public String index(Model model) {
        List<Pizza> listaPizze = repository.findAll();
        model.addAttribute("pizze", listaPizze);
        return "index";
    }
}
