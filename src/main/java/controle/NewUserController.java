/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import Usuario.Usuario;
import Usuario.UsuarioBeanServiceLocal;
import java.util.List;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@Named(value = "newUserController")
@RequestScoped
public class NewUserController {
    
    @Inject
    UsuarioBeanServiceLocal dataService;
    
    private Usuario user;
   

    /**
     * Creates a new instance of NewUserController
     */
    public NewUserController() {
        user = new Usuario();
    }

    //<editor-fold defaultstate="collapsed" desc="Getters/Setters">
    public Usuario getUser() {
        return user;
    }

    public void setUser(Usuario user) {
        this.user = user;
    }
    //</editor-fold>
    
    public String save() {
        user = dataService.createUser(
                user.getNome(), 
                user.getUsername(),
                user.getEmail(),
                user.getTelefone(),
                user.getSenha(), 
                user.getGroup(),
                user.isLixo());
        
        return "/app/users?faces-redirect=true";
    }
    
}