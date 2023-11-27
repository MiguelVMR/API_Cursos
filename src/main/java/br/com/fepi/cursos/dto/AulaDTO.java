package br.com.fepi.cursos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AulaDTO(
    Long id,
    @NotNull @NotBlank String nome,
    @NotNull @NotBlank String aulaURL
    ) {

    }
