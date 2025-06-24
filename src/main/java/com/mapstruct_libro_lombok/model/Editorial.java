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
@Table(name = "editorial")
public class Editorial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nombreEditorial;

    @NotBlank
    private String direccionEditorial;

    private String emailEditorial;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime fechaCreacion;

    private Boolean estado = true;

    @OneToMany(mappedBy = "editorial")
    private List<Libro> libro;
}
