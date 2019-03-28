package com.renovai.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.renovai.Model.Disciplina;
import com.renovai.Repository.DisciplinaRepository;

@Service
public class DisciplinaService {

	@Autowired
	DisciplinaRepository disciplinaRepository;

	public ResponseEntity<?> cadastrarDisciplina(Disciplina disciplina) {

		Disciplina disciplinaExist = disciplinaRepository.findById(disciplina.getCodigo()).orElse(null);

		if (disciplinaExist != null) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Disciplina já cadastrada!");
		}

		disciplinaRepository.save(disciplina);

		return ResponseEntity.ok().build();

	}

	public ResponseEntity<?> listarDisciplinas() {

		return ResponseEntity.ok(disciplinaRepository.findAll());

	}
	
	public ResponseEntity<?> listarDisciplina(String matricula) {

		return ResponseEntity.ok(disciplinaRepository.findById(matricula));

	}

	public ResponseEntity<?> editarDisciplina(Disciplina disciplina) {

		Disciplina disciplinaExist = disciplinaRepository.findById(disciplina.getCodigo()).orElse(null);

		if (disciplinaExist == null) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
		}

		return ResponseEntity.ok(disciplinaRepository.save(disciplina));
	}

}
