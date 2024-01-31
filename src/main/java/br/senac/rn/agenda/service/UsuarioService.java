package br.senac.rn.agenda.service;

import br.senac.rn.agenda.model.Usuario;
import br.senac.rn.agenda.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private UsuarioRepository repository;

    public void salvar(Usuario usuario){
        repository.save(usuario);
    }

    public List<Usuario> listarTodos(){
        return repository.findAll();
    }

    public Usuario listarPorId(Integer id){
        return repository.findById(id).get();
    }

    public void excluir(Integer id) { repository.deleteById(id);}


}
