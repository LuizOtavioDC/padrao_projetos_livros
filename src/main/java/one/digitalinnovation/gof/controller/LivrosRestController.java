package one.digitalinnovation.gof.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import one.digitalinnovation.gof.model.Livros;
import one.digitalinnovation.gof.service.LivrosService;

@RestController
@RequestMapping("clientes")
public class LivrosRestController {

	@Autowired
	private LivrosService LivrosService;

	@GetMapping
	public ResponseEntity<Iterable<Livros>> buscarTodos() {
		return ResponseEntity.ok(LivrosService.buscarTodos());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Livros> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(LivrosService.buscarPorId(id));
	}

	@PostMapping
	public ResponseEntity<Livros> inserir(@RequestBody Livros livros) {
		LivrosService.inserir(livros);
		return ResponseEntity.ok(livros);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Livros> atualizar(@PathVariable Long id, @RequestBody Livros livros) {
		LivrosService.atualizar(id, livros);
		return ResponseEntity.ok(livros);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		LivrosService.deletar(id);
		return ResponseEntity.ok().build();
	}
}
