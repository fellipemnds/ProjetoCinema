/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario;

import Ingresso.Ingresso;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
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
 * @author matec
 */
@Entity (name = "usuario")
@Table (name = "tbl_usuario")//nome da tabela
@NamedQueries({
    @NamedQuery(
            name="usuario.findAll",
            query = "select u from usuario u " + "where u.lixo = false " + "order by u.id"
    ),
    @NamedQuery(
            name = "usuario.loadUsuarioWithIngressos",
            query = "select distinct u from usuario u "
            + "left join fetch u.ingressos "
            + "where u.lixo = false and u.id = :id "
            + "order by u.id"
    ),
    @NamedQuery(
            name="usuario.findUsuarioById",
            query = "select u from usuario u " + "where u.lixo = false and u.id=:id " + "order by u.id"
    ),
    @NamedQuery(
            name="usuario.findUsuarioByName",
            query = "select u from usuario u " + "where u.lixo = false and u.username=:username "
    )
    
}
)
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name", nullable = false)
    private  String nome;
    @Column(name = "username", nullable = false, unique = true)
    private String username;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "telefone", nullable = false)
    private String telefone;
    @Column(name = "user_password", nullable = false)
    private String senha;
    @Column(name = "user_group", nullable = false)
    private String group;
    private boolean lixo;

    public boolean isLixo() {
        return lixo;
    }
    
    public Usuario(String name, String username, String email, String telefone, String password, String group, Boolean lixo) {
        this.nome = name;
        this.username = username;
        this.senha = password;
        this.group = group;
        this.email= email;
        this.telefone=telefone;
        this.lixo = lixo;
    }
    public Usuario(){
        
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSenha() {
        return senha;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }
    
    
    
    public void setSenha(String senha) {
        this.senha = senha;
    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }
    
    @OneToMany(mappedBy = "usuario",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Ingresso> ingressos;

    public List<Ingresso> getIngressos() {
        return ingressos;
    }

    public void setIngressos(List<Ingresso> ingressos) {
        this.ingressos = ingressos;
    }
    
    
    
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Usuario[ id=" + id + " ]";
    }
    
    
}
