package com.wpe.controle_funcionario.view.controller;

import com.wpe.controle_funcionario.dto.ControleFuncionarioDTO;
import com.wpe.controle_funcionario.service.ControleFuncionarioService;
import com.wpe.controle_funcionario.view.model.oscip.ControleFuncionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/controle-funcionario")
public class ControleFuncionarioController {

    @Autowired
    private ControleFuncionarioService controleFuncionarioService;

    @PostMapping("bater-ponto")
    public ResponseEntity<ControleFuncionario> baterPonto(@RequestBody ControleFuncionarioDTO dto){

        ControleFuncionario controleFuncionario = controleFuncionarioService.baterPonto(dto);
        return ResponseEntity.status(HttpStatus.OK).body(controleFuncionario);
    }
}
