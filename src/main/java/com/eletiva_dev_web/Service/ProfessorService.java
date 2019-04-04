package com.eletiva_dev_web.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.eletiva_dev_web.Model.Professor;
import com.eletiva_dev_web.Repository.ProfessorRepository;

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

	public ResponseEntity<?> consultarProfessor(String matricula) {
		
		return ResponseEntity.ok(professorRepository.findById(matricula));
	}
	
	public ResponseEntity<?> editarProfessor(Professor professor) {

		Professor professorExist = professorRepository.findById(professor.getMatricula()).orElse(null);

		if (professorExist == null) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
		}

		return ResponseEntity.ok(professorRepository.save(professor));
	}
	
	public ResponseEntity<?> removerProfessor(String matricula) {
		Professor professorExist = professorRepository.findById(matricula).orElse(null);

		if (professorExist == null) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
		}
		professorRepository.delete(professorExist);
		return ResponseEntity.ok(professorExist);
	}

}
