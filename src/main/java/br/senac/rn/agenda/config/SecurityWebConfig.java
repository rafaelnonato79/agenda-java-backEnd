package br.senac.rn.agenda.config;

import br.senac.rn.agenda.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityWebConfig{

    private final UsuarioService usuarioService;

    @Autowired
     public SecurityWebConfig(UsuarioService usuarioService){
         this.usuarioService = usuarioService;
     }

     @Bean
     public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
                .authorizeHttpRequests(request -> request
                        .requestMatchers("/").permitAll()
                        .requestMatchers("usuario/**").permitAll()
                        .requestMatchers("/usuarios").permitAll()
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .permitAll()
                )
                .rememberMe(Customizer.withDefaults());
        return http.build();
     }

     @Bean
     public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
     }

    @Bean
    public UserDetailsService userDetailsService() {
        return usuarioService; // Supondo que seu UsuarioService implemente UserDetailsService
    }

}
