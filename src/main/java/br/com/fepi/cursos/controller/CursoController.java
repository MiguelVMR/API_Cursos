package br.com.fepi.cursos.controller;


import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
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
import br.com.fepi.cursos.service.CursoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;

@Validated
@RestController
@RequestMapping("/cursos")
@AllArgsConstructor
public class CursoController {

    
    private final CursoService service;



    @GetMapping
    public List<Curso> findAll(){

        return service.findAll();
    }
    
    @GetMapping("{id}")
    public Curso findById(@PathVariable @NotNull @Positive Long id){
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Curso create(@RequestBody @Valid Curso curso){

        return service.create(curso);
    }

    @PutMapping("{id}")
    public Curso update(@PathVariable @NotNull @Positive Long id, @RequestBody @Valid Curso curso){
        return service.update(id, curso);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @NotNull @Positive Long id){ 
       service.delete(id);
    }
}
