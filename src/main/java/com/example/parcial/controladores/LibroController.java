package com.example.parcial.controladores;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.parcial.modelo.Libro;
import com.example.parcial.repositorios.LibroRepositorio;

@RestController
@RequestMapping("/libro")
@CrossOrigin(origins = "http://localhost:4200")
public class LibroController {
    @Autowired
    private LibroRepositorio libroRepositorio;

    @GetMapping("/all")
    public ResponseEntity<List<Libro>> getAll(){
        List<Libro> libros = libroRepositorio.findAll();
        return new ResponseEntity<>(libros, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> borrar(@PathVariable Long id) {
        if (id != null) {
            Optional<Libro> libroEncontrado = libroRepositorio.findById(id);
            if (libroEncontrado.isPresent()) {
                libroRepositorio.delete(libroEncontrado.get());
                return new ResponseEntity<>("Libro eliminado", HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>("Libro no encontrado", HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>("ID de libro nulo", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> actualizar(@PathVariable Long id, @RequestBody Libro libroUp) {
        Optional<Libro> libroEncontrado = libroRepositorio.findById(id);
        if (libroEncontrado.isPresent()) {
            Libro libro = libroEncontrado.get();
            libro.setNombre(libroUp.getNombre());
            libroRepositorio.save(libro);
            return new ResponseEntity<>("Libro actualizado correctamente", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Libro no encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Libro> add(@RequestBody Libro libro) {
        if (libro != null) {
            libroRepositorio.save(libro);
            return new ResponseEntity<>(libro, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(libro, HttpStatus.BAD_REQUEST);
        }
    }


}
