package com.wpe.controle_funcionario.controller;

import com.wpe.controle_funcionario.dto.ControlePontoDTO;
import com.wpe.controle_funcionario.dto.LoginDTO;
import com.wpe.controle_funcionario.service.ControlePontoService;
import com.wpe.controle_funcionario.service.UsuarioService;
import com.wpe.controle_funcionario.view.model.oscip.ControlePonto;
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

    @Autowired
    private ControlePontoService controlePontoService;

//    @GetMapping("/{id}")
//    public ResponseEntity<Funcionario> findById(@PathVariable Integer id){
//        Funcionario funcionario = usuarioService.findById(id);
//        return ResponseEntity.status(HttpStatus.OK).body(funcionario);
//    }

    @PostMapping("/salvar")
    public  ResponseEntity<Usuario> cadastrar(@RequestBody Usuario usuario){
        Usuario UsuarioNovo = usuarioService.cadastrar(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(UsuarioNovo);
    }

    @PostMapping("/login")
    public  ResponseEntity<Usuario> login(@RequestBody LoginDTO login){
        Usuario usuario = usuarioService.login(login.getCodigoUsuario(),login.getSenha());
        return ResponseEntity.status(HttpStatus.OK).body(usuario);
    }

    @PostMapping("/bater-ponto")
    public  ResponseEntity<ControlePonto> baterPonto(@RequestBody ControlePontoDTO dto){
        ControlePonto controlePonto = controlePontoService.baterPonto(dto);
        return ResponseEntity.status(HttpStatus.OK).body(controlePonto);
    }
}
