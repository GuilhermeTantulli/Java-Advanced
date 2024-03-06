package br.com.fiap.financaspro.model;

import java.util.Random;

public record Categoria (Long id, String nome, String icone) {

    public Categoria(Long id, String nome, String icone) {
        var key = (id == null)? Math.abs( new Random().nextLong() ) : id;
        this.id = key;
        this.nome = nome;
        this.icone = icone;
    }
}