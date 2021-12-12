/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cartao;

import FormasDePagamento.FormasDePagamento;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Gealisson
 */
@Entity(name = "cartao")
@Table (name = "tbl_cartao")//nome da tabela
@NamedQueries({
    @NamedQuery(
            name="cartao.findAll",
            query = "select c from cartao c " + "where c.lixo = false " + "order by c.id"
    ),
    @NamedQuery(
            name="cartao.findCartaoByID",
            query = "select c from cartao c " + "where c.lixo = false and c.id=:id " + "order by c.id"
    )
 /*@NamedQuery(
            name = "cartao.loadFilmeByIdWithSessao",
            query = "select distinct f from filme f "
            + "left join fetch f.sessoes "
            + "where f.lixo = false and f.id = :id "
            + "order by f.id"
    )  */ 
}
)
public class Cartao implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Boolean lixo;
    
    public Cartao() {
        super();
        lixo= false;
    }
    
    public Boolean getLixo() {
        return lixo;
    }

    public void setLixo(Boolean lixo) {
        this.lixo = lixo;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }
    @OneToMany(mappedBy = "cartao",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<FormasDePagamento> formasDePagamentos;

    public List<FormasDePagamento> getFormasDePagamentos() {
        return formasDePagamentos;
    }

    public void setFormasDePagamentos(List<FormasDePagamento> formasDePagamentos) {
        this.formasDePagamentos = formasDePagamentos;
    }
    
    

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cartao)) {
            return false;
        }
        Cartao other = (Cartao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cartao[ id=" + id + " ]";
    }
    
}
