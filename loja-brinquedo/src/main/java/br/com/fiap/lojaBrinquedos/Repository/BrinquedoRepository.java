package br.com.fiap.lojaBrinquedos.Repository;

import br.com.fiap.lojaBrinquedos.Models.Brinquedo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BrinquedoRepository extends CrudRepository<Brinquedo, Long> {
}

