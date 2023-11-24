package br.com.fepi.cursos.service;

import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;


import br.com.fepi.cursos.model.Curso;
import br.com.fepi.cursos.repository.CursoRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@Service
public class CursoService {
    
    private final CursoRepository repository;

    CursoService(CursoRepository repository) {
        this.repository = repository;
    }



    public List<Curso> findAll(){

        return repository.findAll();
    }



    public Optional<Curso> findById(@PathVariable @NotNull @Positive Long id){

        return repository.findById(id);
    }


    public Curso create(@Valid Curso curso){

        return repository.save(curso);
    }



    public Optional<Curso> update(@NotNull @Positive Long id, @Valid Curso curso){
        
        return repository.findById(id)
        .map(r -> {
            r.setNome(curso.getNome());
            r.setCategoria(curso.getCategoria());
            return repository.save(r);
        });
    }



    public boolean delete(@PathVariable @NotNull @Positive Long id){ 
        return repository.findById(id)
        .map(r -> {
            repository.deleteById(id);
            return true;
        }).orElse(false);
        
        
    }
}
