package br.com.fiap.lojaBrinquedos.Service;

import br.com.fiap.lojaBrinquedos.DTO.LoginDTO;
import br.com.fiap.lojaBrinquedos.Factory.LoginFactory;
import br.com.fiap.lojaBrinquedos.Models.Login;
import br.com.fiap.lojaBrinquedos.Repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoginService implements UserDetailsService {

    private final LoginRepository loginRepository;
    private final LoginFactory factory;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public LoginService(LoginRepository loginRepository, LoginFactory factory, PasswordEncoder passwordEncoder) {
        this.loginRepository = loginRepository;
        this.factory = factory;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Login> user = loginRepository.findByUsername(username);
        if (user.isPresent()) {
            var usernameObj = user.get();
            return User.builder()
                    .username(usernameObj.getUsername())
                    .password(usernameObj.getSenha())
                    .build();
        } else {
            throw new UsernameNotFoundException(username);
        }
    }

    public List<LoginDTO> getAll() {
        return factory.toDto((List<Login>) loginRepository.findAll());
    }

    public LoginDTO getById(Long id) {
        Optional<Login> loginOptional = loginRepository.findById(id);
        return loginOptional.map(factory::toDto).orElse(null);
    }

    public LoginDTO criarLogin(LoginDTO login) throws Exception {
        String encryptedPassword = passwordEncoder.encode(login.getSenha());
        login.setSenha(encryptedPassword);
        Login novoLogin = loginRepository.save(factory.toEntity(login));
        return factory.toDto(novoLogin);
    }

    public LoginDTO updateLogin(Long id, LoginDTO login) throws Exception {
        Login loginExistente = loginRepository.findById(id).orElse(null);

        if (loginExistente != null) {
            if (login.getSenha() != null) {
                String encryptedPassword = passwordEncoder.encode(login.getSenha());
                login.setSenha(encryptedPassword);
            }
            Login desatualizado = factory.toEntity(login);
            desatualizado.setId(id);
            Login atualizado = loginRepository.save(desatualizado);
            return factory.toDto(atualizado);
        } else {
            return null;
        }
    }
}
