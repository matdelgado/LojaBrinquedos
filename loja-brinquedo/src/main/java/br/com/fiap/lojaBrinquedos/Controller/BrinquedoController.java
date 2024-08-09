package br.com.fiap.lojaBrinquedos.Controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.lojaBrinquedos.DTO.BrinquedoDTO;
import br.com.fiap.lojaBrinquedos.Service.BrinquedoService;


@RestController
@RequestMapping("/brinquedos")
public class BrinquedoController {

    @Autowired
    private BrinquedoService brinquedoService;
    
    @GetMapping
    public ResponseEntity<List<EntityModel<BrinquedoDTO>>> getAll() {
        List<BrinquedoDTO> brinquedos = brinquedoService.getAll();
        List<EntityModel<BrinquedoDTO>> brinquedoModels = brinquedos.stream()
                .map(BrinquedoDTO::toModel)
                .collect(Collectors.toList());

        return ResponseEntity.ok(brinquedoModels);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<BrinquedoDTO>> getById(@PathVariable Long id){
        BrinquedoDTO brinquedoExistente = brinquedoService.getById(id);
        if (brinquedoExistente != null) {
            return ResponseEntity.ok(BrinquedoDTO.toModel(brinquedoExistente));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping()
    public ResponseEntity<?> criarBrinquedo(@RequestBody BrinquedoDTO brinquedo){
        BrinquedoDTO novoBrinquedo = brinquedoService.criarBrinquedo(brinquedo);
        if( novoBrinquedo != null){
            return ResponseEntity.status(HttpStatus.CREATED).body(BrinquedoDTO.toModel(novoBrinquedo));
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Não foi possível realizar a operação");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarBrinquedo(@PathVariable Long id){
        boolean brinquedoDeletado = brinquedoService.deleteBrinquedo(id);
        if(brinquedoDeletado) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Foi realizado a exclusão do brinquedo");
        }
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<EntityModel<BrinquedoDTO>> atualizarBrinquedo(@PathVariable Long id, @RequestBody BrinquedoDTO brinquedo){
        BrinquedoDTO brinquedoAtualiazado = brinquedoService.updateBrinquedo(id, brinquedo);

        if(brinquedoAtualiazado != null){
            return ResponseEntity.ok(BrinquedoDTO.toModel(brinquedoAtualiazado));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PatchMapping("/{id}")
    public ResponseEntity<EntityModel<BrinquedoDTO>> atualizarParcialBrinquedo(@PathVariable Long id, @RequestBody BrinquedoDTO brinquedo) {
        try {
            BrinquedoDTO brinquedoAtualizado = brinquedoService.updatePartialBrinquedo(id, brinquedo);

            if (brinquedoAtualizado != null) {
                return ResponseEntity.ok(BrinquedoDTO.toModel(brinquedoAtualizado));
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
