package br.senac.rn.agenda.restcontroller;

import br.senac.rn.agenda.model.Contato;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloController {

    @GetMapping
    public String bemVindo() {
        return "Bem vindo a API da Agenda do Curso de Full Stack";
    }

}
