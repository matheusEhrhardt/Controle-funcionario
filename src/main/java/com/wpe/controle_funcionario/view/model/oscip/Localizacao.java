package com.wpe.controle_funcionario.view.model.oscip;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "LOCALIZACAO_FUNC")
public class Localizacao implements Serializable {

    @Id
    @Column(name = "ID_LOCALIZACAO")
    @GeneratedValue(generator = "SEQ_LOCALIZACAO_FUNC", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "SEQ_LOCALIZACAO_FUNC", sequenceName = "SEQ_LOCALIZACAO_FUNC", allocationSize = 1)
    private Integer id;

    @Column(name = "CEP")
    private String cep;

    @Column(name = "ESTADO")
    private String estado;

    @Column(name = "CIDADE")
    private String cidade;

    @Column(name = "BAIRRO")
    private String bairro;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
}
