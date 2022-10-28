package it.gianluca.prova.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import it.gianluca.prova.model.Utente;
import it.gianluca.prova.service.UtentiService;

@Controller
public class UtenteController {

	
	@Autowired
	private UtentiService utentiService;
	
	@GetMapping ( "/" )
	public String viewHomePage (Model model) {
		
		
		model.addAttribute("listaUtenti", utentiService.getAllUtenti());
		return "index";
		
	}
	
	@GetMapping ("/showNewUtenteForm")
	public String showNewUtenteForm(Model model) {
		
			Utente utente = new Utente ();
			model.addAttribute("utente", utente);
			return "nuovo_utente";
	}
	
	@PostMapping("/salvaUtente")
	public String salvaUtente(@ModelAttribute("Utente") Utente utente) {
	
		utentiService.salvaUtente(utente);
	    return "redirect:/";
	}

	@GetMapping ("/showModificaUtenteForm/{id}")
	public String showModificaUtenteForm(@PathVariable ( value = "id") long id , Model model) {
		
		Utente utente = utentiService.getUtenteById(id);
		
		model.addAttribute("utente" , utente);
		return "modifica_utente";
		
		
	}
	
	
	@GetMapping ("/cancellazioneUtente/{id}")
	public String cancellaUtente(@PathVariable ( value = "id" ) long id , Model model) {
		
		this.utentiService.cancellaUtenteById(id);
		return "redirect:/";
	}
	



}
