package com.example.parcial.DTO;

import java.util.Set;

public class BibliotecaDTO {

    private Long id;
    private String nombre;
    private String direccion;
    private String ciudad;
    private Set<LibroDTO> libros;

    // Constructores, getters y setters
    public BibliotecaDTO() {
    }

    public BibliotecaDTO(Long id, String nombre, String direccion, String ciudad, Set<LibroDTO> libros) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.libros = libros;
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Set<LibroDTO> getLibros() {
        return libros;
    }

    public void setLibros(Set<LibroDTO> libros) {
        this.libros = libros;
    }
}
