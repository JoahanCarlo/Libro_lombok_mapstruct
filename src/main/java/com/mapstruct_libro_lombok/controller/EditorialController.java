package com.mapstruct_libro_lombok.controller;
import com.mapstruct_libro_lombok.dto.AutorDTO;
import com.mapstruct_libro_lombok.dto.EditorialDTO;
import com.mapstruct_libro_lombok.model.Editorial;
import com.mapstruct_libro_lombok.service.EditorialService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/editoriales")
public class EditorialController {
    @Autowired
    private EditorialService editorialService;

    @PutMapping("/estado/{id}")
    public ResponseEntity<Editorial> cambiarEstado(@PathVariable Long id){
        Editorial estadoActualizado = editorialService.actualizarEstadoEditorial(id);
        return ResponseEntity.ok(estadoActualizado);
    }

    @GetMapping
    public ResponseEntity<List<EditorialDTO>> listarEditoriales(){
        List<EditorialDTO> editoriales = editorialService.listaEditoriales();
        return  ResponseEntity.ok(editoriales);
    }

    @PostMapping
    public ResponseEntity<EditorialDTO> crearEditorial(@RequestBody @Valid EditorialDTO editorialDTO){
        EditorialDTO creada = editorialService.crearEditorial(editorialDTO);
        return new ResponseEntity<>(creada, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EditorialDTO> actualizarEditorial(@PathVariable Long id, @RequestBody EditorialDTO editorialDTO){
        try{
            EditorialDTO editorialActualizado = editorialService.actualizarEditorial(id,editorialDTO);
            return ResponseEntity.ok(editorialActualizado);
        }
        catch (EntityNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
