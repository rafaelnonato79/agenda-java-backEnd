package br.senac.rn.agenda.service;

import br.senac.rn.agenda.model.Contato;
import br.senac.rn.agenda.repository.ContatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ContatoService {

    @Autowired
    private ContatoRepository repository;


    public void salvar(Contato contato) {
        repository.save(contato);
    }

    public List<Contato> listarTodos() {
        return repository.findAll();
    }

    public List<Contato> listarPorFone(String fone) {
        return repository.findByFone(fone);
    }

    public Contato listarPorId(Integer id) {

        return repository.findById(id).get();
    }

    public void excluir(Integer id) {
        repository.deleteById(id);
    }

}
