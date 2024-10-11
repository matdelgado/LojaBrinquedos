package br.com.fiap.lojaBrinquedos.Models;

import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.Size;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "TDS_TB_Login")
public class Login {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Long id;

    @Column(name = "username")
    @Size(min = 10, max = 200, message = "O usuário precisa ter entre 10 e 200 caracteres")
    public String username;

    @Column(name = "senha")
    @Size(min = 5, max = 20, message = "A senha precisa ter entre 5 e 20 caracteres")
    public String senha;
}
