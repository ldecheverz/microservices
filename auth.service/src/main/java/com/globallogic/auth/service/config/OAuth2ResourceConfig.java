package com.globallogic.auth.service.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
public class OAuth2ResourceConfig extends ResourceServerConfigurerAdapter {
    /**
     * Metodo para configurar la seguridad de los distintos endpoints de la aplicacion bajo
     * el protocolo Oauth2
     * @param http
     * @throws Exception
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.httpBasic().disable().authorizeRequests()
                .antMatchers("/oauth/healthcheck/").permitAll()
                .antMatchers("/oauth/").permitAll()
                .antMatchers("/oauth/version").permitAll()
                .antMatchers("/oauth/v2/api-docs").permitAll()
                .antMatchers("/oauth/document/token").permitAll()
                .antMatchers("/oauth/company/token").permitAll()
                .antMatchers("/oauth/token/dni").permitAll()
                .antMatchers("/trace").permitAll()
                .anyRequest().authenticated()
                .and().csrf().disable();
    }
}
