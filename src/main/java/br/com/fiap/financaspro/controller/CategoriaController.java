package br.com.fiap.financaspro.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.fiap.financaspro.model.Categoria;
import br.com.fiap.financaspro.repository.CategoriaRepository;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    CategoriaRepository repository;

    @GetMapping
    public List<Categoria> index() {
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Categoria cadastrarCategoria(@RequestBody Categoria categoria) {
        log.info("Cadastrando categoria: {}", categoria);
        repository.save(categoria);
        return categoria;
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> mostraCategoria(@PathVariable Long id){
        log.info("Buscando categoria por id {}", id);

        return repository
                .findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
        
        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> destroy(@PathVariable Long id) {
        log.info("apagando categoria");

        repository
            .findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Não existe categoria com o id informado. Consulte lista em /categoria"));

        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> update(@PathVariable Long id, @RequestBody Categoria categoria) {
        log.info("atualizando categoria com id {} para {}", id, categoria);

        repository
            .findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Não existe categoria com o id informado. Consulte lista em /categoria"));

        var categoriaAtualizada = new Categoria();
        categoriaAtualizada.setId(id);
        categoriaAtualizada.setNome(categoria.getNome());
        categoriaAtualizada.setIcone(categoria.getIcone());

        repository.save(categoriaAtualizada);

        return ResponseEntity.ok(categoriaAtualizada);

    }





    // private Optional<Categoria> getCategoriaById(Long id) {
    //     var categoriaEncontrada = repository
    //             .stream()
    //             .filter( c -> c.id().equals(id) )
    //             .findFirst();
    //     return categoriaEncontrada;
    // }

}