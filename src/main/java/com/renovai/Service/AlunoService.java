package com.renovai.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.renovai.Model.Aluno;
import com.renovai.Repository.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	AlunoRepository alunoRepository;

	public ResponseEntity<?> cadastrarAluno(Aluno aluno) {

		Aluno alunoExist = alunoRepository.findById(aluno.getMatricula()).orElse(null);

		if (alunoExist != null) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Professor já cadastrado!");
		}

		alunoRepository.save(aluno);

		return ResponseEntity.ok().build();

	}

}
