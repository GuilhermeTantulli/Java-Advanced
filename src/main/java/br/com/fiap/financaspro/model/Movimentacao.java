package br.com.fiap.financaspro.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Movimentacao {
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String descricao;
    private BigDecimal valor;
    private LocalDate data;
    private String tipo; //ENTRADA ou SAIDA de valor

}
