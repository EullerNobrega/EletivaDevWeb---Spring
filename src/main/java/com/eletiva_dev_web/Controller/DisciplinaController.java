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

import com.eletiva_dev_web.Model.Disciplina;
import com.eletiva_dev_web.Service.DisciplinaService;

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
	
	@DeleteMapping("/{codigo}")
	public ResponseEntity<?> removerDisciplina(@PathVariable String codigo){
		return disciplinaService.removerDisciplina(codigo);
	}

	@GetMapping
	public ResponseEntity<?> listarDisciplinas() {
		return disciplinaService.listarDisciplinas();
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<?> consultarDisciplina(@PathVariable String codigo) {
		return disciplinaService.consultarDisciplina(codigo);
	}

	@PutMapping
	public ResponseEntity<?> editarDisciplina(@RequestBody Disciplina disciplina) {
		return disciplinaService.editarDisciplina(disciplina);

	}

}
