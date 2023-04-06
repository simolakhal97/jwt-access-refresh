package com.example.livreson.Model;

import com.alibou.security.token.TokenType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Token {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public Integer id;

  @Column(unique = true)
  public String token;

  @Enumerated(EnumType.STRING)
  public com.alibou.security.token.TokenType tokenType = TokenType.BEARER;

  public boolean revoked;

  public boolean expired;

  @ManyToOne
  @JoinColumn(name = "user_id")
  public Client client;
}
