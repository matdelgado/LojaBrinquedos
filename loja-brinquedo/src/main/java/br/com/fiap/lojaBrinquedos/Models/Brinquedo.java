package br.com.fiap.lojaBrinquedos.Models;

import javax.validation.constraints.Size;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Entity
@Table(name="TDS_TB_Brinquedos")
public class Brinquedo {
    @Id
    @Column(name="id")
    public Long id;

    @Column(name="nome")
    @Size(min = 10, max = 200, message = "O nome precisa ter entre 10 e 200 caracteres")
    public String nome;

    @Column(name="tipo")
    @Size(min = 10, max = 50, message = "O tipo precisa ter entre 10 e 50 caracteres")
    public String tipo;

    @Column(name="classificacao")
    public Integer classificacao;

    @Column(name="tamanho")
    @Size(min = 1, max = 20, message = "O tamanho precisa ter entre 1 e 20 caracteres")
    public String tamanho;

    @Column(name="preco")
    public Double preco;

}
