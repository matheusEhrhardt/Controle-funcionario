package com.wpe.controle_funcionario.view.controller;

import com.wpe.controle_funcionario.service.UsuarioService;
import com.wpe.controle_funcionario.view.model.oscip.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/salvar")
    public  ResponseEntity<Usuario> cadastrar(@RequestBody Usuario usuario){
        Usuario UsuarioNovo = usuarioService.cadastrar(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(UsuarioNovo);
    }
}
