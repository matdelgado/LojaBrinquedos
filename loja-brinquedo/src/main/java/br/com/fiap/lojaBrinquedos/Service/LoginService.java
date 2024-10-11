package br.com.fiap.lojaBrinquedos.Service;

import br.com.fiap.lojaBrinquedos.DTO.LoginDTO;
import br.com.fiap.lojaBrinquedos.Factory.LoginFactory;
import br.com.fiap.lojaBrinquedos.Models.Login;
import br.com.fiap.lojaBrinquedos.Repository.LoginRepository;
import br.com.fiap.lojaBrinquedos.Security.RSAUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.List;
import java.util.Optional;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private LoginFactory factory;

    private PublicKey publicKey;
    private PrivateKey privateKey;

    public List<LoginDTO> getAll() {
        return factory.toDto((List<Login>) loginRepository.findAll());
    }

    public LoginDTO getById(Long id) {
        Optional<Login> loginOptional = loginRepository.findById(id);
        return loginOptional.map(factory::toDto).orElse(null);
    }

    public LoginDTO criarLogin(LoginDTO login) throws Exception {
        String encryptedPassword = RSAUtil.encrypt(login.getSenha(), publicKey);
        login.setSenha(encryptedPassword);
        Login novoLogin = loginRepository.save(factory.toEntity(login));
        return factory.toDto(novoLogin);
    }

    public LoginDTO updateLogin(Long id, LoginDTO login) throws Exception {
        Login loginExistente = loginRepository.findById(id).orElse(null);

        if (loginExistente != null) {
            if (login.getSenha() != null) {
                String encryptedPassword = RSAUtil.encrypt(login.getSenha(), publicKey);
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
