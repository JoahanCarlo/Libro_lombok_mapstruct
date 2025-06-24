package com.mapstruct_libro_lombok.controller;

import com.mapstruct_libro_lombok.dto.AutorDTO;
import com.mapstruct_libro_lombok.model.Autor;
import com.mapstruct_libro_lombok.service.AutorService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/autores")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @PostMapping
    public ResponseEntity<AutorDTO>  crearAutor(@RequestBody @Valid AutorDTO autorDTO){
        AutorDTO creado = autorService.crearAutor(autorDTO);
        return new ResponseEntity<>(creado, HttpStatus.CREATED);
    }

    @PutMapping("/estado/{id}")
    public ResponseEntity<Autor> cambiarEstado(@PathVariable Long id){
        Autor estadoActualizado = autorService.actualizarEstado(id);
        return ResponseEntity.ok(estadoActualizado);
    }

    @GetMapping
    public ResponseEntity<List<AutorDTO>> listarAutores(){
        List<AutorDTO> autores = autorService.listarAutores();
        return ResponseEntity.ok(autores);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AutorDTO> actualizarAutor(@PathVariable Long id,@RequestBody AutorDTO autorDTO){
        try{
            AutorDTO autorActualizado = autorService.actualizarAutor(id,autorDTO);
            return ResponseEntity.ok(autorActualizado);
        }
        catch(EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }


}
