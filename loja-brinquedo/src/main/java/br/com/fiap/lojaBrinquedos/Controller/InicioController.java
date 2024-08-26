package br.com.fiap.lojaBrinquedos.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioController {

    @GetMapping
    public String inicio(){
        return "Bem vindo a nossa API de controle para uma loja de brinquedos";
    }
    
    @GetMapping("/home")
    public String home(Model model){
    	model.addAttribute("message", "Bem-vindo ao Thymeleaf!");
        return "home";
    }

}
