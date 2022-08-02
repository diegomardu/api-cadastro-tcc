package com.diegomardu.io.foca.no.tcc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/api/usuarios").permitAll()
                .antMatchers("/api/alunos/**","/api/professores/**","/api/cadastro-tcc/**","/api/pdf/generate/**","/api/cadastro-ata/**","/api/registro_defesa/**").authenticated()
                .anyRequest().denyAll();
    }
}
