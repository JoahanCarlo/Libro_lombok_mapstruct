package com.mapstruct_libro_lombok.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AutorDTO {
    private Long id;

    @NotBlank(message = "El nombre del autor es obligatorio")
    private String nombreAutor;

    @NotBlank(message = "El apellido del autor es obligatorio")
    private String apellidoAutor;

    @NotBlank(message = "La dirección del autor es obligatorio")
    private String direccionAutor;

    @NotBlank(message = "La dirección del correo es obligatorio")
    private  String emailAutor;

    private LocalDateTime fechaCreacion;

    private Boolean estado;
}
