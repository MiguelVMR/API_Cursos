package br.com.fepi.cursos.dto.mapper;

import org.springframework.stereotype.Component;

import br.com.fepi.cursos.dto.CursoDTO;
import br.com.fepi.cursos.model.Curso;

@Component
public class CursoMapper {
    
    public CursoDTO toDTO(Curso curso){
        if(curso == null){
            return null;
        }
        return new CursoDTO(curso.getId(), curso.getNome(), 
        curso.getCategoria(), curso.getAulas());
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
        
        return curso;
    }
}
