package com.example.parcial.DTO;

public class LibroDTO {

    private Long id;
    private String nombre;
    private String autor;
    // Omitimos la referencia a la biblioteca para evitar referencias circulares

    // Constructores, getters y setters
    public LibroDTO() {
    }

    public LibroDTO(Long id, String nombre, String autor) {
        this.id = id;
        this.nombre = nombre;
        this.autor = autor;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
