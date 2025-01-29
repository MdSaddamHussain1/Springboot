package com.example.jwtAuth.Config;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CustomJwtAuthenticationConverter extends JwtAuthenticationConverter {

    protected Collection<GrantedAuthority> extractAuthorities(Jwt jwt) {
        // Extract roles from the "realm_access" claim
        List<String> roles = jwt.getClaimAsMap("realm_access") != null
                ? (List<String>) ((List<?>) jwt.getClaimAsMap("realm_access").get("roles"))
                : List.of();

        // Map roles to GrantedAuthority (prepend "ROLE_" for Spring Security convention)
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
                .collect(Collectors.toList());
    }
}
