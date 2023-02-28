package com.marcos.mrcjewelscatalog.model.oscip;

import com.wpe.controle_funcionario.enums.LogicoEnum;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "CONTROLE_PONTO")
public class ControlePonto {

    @Id
    @Column(name = "ID_CONTROLE")
    @GeneratedValue(generator = "SEQ_CONTROLE_PONTO", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "SEQ_CONTROLE_PONTO", sequenceName = "SEQ_CONTROLE_PONTO", allocationSize = 1)
    private Integer id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "USUARIO")
    private Usuario usuario;

    @Column(name = "DATA_HORA")
    private Date dataHora;

    @Column(name = "EN_ENTRADA")
    @Enumerated(EnumType.STRING)
    private LogicoEnum enEntrada;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
}
