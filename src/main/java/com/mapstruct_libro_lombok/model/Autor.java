package com.mapstruct_libro_lombok.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;
@Getter
@Setter
@Entity
@Table(name = "autor")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nombreAutor;

    @NotBlank
    private String apellidoAutor;

    @NotBlank
    private String direccionAutor;

    @NotBlank
    private String emailAutor;

    private Boolean estado = true;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime fechaCreacion;

    @OneToMany(mappedBy = "autor")
    private List<Libro> libro;
}
