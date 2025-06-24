package com.mapstruct_libro_lombok.repository;

import com.mapstruct_libro_lombok.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends JpaRepository<Libro,Long> {
}
