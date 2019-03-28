package com.renovai.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.renovai.Model.Professor;
import com.renovai.Service.ProfessorService;

@CrossOrigin
@RestController
@RequestMapping("/professor")
public class ProfessorController {

	@Autowired
	ProfessorService professorService;

	@PostMapping
	public ResponseEntity<?> criarProfessor(@RequestBody Professor professor) {

		return professorService.cadastrarProfessor(professor);

	}

	@GetMapping
	public ResponseEntity<?> listarProfessor() {

		return professorService.listarProfessores();
	}

	@PutMapping
	public ResponseEntity<?> editarProfessor(@RequestBody Professor professor) {

		return professorService.editarProfessor(professor);

	}

}
