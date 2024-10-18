package br.com.fiap.lojaBrinquedos.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioController {

    @GetMapping("/")
    public String inicio(Model model) {
        model.addAttribute("message", "Bem vindo a nossa API de controle para uma loja de brinquedos");
        return "home";
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("message", "Bem-vindo ao Thymeleaf!");
        return "home";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "login";
    }

    @GetMapping("/signup")
    public String signup(Model model) {
        return "signup";
    }
}
