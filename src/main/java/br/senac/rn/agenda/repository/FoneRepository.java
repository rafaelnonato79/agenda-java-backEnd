package br.senac.rn.agenda.repository;

import br.senac.rn.agenda.model.Fone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FoneRepository extends JpaRepository<Fone, Integer> {


    List<Fone> findByNumeroLike(String numero);

}
