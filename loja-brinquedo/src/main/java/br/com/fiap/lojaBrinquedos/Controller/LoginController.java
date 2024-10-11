package br.com.fiap.lojaBrinquedos.Controller;

import br.com.fiap.lojaBrinquedos.DTO.LoginDTO;
import br.com.fiap.lojaBrinquedos.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    // Exibir a página de login
    @GetMapping
    public String showLoginPage(Model model) {
        if (!model.containsAttribute("login")) {
            model.addAttribute("login", new LoginDTO());
        }
        return "login";
    }

    // Processar o login
    @PostMapping
    public String login(@ModelAttribute @Valid LoginDTO loginDTO, Model model) {
        return "redirect:/brinquedos";
    }

    // Exibir a página de cadastro
    @GetMapping("/cadastrar")
    public String showCadastroPage(Model model) {
        model.addAttribute("login", new LoginDTO());
        return "cadastro";  // Retorna o template cadastro.html
    }

    // Processar o cadastro
    @PostMapping("/cadastrar")
    public String cadastrar(@ModelAttribute @Valid LoginDTO loginDTO, Model model) {
        try {
            loginService.criarLogin(loginDTO);
            return "redirect:/login"; // Redireciona para a página de login após cadastro
        } catch (Exception e) {
            model.addAttribute("error", "Erro ao cadastrar usuário: " + e.getMessage());
            return "cadastro";
        }
    }
}
