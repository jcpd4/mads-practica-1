package demoapp.controller;

import demoapp.service.PalindromoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class PalindromoController {

    @Autowired
    private PalindromoService palindromoService;

    @GetMapping("/palindromo")
    public String formPalindromo(PalindromoData palindromoData) {
        return "formPalindromo";
    }

    @PostMapping("/palindromo")
    public String checkPalindromo(@ModelAttribute @Valid PalindromoData palindromoData,
            BindingResult bindingResult,
            Model model) {
        if (bindingResult.hasErrors()) {
            return "formPalindromo";
        }

        boolean esPal = palindromoService.esPalindromo(palindromoData.getTexto());
        String mensaje = "El texto '" + palindromoData.getTexto() + "' "
                + (esPal ? "SÍ es palíndromo" : "NO es palíndromo");

        model.addAttribute("resultado", mensaje);
        return "resultadoPalindromo";
    }
}
