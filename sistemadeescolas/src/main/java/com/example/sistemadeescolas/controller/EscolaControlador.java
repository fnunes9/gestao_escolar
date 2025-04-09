package com.example.sistemadeescolas.controller;

import com.example.sistemadeescolas.model.Escola;
import com.example.sistemadeescolas.repository.EscolaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/escolas")
public class EscolaControlador {
    @Autowired
    private EscolaRepositorio repositorio;

    @GetMapping
    public List<Escola> listarTodas() {
        return repositorio.findAll();
    }

    @PostMapping
    public Escola criar(@RequestBody Escola escola) {
        return repositorio.save(escola);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        repositorio.deleteById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Escola> atualizarEscola(@PathVariable Long id, @RequestBody Escola novaEscola) {
        Optional<Escola> escolaExistente = repositorio.findById(id);
        if (escolaExistente.isPresent()) {
            Escola escola = escolaExistente.get();
            escola.setNome(novaEscola.getNome());

            Escola escolaAtualizada = repositorio.save(escola);
            return ResponseEntity.ok(escolaAtualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
