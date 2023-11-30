package br.com.fepi.cursos.dto;

import java.util.List;

public record CursoPageDTO(List<CursoDTO> cursos, long totalElements, int totalPages) {
    
}
