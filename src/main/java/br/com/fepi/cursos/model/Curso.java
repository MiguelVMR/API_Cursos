package br.com.fepi.cursos.model;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    @Column(length = 100, nullable = false)
    private String nome;
    
    
    @NotNull
    @Column(length = 30, nullable = false)
    private String categoria;

    @NotNull
    @Column(length = 15, nullable = false)
    private String status = "Ativo";


}
