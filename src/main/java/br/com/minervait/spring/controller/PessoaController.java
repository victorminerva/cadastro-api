package br.com.minervait.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.minervait.spring.model.Pessoa;
import br.com.minervait.spring.service.pessoaservice.PessoaService;

@RestController
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;

	/*---Add new person---*/
	@PostMapping("/pessoa")
	public ResponseEntity<?> save(@RequestBody Pessoa pessoa) {
		long cpf = pessoaService.save(pessoa);
		return ResponseEntity.ok().body("New Pessoa has been saved with ID:" + cpf);
	}

	/*---Get a person by id---*/
	@GetMapping("/pessoa/{id}")
	public ResponseEntity<Pessoa> get(@PathVariable("id") long id) {
		Pessoa pessoa = pessoaService.get(id);
		return ResponseEntity.ok().body(pessoa);
	}

	/*---Get all persons---*/
	@GetMapping("/pessoa")
	public ResponseEntity<List<Pessoa>> list() {
		List<Pessoa> pessoas = pessoaService.list();
		return ResponseEntity.ok().body(pessoas);
	}

	/*---Update a person by id---*/
	@PutMapping("/pessoa/{id}")
	public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Pessoa pessoa) {
		pessoaService.update(id, pessoa);
		return ResponseEntity.ok().body("Pessoa has been updated successfully.");
	}

	/*---Delete a person by id---*/
	@DeleteMapping("/pessoa/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") long id) {
		pessoaService.delete(id);
		return ResponseEntity.ok().body("Pessoa has been deleted successfully.");
	}

}
