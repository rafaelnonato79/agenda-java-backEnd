package br.senac.rn.agenda.repository;

import br.senac.rn.agenda.model.Endereco;
import br.senac.rn.agenda.model.Fone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

}
