package com.bmt.Cinema1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bmt.Cinema1.models.Movies;
import com.bmt.Cinema1.repositories.MoviesRepository;

@Controller
@RequestMapping("/cartelera")
public class CarteleraController {
    
    @Autowired
    private MoviesRepository moviesRepository;
    
    @GetMapping("")
    public String mostrarCartelera(Model model) {
        model.addAttribute("movies", moviesRepository.findAll());
        return "cartelera";
    }
    
    @GetMapping("/{id}")
    public String mostrarDetallePelicula(@PathVariable int id, Model model) {
        Movies movie = moviesRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Película no encontrada"));
        model.addAttribute("movie", movie);
        return "detalle-pelicula";
    }
    
}