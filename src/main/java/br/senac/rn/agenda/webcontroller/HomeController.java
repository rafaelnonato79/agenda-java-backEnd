package br.senac.rn.agenda.webcontroller;


import br.senac.rn.agenda.model.Contato;
import br.senac.rn.agenda.service.ContatoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    private final ContatoService service;

    public HomeController(ContatoService service){
        this.service = service;
    }
    @GetMapping
    public String index(Model model){
        List<Contato> contatos = service.listarTodos();
        model.addAttribute("contatos", contatos);
        return "index";
    }

}
