package br.senac.rn.agenda.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "TB_FONE")
@Data
public class Fone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FON_ID")
    private Integer id;

    @Column(name = "FON_NUMERO", length = 15)
    private String numero;

    @Column(name = "FON_TIPO")
    @Enumerated(EnumType.STRING)
    private TipoFone tipo;

}
