package br.senac.rn.agenda.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@Entity
@Table(name = "TB_USUARIO")
public class Usuario implements UserDetails {

    @Id
    @Column(name = "USU_USARIO")
    private String usuario;

    @Column(name = "USU_SENHA")
    private String senha;

    @Column(name="USU_NOME")
    private String nome;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "TB_PAPEIS_USUARIO",
            joinColumns = @JoinColumn(name = "PDU_USU_ID"),
            inverseJoinColumns = @JoinColumn(name = "PDU_PAP_ID")
    )
    private List<Papel>papeis;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.usuario;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
