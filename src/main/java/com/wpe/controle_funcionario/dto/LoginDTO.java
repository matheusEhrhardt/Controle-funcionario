package com.wpe.controle_funcionario.dto;

public class LoginDTO {

    private String codigoUsuario;

    private String senha;

    public LoginDTO() {
    }

    public LoginDTO(String codigoUsuario, String senha) {
        this.codigoUsuario = codigoUsuario;
        this.senha = senha;
    }

    public String getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
