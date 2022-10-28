package it.gianluca.prova.service;

import java.util.List;

import it.gianluca.prova.model.Utente;

public interface UtentiService {
	List<Utente> getAllUtenti();
	void salvaUtente(Utente utente);
	Utente getUtenteById(long id);
	void cancellaUtenteById(long id);
	
}
