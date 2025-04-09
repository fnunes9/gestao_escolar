package com.example.sistemadeescolas.repository;

import com.example.sistemadeescolas.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepositorio extends JpaRepository<Aluno, Long> {

}
