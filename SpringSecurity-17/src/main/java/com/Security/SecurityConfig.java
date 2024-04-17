package com.Security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.oauth2.core.oidc.user.OidcUserAuthority;
import org.springframework.security.oauth2.core.user.OAuth2UserAuthority;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
class SecurityConfig {

	 @Bean
	    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
	        http
	                .oauth2Client()
	                    .and()
	                .oauth2Login()
	                .tokenEndpoint()
	                    .and()
	                .userInfoEndpoint();

	        http
	                .sessionManagement()
	                .sessionCreationPolicy(SessionCreationPolicy.ALWAYS);

	        http
	                .authorizeHttpRequests()
	                            .requestMatchers("/users")
	                                .fullyAuthenticated()
	                .and()
	                    .logout()
	                    .logoutSuccessUrl("http://localhost:8080/realms/external/protocol/openid-connect/logout?redirect_uri=http://localhost:8081/");

	        return http.build();
	    }}
