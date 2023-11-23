package br.com.fepi.cursos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fepi.cursos.model.Curso;

public interface CursoRepository extends JpaRepository <Curso,Long>{
    
}
