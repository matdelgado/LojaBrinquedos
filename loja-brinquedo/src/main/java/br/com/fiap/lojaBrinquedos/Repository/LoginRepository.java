package br.com.fiap.lojaBrinquedos.Repository;

import br.com.fiap.lojaBrinquedos.Models.Login;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends CrudRepository<Login, Long> {
}

