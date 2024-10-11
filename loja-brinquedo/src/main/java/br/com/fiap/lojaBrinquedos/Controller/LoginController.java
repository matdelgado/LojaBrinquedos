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
        // Verifica se o usuário existe
        LoginDTO existingUser = loginService.getAll().stream()
                .filter(user -> user.getUsername().equals(loginDTO.getUsername())
                        && user.getSenha().equals(loginDTO.getSenha()))
                .findFirst()
                .orElse(null);

        if (existingUser != null) {
            return "redirect:/brinquedos/adicionar";
        } else {
            model.addAttribute("error", "Usuário ou senha inválidos. Deseja se cadastrar?");
            return "login";
        }
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
            return "redirect:/login";
        } catch (Exception e) {
            model.addAttribute("error", "Erro ao cadastrar usuário: " + e.getMessage());
            return "cadastro";
        }
    }
}
