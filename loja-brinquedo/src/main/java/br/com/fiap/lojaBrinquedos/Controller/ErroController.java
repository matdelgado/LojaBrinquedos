package br.com.fiap.lojaBrinquedos.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/erro")
public class ErroController {

    @GetMapping
    public String home(){
        return "Ocorreu um erro inesperado, por favor tente novamente mais tarde.";
    }

}
