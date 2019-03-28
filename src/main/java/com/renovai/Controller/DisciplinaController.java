package com.renovai.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.renovai.Model.Disciplina;
import com.renovai.Service.DisciplinaService;

@CrossOrigin
@RestController
@RequestMapping("/disciplina")
public class DisciplinaController {

	@Autowired
	DisciplinaService disciplinaService;

	@PostMapping
	public ResponseEntity<?> criarDisciplina(@RequestBody Disciplina disciplina) {

		return disciplinaService.cadastrarDisciplina(disciplina);

	}

	@GetMapping
	public ResponseEntity<?> listarProfessor() {

		return disciplinaService.listarDisciplinas();
	}
	
	@GetMapping
	public ResponseEntity<?> listarProfessor(@RequestParam ) {

		return disciplinaService.listarDisciplinas();
	}

	@PutMapping
	public ResponseEntity<?> editarProfessor(@RequestBody Disciplina disciplina) {

		return disciplinaService.editarDisciplina(disciplina);

	}

}
