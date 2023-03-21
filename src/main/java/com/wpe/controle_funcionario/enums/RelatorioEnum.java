package com.wpe.controle_funcionario.enums;

public enum RelatorioEnum {

//    FOLHA_PONTO("src/main/resources/relatorio/folha_ponto.jasper");

    FOLHA_PONTO("src/main/resources/relatorio/folha_ponto.jasper");

    private final String diretorio;

    RelatorioEnum(String diretorio) {
        this.diretorio = diretorio;
    }

    public String getValue() {
        return name();
    }

    public String getDiretorio() {
        return diretorio;
    }

}
