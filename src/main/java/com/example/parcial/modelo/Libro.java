package com.example.parcial.modelo;

/*import javax.persistence.*;*/
import jakarta.persistence.*;
@Entity
@Table(name = "libros_moises")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String nombre;
    private String autor;
    
    @ManyToOne
    private Biblioteca biblioteca;

    
    public Libro() {
    }

    public Libro(String nombre, String autor, Biblioteca biblioteca) {
        this.nombre = nombre;
        this.autor = autor;
        this.biblioteca = biblioteca;
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
    
        public Biblioteca getBiblioteca() {
            return biblioteca;
        }
    
        public void setBiblioteca(Biblioteca biblioteca) {
            this.biblioteca = biblioteca;
        }
    
}