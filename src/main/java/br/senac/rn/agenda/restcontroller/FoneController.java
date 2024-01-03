package br.senac.rn.agenda.restcontroller;

import br.senac.rn.agenda.model.Fone;
import br.senac.rn.agenda.service.FoneService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("fones")
public class FoneController {
    private FoneService service;

    public FoneController(FoneService service){
        this.service = service;
    }
    @GetMapping
    public List<Fone> listarTodos() {return service.listarTodos();}

    @PostMapping
    public void salvar(@RequestBody Fone fone) {
        service.salvar(fone);
    }
}
