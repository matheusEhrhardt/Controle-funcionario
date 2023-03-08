package com.wpe.controle_funcionario.service;

import com.wpe.controle_funcionario.dto.LocalizacaoDTO;
import com.wpe.controle_funcionario.repository.oscip.LocalizacaoRepository;
import com.wpe.controle_funcionario.view.model.oscip.Localizacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocalizacaoService {

    @Autowired
    private LocalizacaoRepository localizacaoRepository;

    public Localizacao findLocalizacaoExistente(String estado, String cidade, String bairro){
        return localizacaoRepository.findLocalizacaoExistente(estado,cidade,bairro);
    }

    public Localizacao setDtoToModel(LocalizacaoDTO dto){
        Localizacao model = new Localizacao();
        model.setCep(dto.getCep());
        model.setEstado(dto.getEstado());
        model.setCidade(dto.getCidade());
        model.setBairro(dto.getBairro());
        return model;
    }
}
