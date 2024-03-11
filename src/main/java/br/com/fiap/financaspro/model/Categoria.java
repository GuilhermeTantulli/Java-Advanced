package br.com.fiap.financaspro.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Categoria {

    @Id
    private Long id;
    private String nome;
    private String icone;

}