package org.learning.pizzeriacrud.controller;

import org.learning.pizzeriacrud.model.Pizza;
import org.learning.pizzeriacrud.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/pizze")
public class PizzaController {

    @Autowired
    private PizzaRepository repository;

    @GetMapping
    public String index(Model model) {
        List<Pizza> listaPizze = repository.findAll();
        model.addAttribute("pizze", listaPizze);
        return "index";
    }

    @GetMapping("/show/{pizzaId}")
    public String show(@PathVariable("pizzaId") Integer id, Model model) {
        Optional<Pizza> pizzaOptional = repository.findById(id);
        if (pizzaOptional.isPresent()) {
            model.addAttribute("pizza", pizzaOptional.get());
            return "/pizze/show";
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}
