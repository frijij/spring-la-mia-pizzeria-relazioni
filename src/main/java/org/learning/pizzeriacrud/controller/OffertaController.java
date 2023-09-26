package org.learning.pizzeriacrud.controller;

import org.learning.pizzeriacrud.model.Offerta;
import org.learning.pizzeriacrud.model.Pizza;
import org.learning.pizzeriacrud.repository.OffertaRepository;
import org.learning.pizzeriacrud.repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.Optional;

@Controller
@RequestMapping("/offerte")
public class OffertaController {
    @Autowired
    OffertaRepository offertaRepository;

    @Autowired
    PizzaRepository pizzaRepository;

    @GetMapping("/create")
    public String create(@RequestParam("pizzaId") Integer pizzaId, Model model) {
        Optional<Pizza> pizzaResult = pizzaRepository.findById(pizzaId);
        if (pizzaResult.isPresent()) {
            Pizza pizza = pizzaResult.get();
            Offerta offerta = new Offerta();
            offerta.setPizza(pizza);
            offerta.setDataInizio(LocalDate.now());
            offerta.setDataFine(LocalDate.now());
            model.addAttribute("offerta", offerta);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pizza con id " + pizzaId + " non trovata.");
        }
        return "/pizze/offerte/form";
    }

    @PostMapping("/create")
    public String doCreate(@ModelAttribute("offerta") Offerta offertaForm) {
        offertaRepository.save(offertaForm);
        return "redirect:/pizze/show/" + offertaForm.getPizza().getId();
    }


}
