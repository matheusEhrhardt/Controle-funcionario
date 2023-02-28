package com.marcos.mrcjewelscatalog.dto;

import com.wpe.controle_funcionario.enums.LogicoEnum;

public class ControlePontoDTO {

    private String codigoUsuario;

    private LogicoEnum enEntrada;

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
}
