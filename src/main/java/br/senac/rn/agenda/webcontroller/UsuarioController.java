package br.senac.rn.agenda.webcontroller;

import br.senac.rn.agenda.model.Usuario;
import br.senac.rn.agenda.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("usuario")
public class UsuarioController {
    private final UsuarioService service;

    @Autowired
    public UsuarioController(UsuarioService service){
        this.service = service;
    }

    @GetMapping("novo")
    public String novoUsuario(Model model){
        model.addAttribute("usuario", new Usuario());
        return "cadastro";
    }

    @PostMapping("salvar")
    public String salvarUsuario(Usuario usuario){
        service.salvar(usuario);
        return "redirect:/login";
    }
}
