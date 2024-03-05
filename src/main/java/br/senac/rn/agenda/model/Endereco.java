package br.senac.rn.agenda.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "TB_ENDERECO")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "END_ID")
    private Integer id;

    @Column(name = "END_LOGRADOURO", length = 200)
    private String logradouro;

    @Column(name = "END_NUMERO")
    private String numeroEndereco;

    @Column(name = "END_BAIRRO")
    private String bairro;

    @Column(name = "END_CIDADE")
    private String cidade;

    @Column(name = "END_ESTADO")
    private String estado;

    @Column(name = "END_CEP")
    private String cep;

}
