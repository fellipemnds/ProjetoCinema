/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sala;
import Sessao.Sessao;
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


@Entity (name = "sala")
@Table (name = "tbl_sala")//nome da tabela
@NamedQueries({
    @NamedQuery(
            name="sala.findAll",
            query = "select s from sala s " + "where s.lixo = false " + "order by s.id"
    ),
     @NamedQuery(
            name = "sala.loadSalaWithSessoes",
            query = "select distinct s from sala s "
            + "left join fetch s.sessoes "
            + "where s.lixo = false and s.id = :id "
            + "order by s.id"
     ),
     @NamedQuery(
            name="sala.findSalaById",
            query = "select s from sala s " + "where s.lixo = false and s.id=:id "
                    + "order by s.id"
    )
}
)
public class Sala implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int Qnt_assentos;
    private Boolean lixo;
    
    
    @OneToMany(mappedBy = "sala",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Sessao> sessoes;

    public List<Sessao> getSessoes() {
        return sessoes;
    }

    public void setSessoes(List<Sessao> sessoes) {
        this.sessoes = sessoes;
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQnt_assentos() {
        return Qnt_assentos;
    }

    public void setQnt_assentos(int Qnt_assentos) {
        this.Qnt_assentos = Qnt_assentos;
    }

    public Boolean getLixo() {
        return lixo;
    }

    public void setLixo(Boolean lixo) {
        this.lixo = lixo;
    }
    public Sala() {
        super();
        lixo= false;
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
        if (!(object instanceof Sala)) {
            return false;
        }
        Sala other = (Sala) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Sala[ id=" + id +"Qtd assentos "+Qnt_assentos+" ]";
    }
    
}
