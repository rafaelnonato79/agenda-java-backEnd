package br.senac.rn.agenda.webcontroller;


import br.senac.rn.agenda.model.Contato;
import br.senac.rn.agenda.model.TipoFone;
import br.senac.rn.agenda.service.ContatoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.model.IAttribute;

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

    @GetMapping("novo-contato")
    public String novoCOntato(Model model){
        model.addAttribute("contato", new Contato());
        model.addAttribute("tipos", TipoFone.values());
        return "formulario";
    }


    @PostMapping("salvar")
    public String salvar(Contato contato){
        service.salvar(contato);
        return "redirect:/";
    }
}
