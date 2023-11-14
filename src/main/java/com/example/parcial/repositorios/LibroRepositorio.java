package com.example.parcial.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.parcial.modelo.Libro;

public interface LibroRepositorio  extends JpaRepository<Libro, Long> {
    
}
