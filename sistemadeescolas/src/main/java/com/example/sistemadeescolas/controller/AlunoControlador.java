package com.example.sistemadeescolas.controller;

import com.example.sistemadeescolas.model.Aluno;
import com.example.sistemadeescolas.repository.AlunoRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alunos")
public class AlunoControlador {
    @Autowired
    private AlunoRepositorio repositorio;

    @PostMapping
    public Aluno cadastrarAluno(@RequestBody Aluno aluno) {
        return repositorio.save(aluno);
    }

    @GetMapping
    public List<Aluno> listarAlunos() {
        return repositorio.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aluno> buscarAlunoPorId(@PathVariable Long id) {
        Optional<Aluno> alunoOptional = repositorio.findById(id);
        if (alunoOptional.isPresent()) {
            return ResponseEntity.ok(alunoOptional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Aluno> atualizarAluno(@PathVariable Long id, @RequestBody Aluno alunoAtualizado) {
        Optional<Aluno> alunoExistente = repositorio.findById(id);
        if (alunoExistente.isPresent()) {
            Aluno aluno = alunoExistente.get();
            aluno.setNome(alunoAtualizado.getNome());
            aluno.setCurso(alunoAtualizado.getCurso());
            aluno.setEscola(alunoAtualizado.getEscola());

            repositorio.save(aluno);
            return ResponseEntity.ok(aluno);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAluno(@PathVariable Long id) {
        Optional<Aluno> alunoOptional = repositorio.findById(id);
        if (alunoOptional.isPresent()) {
            repositorio.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }

    }

}
