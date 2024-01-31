package br.senac.rn.agenda.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "TB_USUARIO")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USU_ID")
    private Integer id;

    @Column(name = "USU_USER")
    private String usuario;

    @Column(name = "USU_SEN")
    private String senha;

}
