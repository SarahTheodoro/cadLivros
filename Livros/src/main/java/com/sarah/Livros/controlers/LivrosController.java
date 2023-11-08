package com.sarah.Livros.controlers;

import java.util.List;

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

import com.sarah.Livros.entities.Livros;
import com.sarah.Livros.servicies.LivroService;

@RestController
@RequestMapping("/livros")
public class LivrosController {
	
	@GetMapping("/home")
	public String paginaInicial() {
		return "index";
	}

	private final LivroService livroService;

	@Autowired
	public LivrosController(LivroService livroService) {
		this.livroService = livroService;
	}

	@PostMapping
	public Livros createProduct(@RequestBody Livros livro) {
		return livroService.saveLivro(livro);
	}

	@DeleteMapping("/{id}")
	public void deleteLivro(@PathVariable Long id) {
		livroService.deleteLivro(id);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Livros> getLivro(@PathVariable Long id) {
		Livros livro = livroService.getLivroById(id);
		if (livro != null) {
			return ResponseEntity.ok(livro);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@GetMapping
	public List<Livros> getAllLivros() {
		return livroService.getAlllivro();
	}

	@PutMapping("/{id}")
	public Livros updateLivro(@PathVariable Long id, @RequestBody Livros livro) {
		return livroService.updateLivro(id, livro);
	}


}
