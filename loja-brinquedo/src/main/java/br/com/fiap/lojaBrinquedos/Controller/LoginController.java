package br.com.fiap.lojaBrinquedos.Controller;

import br.com.fiap.lojaBrinquedos.DTO.LoginDTO;
import br.com.fiap.lojaBrinquedos.Factory.LoginFactory;
import br.com.fiap.lojaBrinquedos.Models.Login;
import br.com.fiap.lojaBrinquedos.Repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private LoginFactory factory;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping(value = "/req/signup", consumes = "application/json")
    public ResponseEntity<EntityModel<LoginDTO>> createUser(@RequestBody LoginDTO loginDTO) {
        Optional<Login> existingUser = loginRepository.findByUsername(loginDTO.getUsername());
        if (existingUser.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build(); // Retorna 409 se o usuário já existir
        }

        loginDTO.setSenha(passwordEncoder.encode(loginDTO.getSenha()));

        Login newUser = loginRepository.save(factory.toEntity(loginDTO));

        return ResponseEntity.ok(LoginDTO.toModel(factory.toDto(newUser)));
    }

    @PostMapping(value = "/req/login")
    public ResponseEntity<String> login(@ModelAttribute LoginDTO loginDTO) {
        Optional<Login> userDB = loginRepository.findByUsername(loginDTO.getUsername());

        if (userDB.isPresent()) {
            System.out.println("Usuário encontrado: " + userDB.get().getUsername()); // Debug
            if (passwordEncoder.matches(loginDTO.getSenha(), userDB.get().getSenha())) {
                System.out.println("Senha correta"); // Debug
                return ResponseEntity.status(HttpStatus.FOUND)
                        .location(URI.create("/brinquedos"))
                        .build();
            } else {
                System.out.println("Senha incorreta"); // Debug
            }
        } else {
            System.out.println("Usuário não encontrado"); // Debug
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body("Erro de autenticação");
    }


}
