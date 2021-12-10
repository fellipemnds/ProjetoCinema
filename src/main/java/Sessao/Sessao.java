/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sessao;

import Filme.Filme;
import Ingresso.Ingresso;
import Sala.Sala;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity (name = "sessao")
@Table (name = "tbl_sessao")//nome da tabela
@NamedQueries({
    @NamedQuery(
            name="sessao.findAll",
            query = "select s from sessao s " + "where s.lixo = false " + "order by s.id"
    ),
     @NamedQuery(
            name = "sessao.findSessaoById",
            query = "select s from sessao s "
                        + "left join fetch s.filme "
            + "where s.lixo = false and s.id = :id "
            + "order by s.data"
    ),
    @NamedQuery(
            name = "sessao.findSessaoByFilme",
            query = "select s from sessao s "
                        //+ "inner join s.filme "
            + "where s.lixo = false and s.filme.id = :id "
            //+ "order by s.id"
    ) 
    
}
)
public class Sessao implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipo;
    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime data;
    private Boolean lixo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Boolean getLixo() {
        return lixo;
    }

    public void setLixo(Boolean lixo) {
        this.lixo = lixo;
    }
    
    public Sessao() {
        super();
        lixo= false;
        ingressos = new ArrayList<>();
    }

    @ManyToOne(fetch = FetchType.LAZY, // padrão
            cascade = CascadeType.ALL)
    @JoinColumn(name = "filme_id")
    private Filme filme;
    

    @ManyToOne(fetch = FetchType.LAZY, // padrão
            cascade = CascadeType.ALL)
    @JoinColumn(name = "sala_id")
    private Sala sala;
    
    @Column(nullable = true)
    @OneToMany(mappedBy = "sessao",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Ingresso> ingressos;

    public List<Ingresso> getIngressos() {
        return ingressos;
    }

    public void setIngressos(List<Ingresso> ingressos) {
        this.ingressos = ingressos;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }
    

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
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
        if (!(object instanceof Sessao)) {
            return false;
        }
        Sessao other = (Sessao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Sessao[ id=" + id +" tipo: "+tipo + " data:"+ data +" ]";
    }
}
