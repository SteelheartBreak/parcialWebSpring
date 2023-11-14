package com.example.parcial.repositorios;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.parcial.modelo.Biblioteca;

public interface BibliotecaRepositorio extends JpaRepository<Biblioteca, Long> {


    
}
