package com.example.parcial.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.parcial.modelo.Biblioteca;

import com.example.parcial.repositorios.BibliotecaRepositorio;

@RestController
@RequestMapping("/biblioteca")
@CrossOrigin(origins = "http://localhost:4200")
public class BibliotecaController {

    @Autowired
    private BibliotecaRepositorio bibliotecaRepositorio;

    
    @GetMapping("/all")
    public ResponseEntity<List<Biblioteca>> getAll(){
        List<Biblioteca> bibliotecas = bibliotecaRepositorio.findAll();
        return new ResponseEntity<>(bibliotecas, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> borrar(@PathVariable Long id) {
        if (id != null) {
            Optional<Biblioteca> bibliotecaEncontrada = bibliotecaRepositorio.findById(id);
            if (bibliotecaEncontrada.isPresent()) {
                bibliotecaRepositorio.delete(bibliotecaEncontrada.get());
                return new ResponseEntity<>("Biblioteca eliminada", HttpStatus.NO_CONTENT);
            } else {
                return new ResponseEntity<>("Biblioteca no encontrada", HttpStatus.NOT_FOUND);
            }
        } else {
            return new ResponseEntity<>("ID de biblioteca nulo", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> actualizar(@PathVariable Long id, @RequestBody Biblioteca biblioUp) {
        Optional<Biblioteca> bibliotecaEncontrada = bibliotecaRepositorio.findById(id);
        if (bibliotecaEncontrada.isPresent()) {
            Biblioteca biblioteca = bibliotecaEncontrada.get();
            biblioteca.setNombre(biblioUp.getNombre());
            bibliotecaRepositorio.save(biblioteca);
            return new ResponseEntity<>("Biblioteca actualizada correctamente", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Biblioteca no encontrada", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<Biblioteca> add(@RequestBody Biblioteca biblioteca) {
        if (biblioteca != null) {
            bibliotecaRepositorio.save(biblioteca);
            return new ResponseEntity<>(biblioteca, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(biblioteca, HttpStatus.BAD_REQUEST);
        }
    }


    
}
