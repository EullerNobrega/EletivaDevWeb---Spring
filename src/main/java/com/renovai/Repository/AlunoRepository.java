package com.renovai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.renovai.Model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, String> {

}
