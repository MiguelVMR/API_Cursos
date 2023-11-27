package br.com.fepi.cursos.service;


import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import br.com.fepi.cursos.dto.CursoDTO;
import br.com.fepi.cursos.dto.mapper.CursoMapper;
import br.com.fepi.cursos.exception.RecordNotFoundException;
import br.com.fepi.cursos.model.Curso;
import br.com.fepi.cursos.repository.CursoRepository;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Validated
@Service
public class CursoService {
    
    private final CursoRepository repository;
    private final CursoMapper cursoMapper;

    CursoService(CursoRepository repository,CursoMapper cursoMapper) {
        this.repository = repository;
        this.cursoMapper = cursoMapper;
    }



    public List<CursoDTO> findAll(){
        return repository.findAll()
        .stream()
        .map(cursoMapper::toDTO)
        .collect(Collectors.toList());
    }

    public CursoDTO findById(@NotNull @Positive Long id){
        return repository.findById(id).map(cursoMapper::toDTO)
        .orElseThrow(() -> new RecordNotFoundException(id));
    }


    public CursoDTO create(@Valid @NotNull CursoDTO curso){
        return cursoMapper.toDTO(repository.save(cursoMapper.toEntity(curso)));
    }



    public CursoDTO update(@NotNull @Positive Long id, @Valid @NotNull CursoDTO cursoDTO){
        
        return repository.findById(id)
        .map(record -> {
            Curso curso = cursoMapper.toEntity(cursoDTO);
            record.setNome(cursoDTO.nome());
            record.setCategoria(cursoDTO.categoria());
            record.getAulas().clear();
            curso.getAulas().forEach(aula -> record.getAulas().add(aula));
            repository.save(record);
            return cursoMapper.toDTO(curso);
        }).orElseThrow(() -> new RecordNotFoundException(id));
    }



    public void delete(@NotNull @Positive Long id){ 
        repository.delete(repository.findById(id)
            .orElseThrow(() -> new RecordNotFoundException(id)));
        
    }
}
