package br.com.fiap.lojaBrinquedos.DTO;

import br.com.fiap.lojaBrinquedos.Controller.BrinquedoController;
import br.com.fiap.lojaBrinquedos.Controller.LoginController;
import lombok.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LoginDTO {

    public Long id;
    public String user;
    public String senha;

    public static EntityModel<LoginDTO> toModel(LoginDTO login) {
        Link selfLink = WebMvcLinkBuilder.linkTo(BrinquedoController.class)
                .slash(login.getId())
                .withSelfRel();

        Link getAllLink = WebMvcLinkBuilder.linkTo(LoginController.class)
                .withRel("getAll");

        Link getByIdLink = WebMvcLinkBuilder.linkTo(LoginController.class)
                .slash(login.getId())
                .withRel("getById");

        Link createLink = WebMvcLinkBuilder.linkTo(LoginController.class)
                .withRel("create");

        Link updateLink = WebMvcLinkBuilder.linkTo(LoginController.class)
                .slash(login.getId())
                .withRel("update");

        Link deleteLink = WebMvcLinkBuilder.linkTo(LoginController.class)
                .slash(login.getId())
                .withRel("delete");

        return EntityModel.of(login, selfLink, getAllLink, getByIdLink, createLink, updateLink, deleteLink);
    }

}
