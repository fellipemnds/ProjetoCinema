/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ingresso;

import FormasDePagamento.FormasDePagamento;
import Sessao.Sessao;
import Usuario.Usuario;
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

@Entity (name = "ingresso")
@Table (name = "tbl_ingresso")//nome da tabela
@NamedQueries({
    @NamedQuery(
            name="ingresso.findAll",
            query = "select i from ingresso i " + "where i.lixo = false " + "order by i.id"
    )
    
}
)
public class Ingresso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean lixo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getLixo() {
        return lixo;
    }

    public void setLixo(Boolean lixo) {
        this.lixo = lixo;
    }
    public Ingresso() {
        super();
        lixo= false;
    }
    @ManyToOne(fetch = FetchType.LAZY, // padrão
            cascade = CascadeType.ALL)
    @JoinColumn(name = "ingresso_sessao")
    private Sessao sessao;
    
    @ManyToOne(fetch = FetchType.LAZY, // padrão
            cascade = CascadeType.ALL)
    @JoinColumn(name = "usuario_ingresso")
    private Usuario usuario;
    
    @OneToOne(fetch = FetchType.EAGER, // padrão
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private FormasDePagamento formasDePagamento;

    public FormasDePagamento getFormasDePagamento() {
        return formasDePagamento;
    }

    public void setFormasDePagamento(FormasDePagamento formasDePagamento) {
        this.formasDePagamento = formasDePagamento;
    }
    
    
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    

    public Sessao getSessao() {
        return sessao;
    }

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }   
    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ingresso)) {
            return false;
        }
        Ingresso other = (Ingresso) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "io.github.fellipemnds.jakartaee8.projetocinema.Ingresso[ id=" + id + " ]";
    }
    
}
