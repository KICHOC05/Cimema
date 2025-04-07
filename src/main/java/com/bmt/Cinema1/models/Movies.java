package com.bmt.Cinema1.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Peliculas")
public class Movies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 100, message = "El nombre no puede exceder los 100 caracteres")
    private String Nombre;
    
    @NotBlank(message = "El género es obligatorio")
    @Size(max = 50, message = "El género no puede exceder los 50 caracteres")
    private String Genero;
    
    @NotBlank(message = "La sinopsis es obligatoria")
    @Size(max = 500, message = "La sinopsis no puede exceder los 500 caracteres")
    private String Sinopsis;
    
    @NotBlank(message = "El horario es obligatorio")
    @Size(max = 50, message = "El horario no puede exceder los 50 caracteres")
    private String Horario;
    
    @NotBlank(message = "La sala es obligatoria")
    @Size(max = 10, message = "La sala no puede exceder los 10 caracteres")
    private String Sala;
    
    @NotBlank(message = "La imagen es obligatoria")
    @Size(max = 255, message = "La URL de la imagen no puede exceder los 255 caracteres")
    private String Imagen;
    
    @NotBlank(message = "El video es obligatorio")
    @Size(max = 255, message = "La URL del video no puede exceder los 255 caracteres")
    private String video;
    
    @NotBlank(message = "El estado de la película es obligatorio")
    @Size(max = 20, message = "El estado no puede exceder los 20 caracteres")
    private String EstadoPelicula;

    // Getters y Setters (manteniendo los existentes)
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    public String getGenero() {
        return Genero;
    }
    public void setGenero(String genero) {
        Genero = genero;
    }
    public String getSinopsis() {
        return Sinopsis;
    }
    public void setSinopsis(String sinopsis) {
        Sinopsis = sinopsis;
    }
    public String getHorario() {
        return Horario;
    }
    public void setHorario(String horario) {
        Horario = horario;
    }
    public String getSala() {
        return Sala;
    }
    public void setSala(String sala) {
        Sala = sala;
    }
    public String getImagen() {
        return Imagen;
    }
    public void setImagen(String imagen) {
        Imagen = imagen;
    }
    public String getVideo() {
        return video;
    }
    public void setVideo(String video) {
        this.video = video;
    }
    public String getEstadoPelicula() {
        return EstadoPelicula;
    }
    public void setEstadoPelicula(String estadoPelicula) {
        EstadoPelicula = estadoPelicula;
    }
}
