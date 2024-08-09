package br.com.fiap.lojaBrinquedos.Service;

import br.com.fiap.lojaBrinquedos.DTO.BrinquedoDTO;
import br.com.fiap.lojaBrinquedos.Factory.BrinquedoFactory;
import br.com.fiap.lojaBrinquedos.Models.Brinquedo;
import br.com.fiap.lojaBrinquedos.Repository.BrinquedoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrinquedoService {

    @Autowired
    private BrinquedoRepository brinquedoRepository;

    @Autowired
    private BrinquedoFactory factory;

    public List<BrinquedoDTO> getAll(){
        return factory.toDto((List<Brinquedo>) brinquedoRepository.findAll());
    }

    public BrinquedoDTO getById(Long id) {
        Optional<Brinquedo> brinquedoOptional = brinquedoRepository.findById(id);
        return brinquedoOptional.map(factory::toDto).orElse(null);
    }

    public BrinquedoDTO criarBrinquedo(BrinquedoDTO brinquedo){
        Brinquedo novoBrinquedo = brinquedoRepository.save(factory.toEntity(brinquedo));
        return factory.toDto(novoBrinquedo);
    }

    public BrinquedoDTO updateBrinquedo(Long id, BrinquedoDTO brinquedo){
        Brinquedo brinquedoExistente = brinquedoRepository.findById(id).orElse(null);

        if(brinquedoExistente != null){
            Brinquedo desatualizado = factory.toEntity(brinquedo);
            desatualizado.setId(id);

            Brinquedo atualizado = brinquedoRepository.save(desatualizado);
            return factory.toDto(atualizado);
        } else {
            return factory.toDto(brinquedoExistente);
        }
    }

    public boolean deleteBrinquedo(Long id) {
        if (brinquedoRepository.existsById(id)) {
            brinquedoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
    
    public BrinquedoDTO updatePartialBrinquedo(Long id, BrinquedoDTO brinquedo) throws Exception {
        Optional<Brinquedo> brinquedoOptional = brinquedoRepository.findById(id);

        if (!brinquedoOptional.isPresent()) {
            return null;
        }

        Brinquedo brinquedoBanco = brinquedoOptional.get();

        if (brinquedo.getNome() != null) {
            brinquedoBanco.setNome(brinquedo.getNome());
        }
        if (brinquedo.getTipo() != null) {
            brinquedoBanco.setTipo(brinquedo.getTipo());
        }
        if (brinquedo.getClassificacao() != null) {
            brinquedoBanco.setClassificacao(brinquedo.getClassificacao());
        }
        if (brinquedo.getTamanho() != null) {
            brinquedoBanco.setTamanho(brinquedo.getTamanho());
        }
        if (brinquedo.getPreco() != null) {
            brinquedoBanco.setPreco(brinquedo.getPreco());
        }

        brinquedoBanco = brinquedoRepository.save(brinquedoBanco);

        return factory.toDto(brinquedoBanco);
    }


}
