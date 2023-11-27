package br.com.fepi.cursos.dto;

import java.util.List;

import org.hibernate.validator.constraints.Length;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CursoDTO(
        Long id, 
        @NotBlank @NotNull @Length(min = 5, max = 100) String nome,
        @NotNull @Length(max = 15) String categoria,
        List<AulaDTO> aulas) {
            
}
