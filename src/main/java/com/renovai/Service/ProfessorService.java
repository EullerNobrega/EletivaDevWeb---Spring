package com.renovai.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.renovai.Model.Professor;
import com.renovai.Repository.ProfessorRepository;

@Service
public class ProfessorService {

	@Autowired
	ProfessorRepository professorRepository;

	public ResponseEntity<?> cadastrarProfessor(Professor professor) {

		Professor professorExist = professorRepository.findById(professor.getMatricula()).orElse(null);

		if (professorExist != null) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Professor já cadastrado!");
		}

		professorRepository.save(professor);

		return ResponseEntity.ok().build();

	}

	public ResponseEntity<?> listarProfessores() {

		return ResponseEntity.ok(professorRepository.findAll());

	}

	public ResponseEntity<?> editarProfessor(Professor professor) {

		Professor professorExist = professorRepository.findById(professor.getMatricula()).orElse(null);

		if (professorExist == null) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
		}

		return ResponseEntity.ok(professorRepository.save(professor));
	}

}
