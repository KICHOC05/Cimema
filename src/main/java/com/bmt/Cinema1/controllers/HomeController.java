// Paquete donde se encuentra la clase
package com.bmt.Cinema1.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
// Importa anotaciones de Spring
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.bmt.Cinema1.models.Movies;
import com.bmt.Cinema1.repositories.MoviesRepository;

// Marca esta clase como un controlador de Spring MVC
@Controller
public class HomeController {

    @Autowired
    private MoviesRepository moviesRepository;
    
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("movies", moviesRepository.findAll());
        return "index";
    }
    // Mapea la ruta "/contact" al método contact()
    @GetMapping({"/contact"})
    public String contact() {
        // Devuelve la vista "contact" (contact.html)
        return "contact";
    }
}
    
    
    
    