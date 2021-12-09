/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormasDePagamento;

import Cartao.Cartao;
import Ingresso.Ingresso;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author matec
 */
@Entity (name = "formasdepagamento")
@Table (name = "tbl_formas_pagamento")//nome da tabela
@NamedQueries({
    @NamedQuery(
            name="formasdepagamento.findAll",
            query = "select fp from formasdepagamento fp " + "where fp.lixo = false " + "order by fp.id"
    )
    
}
)
public class FormasDePagamento implements Serializable {
    
     private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipoPagamento;
    private boolean lixo;//Guisso usa esse sistema para remover da exibicao

    public boolean isLixo() {
        return lixo;
    }

    public void setLixo(boolean lixo) {
        this.lixo = lixo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }
    
    
    public FormasDePagamento()
    {
        super();
        setLixo(false);
    }
    @OneToOne(fetch = FetchType.EAGER, // padrão
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Ingresso ingresso;
    
    @ManyToOne(fetch = FetchType.LAZY, // padrão
            cascade = CascadeType.ALL)
    @JoinColumn(name = "pagamento_cartao")
    private Cartao cartao;

    public Cartao getCartao() {
        return cartao;
    }

    public void setCartao(Cartao cartao) {
        this.cartao = cartao;
    }

    public Ingresso getIngresso() {
        return ingresso;
    }

    public void setIngresso(Ingresso ingresso) {
        this.ingresso = ingresso;
    }
    
    
    
    

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FormasDePagamento)) {
            return false;
        }
        FormasDePagamento other = (FormasDePagamento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "io.github.fellipemnds.jakartaee8.projetocinema.FormasDePagamento[ id=" + id + " ]";
    }
    
    
}
