package com.example.sistemadeescolas.controller;

import com.example.sistemadeescolas.model.Curso;
import com.example.sistemadeescolas.repository.CursoRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cursos")
public class CursoControlador {
    @Autowired
    private CursoRepositorio repositorio;

    @PostMapping
    public Curso criar(@RequestBody Curso curso) {
        return repositorio.save(curso);
    }

    @GetMapping
    public List<Curso> listarTodos() {
        return repositorio.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> buscarPorId(@PathVariable Long id) {
        Optional<Curso> curso = repositorio.findById(id);
        return curso.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> atualizar(@PathVariable Long id, @RequestBody Curso dadosAtualizados) {
        Optional<Curso> cursoExistente = repositorio.findById(id);
        if (cursoExistente.isPresent()) {
            Curso curso = cursoExistente.get();
            curso.setNome(dadosAtualizados.getNome());
            return ResponseEntity.ok(repositorio.save(curso));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        Optional<Curso> curso = repositorio.findById(id);
        if (curso.isPresent()) {
            repositorio.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }

    }

}
