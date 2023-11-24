package br.com.fepi.cursos.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.hibernate.validator.constraints.Length;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@SQLDelete(sql = "UPDATE curso SET status = 'Inativo' WHERE id = ?")
@Where(clause = "status = 'Ativo'")
public class Curso {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank
    @NotNull
    @Length(min = 5, max = 100)
    @Column(length = 100, nullable = false)
    private String nome;
    
    
    @NotNull
    @Length(max = 15)
    @Column(length = 15, nullable = false)
    private String categoria;

    @NotNull
    @Length(max = 15)
    @Column(length = 15, nullable = false)
    private String status = "Ativo";

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "curso")
    //@JoinColumn(name = "curso_Id")
    private List<Aula> aulas = new ArrayList<>();


}
