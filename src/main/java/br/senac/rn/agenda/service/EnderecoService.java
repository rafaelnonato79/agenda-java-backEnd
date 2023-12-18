package br.senac.rn.agenda.service;

import br.senac.rn.agenda.model.Endereco;
import br.senac.rn.agenda.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {

    @Autowired
    private final EnderecoRepository repository;

    public EnderecoService(EnderecoRepository repository) {
        this.repository = repository;
    }

    public void salvar(Endereco endereco){
        repository.save(endereco);
    }

    public List<Endereco> listarTodos(){
        return repository.findAll();
    }


    public void excluir(Integer id){ repository.deleteById(id);}

    public Endereco listarPorId(Integer id) {
        return repository.findById(id).get();

    }
}
