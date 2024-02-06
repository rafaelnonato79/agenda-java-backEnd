package br.senac.rn.agenda.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.springframework.security.core.GrantedAuthority;
@Data
@Table(name = "TB_PAPEIS")
@Entity
public class Papel implements GrantedAuthority {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PAP_ID")
    @Id
    private Integer id;
    @Column(name = "PAP_PAPEL")
    private String papel;

    @Override
    public String getAuthority() {
        return this.papel;
    }
}
