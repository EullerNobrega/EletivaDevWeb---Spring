package com.eletiva_dev_web.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eletiva_dev_web.Model.Professor;
import com.eletiva_dev_web.Service.ProfessorService;

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
	
	@DeleteMapping("/{matricula}")
	public ResponseEntity<?> removerProfessor(@PathVariable String matricula){
		return professorService.removerProfessor(matricula);
	}

	@GetMapping
	public ResponseEntity<?> listarProfessores() {
		
		return professorService.listarProfessores();
	}
	
	@GetMapping("/{matricula}")
	public ResponseEntity<?> consultarProfessor(@PathVariable String matricula) {
		return professorService.consultarProfessor(matricula);
	}

	@PutMapping
	public ResponseEntity<?> editarProfessor(@RequestBody Professor professor) {

		return professorService.editarProfessor(professor);

	}

}
