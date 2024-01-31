package br.senac.rn.agenda.repository;

import br.senac.rn.agenda.model.Contato;
import br.senac.rn.agenda.model.Fone;
import br.senac.rn.agenda.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {



}
