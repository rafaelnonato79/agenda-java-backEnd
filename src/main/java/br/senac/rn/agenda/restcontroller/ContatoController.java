package br.senac.rn.agenda.restcontroller;

import br.senac.rn.agenda.model.Contato;
import br.senac.rn.agenda.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.Authenticator;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/contatos")
public class ContatoController {

    @Autowired
    private ContatoService service;

    @GetMapping
    public List<Contato> listarTodos() {
        return service.listarTodos();
    }

    @GetMapping("{id}")
    public Contato listarPorId(@PathVariable Integer id){
        return service.listarPorId(id);
    }

    @PostMapping
    public void salvar(@RequestBody Contato contato) {
        service.salvar(contato);
    }

    @GetMapping("fone/{fone}")
    public List<Contato> listarPorFone(@PathVariable String fone) {
        return service.listarPorFone(fone);
    }

    @PutMapping("{id}")
    public void editar(@PathVariable Integer id, @RequestBody Contato contatoEditado){
        Contato contato = service.listarPorId(id);
        contato.setNome(contatoEditado.getNome());
        contato.setFone(contatoEditado.getFone());
        contato.setEmail(contatoEditado.getEmail());
        service.salvar(contato);
    }

    @DeleteMapping("{id}")
    public void excluir(@PathVariable Integer id){
        service.excluir(id);
    }
}
