/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author matec
 */
@Named(value = "usuarioBean")
//@Dependent
@ViewScoped
public class UsuarioBean implements Serializable{
    
    @Inject
    private UsuarioBeanServiceLocal usuarioservice;
    
    private Usuario selectedUsuario;
    private Long selectedUsuarioId;
    private List<Usuario> allUsuario;
    private List<Usuario> filteredUsuario;
    public UsuarioBean(){
        
    }
    @PostConstruct
    public void init()
    {
        if(selectedUsuario==null)
            selectedUsuario = new Usuario();
    }

    public UsuarioBeanServiceLocal getUsuarioservice() {
        return usuarioservice;
    }

    public void setUsuarioservice(UsuarioBeanServiceLocal usuarioservice) {
        this.usuarioservice = usuarioservice;
    }

    public Usuario getSelectedUsuario() {
        return selectedUsuario;
    }

    public void setSelectedUsuario(Usuario selectedUsuario) {
        this.selectedUsuario = selectedUsuario;
    }

    public Long getSelectedUsuarioId() {
         if (selectedUsuarioId== null || selectedUsuario == null) {
             selectedUsuario = new Usuario();
         }
        return selectedUsuarioId;
    }

    public void setSelectedUsuarioId(Long selectedUsuarioId) {
        this.selectedUsuarioId = selectedUsuarioId;
    }

    public List<Usuario> getAllUsuario() {
        if(allUsuario==null)
            reloadUsuarios();
        return allUsuario;
    }

    public void setAllUsuario(List<Usuario> allUsuario) {
        this.allUsuario = allUsuario;
    }

    public List<Usuario> getFilteredUsuario() {
        return filteredUsuario;
    }

    public void setFilteredUsuario(List<Usuario> filteredUsuario) {
        this.filteredUsuario = filteredUsuario;
    }
    
    public String salvar(Usuario usuario)
    {
        usuarioservice.Salvar(usuario);
        reloadUsuarios();
        reset();
        return null;
    }
    
    public String salvarAtual()
    {
        salvar(selectedUsuario);
        return "CRUD_usuario?faces-redirect=true";
    }
    
    public List<Usuario> findAll(){
        return usuarioservice.findAll();
    }
    
    public void reset(){
        selectedUsuario=new Usuario();
    }
    public void reloadUsuarios(){
        allUsuario=findAll();
    }
    public String MoverLixeira(Usuario usuario)
    {
        usuarioservice.MoverLixeira(usuario);
        reloadUsuarios();
        return null;
    }
    public String MoverAtualLixeira(){
        MoverLixeira(selectedUsuario);
        return "CRUD_usuario?faces-redirect=true";
    }
    public Usuario loadUsuario(Usuario usuario){
        if(usuario!=null){
            Usuario usuariofull = usuarioservice.loadUsuarioWithIngressos(usuario.getId());
            selectedUsuario = usuariofull;
            return selectedUsuario;
        }else{
            return null;
        }     
    }
    
    
}
