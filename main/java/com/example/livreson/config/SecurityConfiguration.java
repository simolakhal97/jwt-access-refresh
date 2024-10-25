package com.example.livreson.config;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

  private final JwtAuthenticationFilter jwtAuthFilter;
  private final AuthenticationProvider authenticationProvider;
  private final LogoutHandler logoutHandler;

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .csrf()
        .disable()
        .authorizeHttpRequests()
        .antMatchers("/api/v1/auth/**","/saveEtudient","/clien-index",
                "/getColiee",
                "/getClient",
                "/client/{clientId}",
                "/clientDeleteAll",
                "/saveclient",
                "/getfacture",
                "/facture/{factureId}",
                "/saveFacture ",
                "/facture/{Id}",
                "/facture/{factureId}",
                "/etudient",
                "/getResponsable", "/responsable/{responsableId}",
                "/saveRsponsable" ,
                "/responsable/{Id}" ,
                "/responsable/{responsableid}","/{coliee}/validate",
                "/users/{etudientId}",
                "/emlpoyee/{employeeId}",
                "/getEmployee","/saveEmployee",
                "/employee/{Id}","/employee/{employeeId}","/getClient",
                "/Etudient/{userId}",
                "/users/search","/css/**", "/js/**","/validate/{validate}",
                "/client-register","/clientlogin","/client-dashboard-one")
          .permitAll()
        .anyRequest()
          .authenticated()
        .and()
          .sessionManagement()
          .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .authenticationProvider(authenticationProvider)
        .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
        .logout()
        .logoutUrl("/api/v1/auth/logout")
        .addLogoutHandler(logoutHandler)
        .logoutSuccessHandler((request, response, authentication) -> SecurityContextHolder.clearContext())
    ;

    return http.build();
  }
}
