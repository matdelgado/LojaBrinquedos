package br.com.fiap.lojaBrinquedos.Repository;

import br.com.fiap.lojaBrinquedos.Models.Login;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginRepository extends JpaRepository<Login, Long> {
    Optional<Login> findByUsername(String username);
}
