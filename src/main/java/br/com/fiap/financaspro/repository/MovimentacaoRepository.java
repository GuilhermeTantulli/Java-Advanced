package br.com.fiap.financaspro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.financaspro.model.Movimentacao;

public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Long> {
    
    

}
