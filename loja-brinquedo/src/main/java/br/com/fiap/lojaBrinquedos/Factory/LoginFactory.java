package br.com.fiap.lojaBrinquedos.Factory;


import br.com.fiap.lojaBrinquedos.DTO.LoginDTO;
import br.com.fiap.lojaBrinquedos.Models.Login;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class LoginFactory {
    public List<LoginDTO> toDto(List<Login> logins){
        return Optional.ofNullable(logins).map(lista -> lista.stream().map(this::toDto).collect(Collectors.toList())).orElse(Collections.emptyList());
    }

    public LoginDTO toDto(Login login){
        LoginDTO dto = new LoginDTO();

        dto.setId(login.getId());
        dto.setUsername(login.getUsername());
        dto.setSenha(login.getSenha());
        return dto;
    }

    public List<Login> toEntity(List<LoginDTO> login) {
        return Optional.ofNullable(login)
                .map(lista -> lista.stream().map(this::toEntity).collect(Collectors.toList()))
                .orElse(Collections.emptyList());
    }

    public Login toEntity(LoginDTO login){

        Login entity = new Login();
        entity.setId(login.getId());
        entity.setUsername(login.getUsername());
        entity.setSenha(login.getSenha());
        return entity;
    }
}
