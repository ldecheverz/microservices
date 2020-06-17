package com.globallogic.auth.service.controller;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthServiceController {

    /**
     * Method to validate access token and retrieve asigned roles
     * @param user
     * @return
     */
    @GetMapping(value = "/user")
    public Map<String, Object> user (OAuth2Authentication user){
        Map<String, Object> userInfo = new HashMap<>();
        userInfo.put(
                "user",
                user.getUserAuthentication()
                        .getPrincipal());
        userInfo.put("authorities",
                AuthorityUtils.authorityListToSet(
                        user.getUserAuthentication()
                                .getAuthorities()));
        return userInfo;
    }
}
