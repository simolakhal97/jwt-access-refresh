package com.example.livreson.service.servicelmp;

import com.alibou.security.token.TokenType;
import com.example.livreson.Model.Client;
import com.example.livreson.Model.Roles;
import com.example.livreson.Model.Token;
import com.example.livreson.auth.AuthenticationResponse;
import com.example.livreson.config.JwtService;
import com.example.livreson.repository.ClienRepo;
import com.example.livreson.repository.TokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
  private final ClienRepo repository;
  private final TokenRepository tokenRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;

  public AuthenticationResponse register(Client request) {
    var client = Client.builder()
            .fullnameCl(request.getFullnameCl())
            .emailCl(request.getEmailCl())
            .villecl(request.getVillecl())
            .rIB(request.getrIB())
            .banckName(request.getBanckName())
            .storeName(request.getStoreName())
            .phone(request.getPhone())
        .passwordClient(passwordEncoder.encode(request.getPassword()))
            .roles(Roles.CLIENT)
        .build();
    var savedUser = repository.save(client);
    var jwtToken = jwtService.generateToken(client);
    saveUserToken(savedUser, jwtToken);
    return AuthenticationResponse.builder()
        .token(jwtToken)
        .build();
  }

  public AuthenticationResponse authenticate(Client request) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            request.getEmailCl(),
            request.getPasswordClient()
        )
    );
    Client client = repository.findClientByEmailCl(request.getEmailCl())
            .orElseThrow();
    var jwtToken = jwtService.generateToken(client);
    revokeAllUserTokens(client);
    saveUserToken(client, jwtToken);
    return AuthenticationResponse.builder()
        .token(jwtToken)
        .build();
  }

  private void saveUserToken(Client client, String jwtToken) {
    var token = Token.builder()
        .client(client)
        .token(jwtToken)
        .tokenType(TokenType.BEARER)
        .expired(false)
        .revoked(false)
        .build();
    tokenRepository.save(token);
  }

  private void revokeAllUserTokens(Client client) {
    var validUserTokens = tokenRepository.findAllValidTokenByUser(client.getIdClient());
    if (validUserTokens.isEmpty())
      return;
    validUserTokens.forEach(token -> {
      token.setExpired(true);
      token.setRevoked(true);
    });
    tokenRepository.saveAll(validUserTokens);
  }
}
