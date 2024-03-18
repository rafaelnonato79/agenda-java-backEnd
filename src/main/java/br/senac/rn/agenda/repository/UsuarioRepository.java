package br.senac.rn.agenda.repository;

import br.senac.rn.agenda.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {

    Usuario findByUsuario(String usuario);

}
