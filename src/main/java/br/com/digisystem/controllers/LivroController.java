package br.com.digisystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.digisystem.entities.secondary.Livro;
import br.com.digisystem.repositories.secondary.LivroRepository;

@RestController
@RequestMapping("/secondary")
public class LivroController {
	
	@Autowired
	private LivroRepository livroRepository;
	
	@GetMapping
	public List<Livro> getAll(){
		return livroRepository.findAll();
	}
	
}
