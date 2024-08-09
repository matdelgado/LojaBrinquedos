package br.com.fiap.lojaBrinquedos.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class InicioController {

    @GetMapping
    public String home(){
        return "Bem vindo a nossa API de controle para uma loja de brinquedos";
    }

}
