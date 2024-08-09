package br.com.fiap.lojaBrinquedos.DTO;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

import br.com.fiap.lojaBrinquedos.Controller.BrinquedoController;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BrinquedoDTO {
    public Long id;
    public String nome;
    public String tipo;
    public Integer classificacao;
    public String tamanho;
    public Double preco;
    
    public static EntityModel<BrinquedoDTO> toModel(BrinquedoDTO brinquedo) {
        Link selfLink = WebMvcLinkBuilder.linkTo(BrinquedoController.class)
                                .slash(brinquedo.getId())
                                .withSelfRel();

        Link getAllLink = WebMvcLinkBuilder.linkTo(BrinquedoController.class)
                                     .withRel("getAll");
        
        Link getByIdLink = WebMvcLinkBuilder.linkTo(BrinquedoController.class)
        		.slash(brinquedo.getId())
                .withRel("getById");
        
        Link createLink = WebMvcLinkBuilder.linkTo(BrinquedoController.class)
                .withRel("create");

        Link updateLink = WebMvcLinkBuilder.linkTo(BrinquedoController.class)
                                   .slash(brinquedo.getId())
                                   .withRel("update");

        Link deleteLink = WebMvcLinkBuilder.linkTo(BrinquedoController.class)
                                   .slash(brinquedo.getId())
                                   .withRel("delete");

        return EntityModel.of(brinquedo, selfLink, getAllLink, getByIdLink, createLink, updateLink, deleteLink);
    }
}

