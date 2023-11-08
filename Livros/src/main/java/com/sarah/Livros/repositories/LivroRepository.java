package com.sarah.Livros.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sarah.Livros.entities.Livros;


public interface LivroRepository extends JpaRepository<Livros, Long>{
	

}
