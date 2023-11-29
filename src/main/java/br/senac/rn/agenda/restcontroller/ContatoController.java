package br.senac.rn.agenda.restcontroller;

import br.senac.rn.agenda.model.Contato;
import br.senac.rn.agenda.service.ContatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("contatos")
public class ContatoController {

    @Autowired
    private ContatoService service;

    @GetMapping
    public List<Contato> listarTodos() {
        return service.listarTodos();
    }

    @PostMapping
    public void salvar(@RequestBody Contato contato) {
        service.salvar(contato);
    }

    @GetMapping("{fone}")
    public List<Contato> listarPorFone(@PathVariable String fone) {
        return service.listarPorFone(fone);
    }

}
