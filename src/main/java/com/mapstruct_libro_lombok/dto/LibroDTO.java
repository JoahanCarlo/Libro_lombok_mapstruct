package com.mapstruct_libro_lombok.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LibroDTO {
    private Long id;

    @NotBlank(message = "El nombre del libro es obligatorio")
    private String nombreLibro;

    @NotBlank(message = "El codigo ISBN del libro es obligatorio")
    private String isbnLibro;

    @NotNull(message = "El año de publicación es obligatorio")
    private Integer yearLibro;

    @NotBlank(message = "La edición del libro es obligatorio")
    private String edicionLibro;

    @NotNull(message = "El autor es obligatorio")
    private Long autorId;

    @NotNull(message = "El autor es obligatorio")
    private Long editorialId;
}
