package br.com.fiap.lojaBrinquedos.Service;

import br.com.fiap.lojaBrinquedos.Models.Login;
import br.com.fiap.lojaBrinquedos.Repository.LoginRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class LoginService implements UserDetailsService {

    @Autowired
    private final LoginRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Login> login = repository.findByUsername(username);
        if (login.isPresent()) {
            var usernameObj = login.get();
            return User.builder()
                    .username(usernameObj.getUsername())
                    .password(usernameObj.getPassword())
                    .roles("USER")
                    .build();
        } else {
            throw new UsernameNotFoundException("Username not Found: " + username);
        }
    }
}
