package com.wpe.controle_funcionario.service;

import com.wpe.controle_funcionario.dto.ControlePontoDTO;
import com.wpe.controle_funcionario.exception.ResourceNotFoundException;
import com.wpe.controle_funcionario.repository.oscip.ControlePontoRepository;
import com.wpe.controle_funcionario.view.model.oscip.ControlePonto;
import com.wpe.controle_funcionario.view.model.oscip.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class ControlePontoService {

    @Autowired
    private ControlePontoRepository controlePontoRepository;

    @Autowired
    private UsuarioService usuarioService;

    public ControlePonto baterPonto(ControlePontoDTO dto){
        Optional<Usuario> usuario = usuarioService.findByCodigoUsuario(dto.getCodigoUsuario());

        if(usuario.isEmpty()){
            throw new ResourceNotFoundException("Funcionário não encontrado!");
        }

        ControlePonto controlePonto = new ControlePonto();
        controlePonto.setUsuario(usuario.get());
        controlePonto.setDataHora(new Date());
        controlePonto.setEnEntrada(dto.getEnEntrada());

        return controlePontoRepository.save(controlePonto);
    }

}
