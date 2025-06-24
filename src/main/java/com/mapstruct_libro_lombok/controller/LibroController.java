package com.mapstruct_libro_lombok.controller;

import com.mapstruct_libro_lombok.dto.LibroDTO;
import com.mapstruct_libro_lombok.model.Libro;
import com.mapstruct_libro_lombok.service.LibroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/api/libros")
public class LibroController {
    @Autowired
    private LibroService libroService;

    @PostMapping
    public ResponseEntity<LibroDTO> crearLibro(@RequestBody @Valid LibroDTO libroDTO){
        LibroDTO libroRegistrado = libroService.crearLibros(libroDTO);
        return new ResponseEntity<>(libroRegistrado, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<LibroDTO>> listarLibros(){
        List<Libro> libros = libroService.listaLibros();
        List<LibroDTO> libroDTOS = libros.stream()
                .map(libro -> {
                    return new LibroDTO(
                            libro.getId(),
                            libro.getNombreLibro(),
                            libro.getIsbnLibro(),
                            libro.getYearLibro(),
                            libro.getEdicionLibro(),
                            libro.getAutor() != null ? libro.getAutor().getId() : null,
                            libro.getEditorial() != null ? libro.getEditorial().getId() : null);
                }).collect(Collectors.toList());
        return new ResponseEntity<>(libroDTOS,HttpStatus.OK);
    }
}
