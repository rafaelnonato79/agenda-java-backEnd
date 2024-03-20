package br.senac.rn.agenda.service;

import br.senac.rn.agenda.model.Usuario;
import br.senac.rn.agenda.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService implements UserDetailsService {

    private final UsuarioRepository repository;

    private final PasswordEncoder encoder;

    @Autowired
    public UsuarioService(UsuarioRepository repository, PasswordEncoder encoder){

        this.repository = repository;
        this.encoder =  encoder;
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
        usuario.setSenha(encoder.encode(usuario.getSenha()));
        repository.save(usuario);
    }

    public Usuario getUsuarioLogado() {
     Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     if(principal instanceof Usuario){
         return (Usuario) principal;
        }
     return null;
    }
}
