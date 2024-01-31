package br.senac.rn.agenda.restcontroller;

import br.senac.rn.agenda.model.Usuario;
import br.senac.rn.agenda.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping
    public List<Usuario> listarTodos(){return service.listarTodos();}

    @PostMapping
    public void salvar(@RequestBody Usuario usuario){
        service.salvar(usuario);
    }

    public void excluir(@PathVariable Integer id){ service.excluir(id);}

}
