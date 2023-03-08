package com.wpe.controle_funcionario.service;

import com.wpe.controle_funcionario.dto.ControleFuncionarioDTO;
import com.wpe.controle_funcionario.exception.ResourceNotFoundException;
import com.wpe.controle_funcionario.repository.oscip.ControleFuncionarioRepository;
import com.wpe.controle_funcionario.util.GenericUtil;
import com.wpe.controle_funcionario.view.model.oscip.ControleFuncionario;
import com.wpe.controle_funcionario.view.model.oscip.Localizacao;
import com.wpe.controle_funcionario.view.model.oscip.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ControleFuncionarioService {

    @Autowired
    private ControleFuncionarioRepository controleRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private LocalizacaoService localizacaoService;

    @Autowired
    private GenericUtil genericUtil;

    public ControleFuncionario baterPonto(ControleFuncionarioDTO dto) {
        ControleFuncionario controleFuncionario = setDtoToModel(dto);
        return controleRepository.save(controleFuncionario);
    }

    public ControleFuncionario setDtoToModel(ControleFuncionarioDTO dto){
        Optional<Usuario> funcionario = usuarioService.findByCodigoUsuario(dto.getCodigoUsuario());

        if (funcionario.isEmpty()){
            throw new ResourceNotFoundException("Usuário não encontrado");
        }

        ControleFuncionario model = new ControleFuncionario();
        Localizacao localizacao = localizacaoService.findLocalizacaoExistente(
                        dto.getLocalizacao().getEstado(),
                        dto.getLocalizacao().getCidade(),
                        dto.getLocalizacao().getBairro());

        if (localizacao == null){
            localizacao = localizacaoService.setDtoToModel(dto.getLocalizacao());
        }
        model.setFuncionario(funcionario.get());
        model.setDataHora(new Date());
        model.setEnEntrada(dto.getEnEntrada());
        model.setEnHoraExtra(dto.getEnHoraExtra());
        model.setMensagem(dto.getMensagem());
        model.setLocalizacao(localizacao);

        return model;
    }
}
