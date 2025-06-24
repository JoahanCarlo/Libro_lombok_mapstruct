package com.mapstruct_libro_lombok.service;

import com.mapstruct_libro_lombok.dto.LibroDTO;
import com.mapstruct_libro_lombok.model.Autor;
import com.mapstruct_libro_lombok.model.Editorial;
import com.mapstruct_libro_lombok.model.Libro;
import com.mapstruct_libro_lombok.repository.AutorRepository;
import com.mapstruct_libro_lombok.repository.EditorialRepository;
import com.mapstruct_libro_lombok.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {
    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private EditorialRepository editorialRepository;

    public List<Libro> listaLibros(){
        return libroRepository.findAll();
    }

    public LibroDTO crearLibros(LibroDTO libroDTO){
        Libro libro = dtoToEntity(libroDTO);
        libro = libroRepository.save(libro);
        return entityToDto(libro);
    }

    private LibroDTO entityToDto(Libro libro){
        if(libro == null ) return null;
        LibroDTO libroDTO = new LibroDTO();
        libroDTO.setId(libro.getId());
        libroDTO.setNombreLibro(libro.getNombreLibro());
        libroDTO.setIsbnLibro(libro.getIsbnLibro());
        libroDTO.setYearLibro(libro.getYearLibro());
        libroDTO.setEdicionLibro(libro.getEdicionLibro());
        if (libro.getAutor() != null){
            libroDTO.setAutorId(libro.getAutor().getId());
        }
        if (libro.getEditorial() != null) {
            libroDTO.setEditorialId(libro.getEditorial().getId());
        }
        return libroDTO;
    }

    private Libro dtoToEntity(LibroDTO libroDTO){
        if(libroDTO == null ) return null;
        Libro libro = new Libro();
        libro.setId(libroDTO.getId());
        libro.setNombreLibro(libroDTO.getNombreLibro());
        libro.setIsbnLibro(libroDTO.getIsbnLibro());
        libro.setYearLibro(libroDTO.getYearLibro());
        libro.setEdicionLibro(libroDTO.getEdicionLibro());
        libro.setEstado(true);
        Autor autor = autorRepository.findById(libroDTO.getAutorId())
                .orElseThrow(()-> new RuntimeException("Autor con ID : "+libroDTO.getAutorId()+"no encontrado"));
        libro.setAutor(autor);
        Editorial editorial = editorialRepository.findById(libroDTO.getEditorialId())
                .orElseThrow(()-> new RuntimeException("Editorial con ID : "+libroDTO.getEditorialId()+"no encontrado"));
        libro.setEditorial(editorial);
        return libro;
    }
}
