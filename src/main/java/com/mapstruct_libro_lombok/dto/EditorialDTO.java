package com.mapstruct_libro_lombok.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
public class EditorialDTO {
    private Long id;

    @NotBlank(message = "El nombre del editorial es obligatorio")
    private String nombreEditorial;

    @NotBlank(message = "La dirección de la editorial es obligatorio")
    private String direccionEditorial;

    @NotBlank(message = "Su email de la editorial es obligatorio")
    private String emailEditorial;

    private Boolean estado;

    private LocalDateTime fechaCreacion;
}
