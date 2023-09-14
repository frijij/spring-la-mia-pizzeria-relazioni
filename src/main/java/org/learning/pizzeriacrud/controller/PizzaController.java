package org.learning.pizzeriacrud.controller;

import org.learning.pizzeriacrud.model.Pizza;
import org.learning.pizzeriacrud.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
@RequestMapping("/")
public class PizzaController {

    @Autowired
    private PizzaRepository repository;

    @GetMapping
    public String index(Model model) {
        List<Pizza> listaPizze = repository.findAll();
        if (listaPizze.size() == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Non ci sono pizze disponibili al momento");
        }
        model.addAttribute("pizze", listaPizze);
        return "index";
    }
}
