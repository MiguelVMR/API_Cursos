package br.com.fepi.cursos.controller;



import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fepi.cursos.model.Curso;
import br.com.fepi.cursos.repository.CursoRepository;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/cursos")
@AllArgsConstructor
public class CursoController {

   
    private final CursoRepository repository;


    @GetMapping
    public List<Curso> findAll(){

        return repository.findAll();
    }
    
    @GetMapping("{id}")
    public ResponseEntity<Curso> findById(@PathVariable Long id){

        return repository.findById(id)
        .map(r -> ResponseEntity.ok().body(r))
        .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Curso create(@RequestBody Curso curso){

        return repository.save(curso);
    }

    @PutMapping("{id}")
    public ResponseEntity<Curso> update(@PathVariable Long id, @RequestBody Curso curso){
        
        return repository.findById(id)
        .map(r -> {
            r.setNome(curso.getNome());
            r.setCategoria(curso.getCategoria());
            Curso update = repository.save(r);
            return ResponseEntity.ok().body(r);
        })
        .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?>  delete(@PathVariable Long id){ 
        return repository.findById(id)
        .map(r -> {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        })
        .orElse(ResponseEntity.notFound().build());
        
    }
}
