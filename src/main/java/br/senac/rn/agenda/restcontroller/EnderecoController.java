package br.senac.rn.agenda.restcontroller;

import br.senac.rn.agenda.model.Endereco;
import br.senac.rn.agenda.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("enderecos")
public class EnderecoController {

    @Autowired
    private final EnderecoService service;

    public EnderecoController(EnderecoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Endereco> listarTodos(){return service.listarTodos();}

    @PostMapping
    public void salvar(@RequestBody Endereco endereco){
        service.salvar(endereco);
    }

    public void editar(@PathVariable Integer id, @RequestBody Endereco enderecoEditado){
        Endereco endereco = service.listarPorId(id);
        endereco.setLogradouro(enderecoEditado.getLogradouro());
        endereco.setNumero(enderecoEditado.getNumero());
        endereco.setBairro(enderecoEditado.getBairro());
        endereco.setCidade(enderecoEditado.getCidade());
        endereco.setEstado(enderecoEditado.getEstado());
        endereco.setCep(enderecoEditado.getCep());
        service.salvar(endereco);
    }

}
