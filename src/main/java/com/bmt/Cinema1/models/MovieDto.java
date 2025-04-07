package com.bmt.Cinema1.models;


import jakarta.validation.constraints.*;

public class MovieDto {

    @NotEmpty(message = "El nombre es requerido")
    @Size(max = 100, message = "El nombre no puede exceder los 100 caracteres")
    private String nombre;
    
    @NotEmpty(message = "El género es requerido")
    @Size(max = 50, message = "El género no puede exceder los 50 caracteres")
    private String genero;
    
    @NotEmpty(message = "La sinopsis es requerida")
    @Size(max = 1000, message = "La sinopsis no puede exceder los 1000 caracteres")
    private String sinopsis;
    
    @NotEmpty(message = "El horario es requerido")
    @Size(max = 50, message = "El horario no puede exceder los 50 caracteres")
    @Pattern(regexp = "^([0-1]?[0-9]|2[0-3]):[0-5][0-9](,\\s*([0-1]?[0-9]|2[0-3]):[0-5][0-9])*$", 
             message = "Formato de horario inválido. Use HH:MM separados por comas")
    private String horario;
    
    @NotEmpty(message = "La sala es requerida")
    @Size(max = 10, message = "La sala no puede exceder los 10 caracteres")
    @Pattern(regexp = "^[A-Za-z0-9\\-]+$", message = "La sala solo puede contener letras, números y guiones")
    private String sala;
    
    
    @NotEmpty(message = "El Poster es requerido")
    @Size(max = 255, message = "La URL del trailer no puede exceder los 255 caracteres")
    @Pattern(regexp = "^(https?|ftp)://[^\\s/$.?#].[^\\s]*$", 
             message = "Debe ser una URL válida")
    private String imagen;
    
    @NotEmpty(message = "El trailer es requerido")
    @Size(max = 30, message = "La URL del trailer no puede exceder los 30 caracteres")
    private String video;
    
    @NotEmpty(message = "El estado es requerido")
    @Size(max = 20, message = "El estado no puede exceder los 20 caracteres")
    @Pattern(regexp = "^(Estreno|Cartelera|Fuera de cartelera|Proximamente)$", 
             message = "El estado debe ser: Estreno, Cartelera o Fuera de cartelera")
    private String estado;
    


    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}