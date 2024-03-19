package br.com.fiap.financaspro.controller;

import static org.springframework.http.HttpStatus.CREATED;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.financaspro.model.Movimentacao;
import br.com.fiap.financaspro.repository.MovimentacaoRepository;


@RestController
@RequestMapping("movimentacao")
public class MovimentacaoController {

    @Autowired
    MovimentacaoRepository repository;

    @GetMapping
    public List<Movimentacao> index() {
        return repository.findAll();
    }
    
    @PostMapping
    @ResponseStatus(CREATED)
    public Movimentacao create(@RequestBody Movimentacao movimentacao) {
        return repository.save(movimentacao);
    }
    
}
