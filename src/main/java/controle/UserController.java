/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;
import Usuario.Usuario;
import Usuario.UsuarioBeanServiceLocal;
import java.util.Optional;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.security.enterprise.SecurityContext;
import javax.servlet.ServletException;


@Named(value = "userController")
@RequestScoped
public class UserController {

    @Inject
    UsuarioBeanServiceLocal dataService;

    @Inject
    SecurityContext securityContext;

    @Inject
    FacesContext facesContext;
    
    private Optional<Usuario> currentUser;
    public UserController() {
    }
    @PostConstruct
    public void initialize() {
        String username = securityContext.getCallerPrincipal().getName();
        this.currentUser = dataService.getUser(username);
       
    }
    public Usuario getCurrentUser() {
        return currentUser.orElse(null);
    }
    public boolean isAuthenticated() {
        return securityContext.getCallerPrincipal() != null;
    }
    public boolean isAllowedToSeeUsers() {
        return securityContext.isCallerInRole("admin");
    }
    public String logout() throws ServletException {
        facesContext.getExternalContext()
                .invalidateSession();
        return "/login?faces-redirect=true";
    }
    
}
