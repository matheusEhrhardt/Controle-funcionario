package com.wpe.controle_funcionario.model.oscip;

import com.wpe.controle_funcionario.enums.LogicoEnum;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "CONTROLE_FUNCIONARIO")
public class ControleFuncionario implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "SEQ_CONTROLE_PONTO", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "SEQ_CONTROLE_PONTO", sequenceName = "SEQ_CONTROLE_PONTO", allocationSize = 1)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "FUNCIONARIO")
    private Usuario funcionario;

    @Column(name = "DATA_HORA")
    private Date dataHora;

    @Column(name = "EN_ENTRADA")
    @Enumerated(EnumType.STRING)
    private LogicoEnum enEntrada;

    @Column(name = "EN_HORA_EXTRA")
    @Enumerated(EnumType.STRING)
    private LogicoEnum enHoraExtra;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "LOCALIZACAO")
    private Localizacao localizacao;

    @Column(name = "MENSAGEM")
    private String mensagem;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Usuario funcionario) {
        this.funcionario = funcionario;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
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

    public Localizacao getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(Localizacao localizacao) {
        this.localizacao = localizacao;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
