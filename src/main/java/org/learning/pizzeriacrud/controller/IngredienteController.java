package org.learning.pizzeriacrud.controller;

import org.learning.pizzeriacrud.repository.IngredienteRepository;
import org.learning.pizzeriacrud.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ingredienti")
public class IngredienteController {
    @Autowired
    private IngredienteRepository ingredienteRepository;

    @Autowired
    private PizzaRepository pizzaRepository;

    @GetMapping("/show")
    public String show(Model model) {
        model.addAttribute("ingredienti", ingredienteRepository.findAll());
        return "/pizze/ingredienti/show";
    }

    @GetMapping("/create")
    public String create() {

        return "/pizze/ingredienti/form";
    }

}
