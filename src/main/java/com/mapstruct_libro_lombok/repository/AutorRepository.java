package com.mapstruct_libro_lombok.repository;

import com.mapstruct_libro_lombok.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor,Long> {
}
