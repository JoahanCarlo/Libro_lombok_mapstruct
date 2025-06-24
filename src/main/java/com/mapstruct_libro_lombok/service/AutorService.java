package com.mapstruct_libro_lombok.service;

import com.mapstruct_libro_lombok.dto.AutorDTO;
import com.mapstruct_libro_lombok.model.Autor;
import com.mapstruct_libro_lombok.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AutorService {
    @Autowired
    private AutorRepository autorRepository;

    public AutorDTO crearAutor(AutorDTO autorDTO){
        Autor autor = mapToEntity(autorDTO);
        autor.setEstado(true);
        Autor autorGuardado = autorRepository.save(autor);
        return mapToDTO(autorGuardado);
    }

    public Autor actualizarEstado(Long id){
        Autor autor = autorRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("No se encontro al autor con ID :"+id));
        Boolean estadoActual = autor.getEstado();
        autor.setEstado(estadoActual == null ? true :! estadoActual);
        return  autorRepository.save(autor);
    }

    public List<AutorDTO> listarAutores(){
        List<Autor> autores = autorRepository.findAll();
        return autores.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public AutorDTO actualizarAutor(Long id,AutorDTO autorDTO){
        Autor autorExistente = autorRepository.findById(id)
                .orElseThrow(()->new RuntimeException("No se encontro el autor ID: "+id));
        autorExistente.setNombreAutor(autorDTO.getNombreAutor());
        autorExistente.setApellidoAutor(autorDTO.getApellidoAutor());
        autorExistente.setDireccionAutor(autorDTO.getDireccionAutor());
        autorExistente.setEmailAutor(autorDTO.getEmailAutor());
        Autor autorActualizado = autorRepository.save(autorExistente);
        return mapToDTO(autorActualizado);
    }
    //Métodos para mapear entre DTO y Entidad
    private AutorDTO mapToDTO(Autor autor){
        AutorDTO autorDTO = new AutorDTO();
        autorDTO.setId(autor.getId());
        autorDTO.setNombreAutor(autor.getNombreAutor());
        autorDTO.setApellidoAutor(autor.getApellidoAutor());
        autorDTO.setDireccionAutor(autor.getDireccionAutor());
        autorDTO.setEmailAutor(autor.getEmailAutor());
        autorDTO.setEstado(autor.getEstado());
        autorDTO.setFechaCreacion(autor.getFechaCreacion());
        return autorDTO;
    }

    private Autor mapToEntity(AutorDTO autorDTO){
        Autor autor = new Autor();
        autor.setNombreAutor(autorDTO.getNombreAutor());
        autor.setApellidoAutor(autorDTO.getApellidoAutor());
        autor.setDireccionAutor(autorDTO.getDireccionAutor());
        autor.setEmailAutor(autorDTO.getEmailAutor());
        autor.setEstado(autorDTO.getEstado());
        autor.setFechaCreacion(autorDTO.getFechaCreacion());
        return autor;
    }
}
