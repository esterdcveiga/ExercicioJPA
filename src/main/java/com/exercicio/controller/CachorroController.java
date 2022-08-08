package com.exercicio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.exercicio.entidade.Cachorro;
import com.exercicio.repository.CachorroRepository;

@Controller
@RequestMapping("/")
public class CachorroController {
	
	@Autowired
	private CachorroRepository rep;
	
	@GetMapping
	public String index() {
		return "index";
	}

	@GetMapping("/consulta")
	public String consulta(Model model){
		Iterable<Cachorro> cachorros = rep.findAll();
		model.addAttribute("cachorros", cachorros);
		return "consulta";
	}
	
	@GetMapping("/consulta/{idcachorro}")
	public String formEditar(@PathVariable("idcachorro") int id, Model model) {
		Cachorro cachorro = rep.findById(id).get();
		model.addAttribute("cachorro", cachorro);
		return "editar";
	}
	
	@GetMapping("/cadastro")
	public String formCadastro(){
		return "cadastro";
	}
	
	@PostMapping("/cadastro")
	public String salvar (Cachorro cachorro) {
		rep.save(cachorro);
		return "redirect:/consulta";
	}
	
	@GetMapping("/delete/{idcachorro}")
	public String delete(@PathVariable("idcachorro") int id) {
		rep.deleteById(id);
		return"redirect:/consulta";
	}
}
