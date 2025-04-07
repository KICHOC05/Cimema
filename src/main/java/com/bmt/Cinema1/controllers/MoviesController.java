package com.bmt.Cinema1.controllers;

import java.net.URL;
import java.net.MalformedURLException;
import java.util.regex.Pattern;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import com.bmt.Cinema1.models.MovieDto;
import com.bmt.Cinema1.models.Movies;
import com.bmt.Cinema1.repositories.MoviesRepository;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/admin")
public class MoviesController {
    
    @Autowired
    private MoviesRepository repo;
    
    @GetMapping("/movies")
    public String showMoviesList(Model model) {
        List<Movies> movies = repo.findAll(Sort.by(Sort.Direction.DESC, "id"));
        model.addAttribute("movies", movies);
        return "admin/movies";
    }
    
    @GetMapping("/create")
    public String showCreatePage(Model model) {
        MovieDto movieDto = new MovieDto();
        model.addAttribute("movieDto", movieDto);
        return "admin/CreateMovie";       
    }
    
    @PostMapping("/create")
    public String createProduct(
            @Valid @ModelAttribute MovieDto movieDto,
            BindingResult result
           ) {
        if (result.hasErrors()) {
            return "admin/CreateMovie";
        }
        
        // Validar la URL de la imagen
        if (movieDto.getImagen() != null && !movieDto.getImagen().isEmpty()) {
            if (!isValidImageUrl(movieDto.getImagen())) {
                result.addError(new FieldError("movieDto", "imagen", 
                        "La URL de imagen no es válida. Debe comenzar con http:// o https://"));
                return "admin/CreateMovie";
            }
        }
        
        Movies movie = new Movies();
        movie.setNombre(movieDto.getNombre());
        movie.setGenero(movieDto.getGenero());
        movie.setSinopsis(movieDto.getSinopsis());
        movie.setHorario(movieDto.getHorario());
        movie.setSala(movieDto.getSala());
        movie.setVideo(movieDto.getVideo());
        movie.setEstadoPelicula(movieDto.getEstado());
        movie.setImagen(movieDto.getImagen()); // Usamos directamente la URL
        
        repo.save(movie);
        return "redirect:/admin/movies";  
    }
    
    @GetMapping("/edit")
    public String showEditPage(
            Model model, 
            @RequestParam int id
            ) {
        try {
            Movies movie = repo.findById(id).get();
            model.addAttribute("movie", movie);
            
            MovieDto movieDto = new MovieDto();
            movieDto.setNombre(movie.getNombre());
            movieDto.setGenero(movie.getGenero());
            movieDto.setSinopsis(movie.getSinopsis());
            movieDto.setHorario(movie.getHorario());
            movieDto.setSala(movie.getSala());
            movieDto.setVideo(movie.getVideo());
            movieDto.setEstado(movie.getEstadoPelicula());
            movieDto.setImagen(movie.getImagen()); // Cargamos la URL actual
            
            model.addAttribute("movieDto", movieDto);
        }
        catch(Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
            return "redirect:/admin";
        }
        return "admin/EditMovie";
    }
    
    @PostMapping("/edit")
    public String updateMovie(
            Model model,
            @RequestParam int id,
            @Valid @ModelAttribute MovieDto movieDto,
            BindingResult result
            ) {
        try {
            Movies movie = repo.findById(id).get();
            model.addAttribute("movie", movie);
            
            if (result.hasErrors()) {
                return "admin/EditMovie";
            }
            
            // Validar la URL si se proporcionó una nueva
            if (movieDto.getImagen() != null && !movieDto.getImagen().isEmpty()) {
                if (!isValidImageUrl(movieDto.getImagen())) {
                    result.addError(new FieldError("movieDto", "imagen", 
                            "La URL de imagen no es válida"));
                    return "admin/EditMovie";
                }
                movie.setImagen(movieDto.getImagen());
            }
            
            movie.setNombre(movieDto.getNombre());
            movie.setGenero(movieDto.getGenero());
            movie.setSinopsis(movieDto.getSinopsis());
            movie.setHorario(movieDto.getHorario());
            movie.setSala(movieDto.getSala());
            movie.setVideo(movieDto.getVideo());
            movie.setEstadoPelicula(movieDto.getEstado());
            
            repo.save(movie);
        }
        catch(Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
        return "redirect:/admin/movies";
    }
    
    @GetMapping("/delete")
    public String deleteMovie(@RequestParam int id) {
        try {
            repo.deleteById(id);
        }
        catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        }  
        return "redirect:/admin/movies";
    }
    
    // Método de validación de URL
    private boolean isValidImageUrl(String url) {
        if (url == null || url.trim().isEmpty()) {
            return false;
        }

        try {
            new URL(url);
            // Verificar protocolo (solo http/https)
            return url.startsWith("http://") || url.startsWith("https://");
        } catch (MalformedURLException e) {
            return false;
        }
    }
}