package com.sarah.Livros.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sarah.Livros.entities.Livros;
import com.sarah.Livros.repositories.LivroRepository;


@Service
public class LivroService {
	private final LivroRepository livroRepository;

	@Autowired
	public LivroService(LivroRepository livroRepository) {
		this.livroRepository = livroRepository;
	}


	public Livros saveLivro(Livros livro) {
		return livroRepository.save(livro);
	}


	public Livros getLivroById(Long id) {
		return livroRepository.findById(id).orElse(null);
	}

	public List<Livros> getAlllivro() {
		return livroRepository.findAll();
	}


	public void deleteLivro(Long id) {
		livroRepository.deleteById(id);
	}
	
	public Livros updateLivro(Long id, Livros novoLivro) {
        Optional<Livros> livroOptional = livroRepository.findById(id);
        if (livroOptional.isPresent()) {
        	Livros livroExistente = livroOptional.get();
        	livroExistente.setDescricao(novoLivro.getDescricao());
        	livroExistente.setIsbn(novoLivro.getIsbn());          
            return livroRepository.save(livroExistente); 
        } else {
            return null; 
        }
    }

}
