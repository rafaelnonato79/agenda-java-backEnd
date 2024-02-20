package br.senac.rn.agenda.service;

import br.senac.rn.agenda.model.Usuario;
import br.senac.rn.agenda.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements UserDetailsService {

    private final UsuarioRepository repository;

    @Autowired
    public UsuarioService(UsuarioRepository repository){
        this.repository = repository;
    }


    @Override
    public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
        Usuario user = repository.findByUsuario(usuario);
        if(user == null){
            throw new UsernameNotFoundException("Usuario não encontrado");
        }
        return user;

    }

    public void salvar(Usuario usuario) {
        repository.save(usuario);
    }
}
