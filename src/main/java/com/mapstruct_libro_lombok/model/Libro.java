package com.mapstruct_libro_lombok.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "libro")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nombreLibro;

    @NotBlank
    private String isbnLibro;

    @NotNull
    private Integer yearLibro;

    @NotNull
    private String edicionLibro;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime fechaCreacion;

    private Boolean estado = true;

    @ManyToOne
    @JoinColumn(name = "autorId")
    private Autor autor;

    @ManyToOne
    @JoinColumn(name = "editorialId")
    private Editorial editorial;
}
