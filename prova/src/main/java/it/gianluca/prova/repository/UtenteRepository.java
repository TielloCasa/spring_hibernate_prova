package it.gianluca.prova.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.gianluca.prova.model.Utente;
@Repository
public interface UtenteRepository extends JpaRepository<Utente, Long>{

}