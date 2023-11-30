package br.com.fepi.cursos.controller;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import br.com.fepi.cursos.dto.CursoDTO;
import br.com.fepi.cursos.dto.CursoPageDTO;
import br.com.fepi.cursos.service.CursoService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;

@Validated
@RestController
@RequestMapping("/cursos")
@AllArgsConstructor
public class CursoController {

    
    private final CursoService service;



    @GetMapping
    public CursoPageDTO findAll(@RequestParam(defaultValue = "0") @PositiveOrZero int page,
     @RequestParam(defaultValue = "10") @Positive @Max(100) int size){
        return service.findAll(page, size);
    }
    

    // @GetMapping
    // public List<CursoDTO> findAll(){
    //     return service.findAll();
    // }
    
    @GetMapping("{id}")
    public CursoDTO findById(@PathVariable @NotNull @Positive Long id){
        return service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CursoDTO create(@RequestBody @Valid @NotNull CursoDTO curso){
        return service.create(curso);
    }

    @PutMapping("{id}")
    public CursoDTO update(@PathVariable @NotNull @Positive Long id,
     @RequestBody @Valid @NotNull CursoDTO curso){
        return service.update(id, curso);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @NotNull @Positive Long id){ 
       service.delete(id);
    }
}
