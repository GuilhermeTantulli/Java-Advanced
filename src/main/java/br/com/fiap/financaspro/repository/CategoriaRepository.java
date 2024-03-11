package br.com.fiap.financaspro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.financaspro.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    


}
