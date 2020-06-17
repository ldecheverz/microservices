package com.globallogic.people.management.utils;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationDetails;
import org.springframework.stereotype.Component;

@Component
public class FeignRequestInterceptor implements RequestInterceptor {
    private static final String TOKEN_TYPE = "Bearer ";
    private static final String ACCEPT_LANGUAGE_HEADER = "Authorization";

    @Override
    public void apply(RequestTemplate template) {
        String token = "";
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth instanceof OAuth2Authentication) {
            Object details = auth.getDetails();
            if (details instanceof OAuth2AuthenticationDetails) {
                OAuth2AuthenticationDetails oauth = (OAuth2AuthenticationDetails) details;
                token = TOKEN_TYPE + oauth.getTokenValue();
            }
        }

        template.header("Authorization", token);
    }
}
