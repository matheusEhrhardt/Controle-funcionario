package com.wpe.controle_funcionario.controller;

import com.wpe.controle_funcionario.dto.LoginDTO;
import com.wpe.controle_funcionario.service.AuthenticationService;
import com.wpe.controle_funcionario.service.UsuarioService;
import com.wpe.controle_funcionario.model.auth.AuthenticationRequest;
import com.wpe.controle_funcionario.model.auth.AuthenticationResponse;
import com.wpe.controle_funcionario.model.oscip.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

  private final AuthenticationService service;

  @Autowired
  private UsuarioService usuarioService;

  @PostMapping
  public ResponseEntity<AuthenticationResponse> authenticate(
      @RequestBody AuthenticationRequest request
  ) {
    return ResponseEntity.ok(service.authenticate(request));
  }

  @PostMapping("/login")
  public  ResponseEntity<Usuario> login(@RequestBody LoginDTO login){
    Usuario usuario = usuarioService.login(login.getCodigoUsuario(),login.getSenha());
    return ResponseEntity.status(HttpStatus.OK).body(usuario);
  }

}
