package com.wpe.controle_funcionario.dto;

import com.wpe.controle_funcionario.enums.LogicoEnum;

public class ControleFuncionarioDTO {

    private String codigoUsuario;

    private LogicoEnum enEntrada;

    private LogicoEnum enHoraExtra;

    private LocalizacaoDTO localizacao;

    private String mensagem;

    public String getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public LogicoEnum getEnEntrada() {
        return enEntrada;
    }

    public void setEnEntrada(LogicoEnum enEntrada) {
        this.enEntrada = enEntrada;
    }

    public LogicoEnum getEnHoraExtra() {
        return enHoraExtra;
    }

    public void setEnHoraExtra(LogicoEnum enHoraExtra) {
        this.enHoraExtra = enHoraExtra;
    }

    public LocalizacaoDTO getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(LocalizacaoDTO localizacao) {
        this.localizacao = localizacao;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
