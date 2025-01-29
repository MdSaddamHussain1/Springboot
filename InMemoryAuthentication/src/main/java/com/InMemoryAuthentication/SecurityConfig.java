package com.InMemoryAuthentication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((requests) -> requests.anyRequest().authenticated())
            .formLogin()  // Default form-based login configuration
            .and()
            .httpBasic(); // Default HTTP Basic authentication configuration
        return http.build();
    }
    
    @Bean
    public UserDetailsService userDetailsService()
    {
    	UserDetails user1 = User.withUsername("user1").password("{noop}password1").roles("USER").build();
    	
    	UserDetails admin = User.withUsername("admin").password("{noop}adminpassword").roles("ADMIN").build();
    	
    	UserDetails testy = User.withUsername("test").password("{noop}tes1").roles("USER").build();
     	UserDetails azharali = User.withUsername("Azhar Ali").password("{noop}Csd@110506$").roles("USER").build();
    	
    	return new InMemoryUserDetailsManager(user1,admin,testy,azharali);
    }	
}
