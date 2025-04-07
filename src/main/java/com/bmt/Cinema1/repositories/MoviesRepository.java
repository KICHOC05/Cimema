package com.bmt.Cinema1.repositories;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.bmt.Cinema1.models.Movies;

public interface MoviesRepository extends JpaRepository<Movies, Integer>{

	
    // Método para filtrar por estado con ordenamiento
    List<Movies> findByEstadoPelicula(String estadoPelicula, Sort sort);
    
    List<Movies> findByGeneroAndIdNot(String genero, int id, Sort sort);
}