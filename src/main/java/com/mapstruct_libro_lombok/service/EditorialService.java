package com.mapstruct_libro_lombok.service;

import com.mapstruct_libro_lombok.dto.EditorialDTO;
import com.mapstruct_libro_lombok.model.Editorial;
import com.mapstruct_libro_lombok.repository.EditorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EditorialService {
    @Autowired
    private EditorialRepository editorialRepository;


    public Editorial actualizarEstadoEditorial(Long id){
        Editorial editorial = editorialRepository.findById(id)
                .orElseThrow(()->new RuntimeException("No se encontro al editor ID :"+id));
        Boolean estadoActual = editorial.getEstado();
        editorial.setEstado(estadoActual == null ? true :! estadoActual);
        return editorialRepository.save(editorial);
    }

    public List<EditorialDTO> listaEditoriales(){
        List<Editorial> editoriales = editorialRepository.findAll();
        return  editoriales.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public EditorialDTO crearEditorial(EditorialDTO editorialDTO){
        Editorial editorial = mapToEntity(editorialDTO);
        editorial.setEstado(true);
        Editorial editorialGuardado = editorialRepository.save(editorial);
        return mapToDTO(editorialGuardado);
    }

    public EditorialDTO actualizarEditorial(Long id,EditorialDTO editorialDTO){
        Editorial editorialExistente = editorialRepository.findById(id)
                .orElseThrow(()->new RuntimeException("No se encontro la editorial con ID :"+id));
        editorialExistente.setNombreEditorial(editorialDTO.getNombreEditorial());
        editorialExistente.setDireccionEditorial(editorialDTO.getDireccionEditorial());
        editorialExistente.setEmailEditorial(editorialDTO.getEmailEditorial());
        Editorial editorialActualizado = editorialRepository.save(editorialExistente);
        return mapToDTO(editorialActualizado);
    }

    //Métodos para mapear entre DTO y Entidad
    private EditorialDTO mapToDTO(Editorial editorial){
        EditorialDTO editorialDTO = new EditorialDTO();
        editorialDTO.setId(editorial.getId());
        editorialDTO.setNombreEditorial(editorial.getNombreEditorial());
        editorialDTO.setDireccionEditorial(editorial.getDireccionEditorial());
        editorialDTO.setEmailEditorial(editorial.getEmailEditorial());
        editorialDTO.setFechaCreacion(editorial.getFechaCreacion());
        editorialDTO.setEstado(editorial.getEstado());
        return editorialDTO;
    }

    private Editorial mapToEntity(EditorialDTO editorialDTO){
        Editorial editorial = new Editorial();
        editorial.setId(editorialDTO.getId());
        editorial.setNombreEditorial(editorialDTO.getNombreEditorial());
        editorial.setDireccionEditorial(editorialDTO.getDireccionEditorial());
        editorial.setEmailEditorial(editorialDTO.getEmailEditorial());
        editorial.setFechaCreacion(editorialDTO.getFechaCreacion());
        editorial.setEstado(editorialDTO.getEstado());
        return editorial;
    }
}
