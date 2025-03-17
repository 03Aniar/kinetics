//package com.example.kineticstestproblemsolver.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserService;
//import org.springframework.security.oauth2.client.oidc.userinfo.OidcUserRequest;
//import org.springframework.security.oauth2.client.oidc.userinfo.OidcUser;
//import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
//
//import java.util.Collection;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//import java.util.stream.Collectors;
//
//@Configuration
//public class OidcConfig {
//
//    @Bean
//    public OidcUserService customOidcUserService() {
//        OidcUserService delegate = new OidcUserService();
//        return new OidcUserService() {
//            @Override
//            public OidcUser loadUser(OidcUserRequest userRequest) {
//                // Delegate to the default service to load user info.
//                OidcUser oidcUser = delegate.loadUser(userRequest);
//
//                // Extract roles from the "realm_access" claim (Keycloak token).
//                List<String> roles = oidcUser.getClaimAsStringList("realm_access.roles");
//                Set<GrantedAuthority> mappedAuthorities = new HashSet<>(oidcUser.getAuthorities());
//                if (roles != null) {
//                    mappedAuthorities.addAll(
//                            roles.stream()
//                                    .map(role -> new SimpleGrantedAuthority("ROLE_" + role))
//                                    .collect(Collectors.toSet())
//                    );
//                }
//
//                // Return a new OIDC user with the additional authorities.
//                return new DefaultOidcUser(mappedAuthorities,
//                        oidcUser.getIdToken(),
//                        oidcUser.getUserInfo());
//            }
//        };
//    }
//}
