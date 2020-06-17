package com.globallogic.auth.service.security;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {


    public static final String PASSWORD = "echeverz";
    public static final String USER = "lucas";

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();

        if (USER.equals(authentication.getPrincipal()) &&
                PASSWORD.equals(authentication.getCredentials().toString())) {
            return new UsernamePasswordAuthenticationToken(
                    name, password, Collections.singletonList(new SimpleGrantedAuthority(SecurityRoles.USER_ROLE.toString())));
        } else if(PASSWORD.equals(authentication.getPrincipal()) &&
                USER.equals(authentication.getCredentials().toString())){
            return new UsernamePasswordAuthenticationToken(
                    name, password, Collections.singletonList(new SimpleGrantedAuthority(SecurityRoles.ADMIN_ROLE.toString())));
        } else {
            return null;
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
