package br.com.fepi.cursos.dto.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.com.fepi.cursos.dto.AulaDTO;
import br.com.fepi.cursos.dto.CursoDTO;
import br.com.fepi.cursos.model.Aula;
import br.com.fepi.cursos.model.Curso;

@Component
public class CursoMapper {
    
    public CursoDTO toDTO(Curso curso){
        if(curso == null){
            return null;
        }

        List<AulaDTO> aulas = curso.getAulas().stream()
        .map(aula -> new AulaDTO(aula.getId(),aula.getNome(),aula.getAulaURL()))
        .collect(Collectors.toList());

        return new CursoDTO(curso.getId(),curso.getNome(),curso.getCategoria(),aulas);
    }

    public Curso toEntity(CursoDTO cursoDTO){
        if (cursoDTO ==null) {
            return null;
        }

        Curso curso = new Curso();
        if (cursoDTO.id() != null){
            curso.setId(cursoDTO.id());
        }

        curso.setNome(cursoDTO.nome());
        curso.setCategoria(cursoDTO.categoria());
        curso.setStatus("Ativo");

        List<Aula> aulas = cursoDTO.aulas().stream().map(AulaDTO -> {
            var aula = new Aula();
            aula.setId(AulaDTO.id());
            aula.setNome(AulaDTO.nome());
            aula.setAulaURL(AulaDTO.aulaURL());
            aula.setCurso(curso);
            return aula;
        }).collect(Collectors.toList());
        curso.setAulas(aulas);
        return curso;
    }
}
