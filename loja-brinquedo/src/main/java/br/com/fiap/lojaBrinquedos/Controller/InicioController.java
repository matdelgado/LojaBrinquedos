package br.com.fiap.lojaBrinquedos.Controller;

import br.com.fiap.lojaBrinquedos.DTO.LoginDTO; // Adicione esta importação
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioController {

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("message", "Bem-vindo ao Thymeleaf!");
        return "home";
    }

    @GetMapping("/req/signup")
    public String signup(Model model) {
        model.addAttribute("login", new LoginDTO()); // Adiciona o modelo LoginDTO
        return "cadastro";
    }

    @GetMapping("/req/login")
    public String login(Model model) {
        model.addAttribute("login", new LoginDTO()); // Adiciona o modelo LoginDTO
        return "login";
    }
}
