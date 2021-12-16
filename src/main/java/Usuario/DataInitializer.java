/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Initialized;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

@ApplicationScoped
public class DataInitializer {

    @Inject
    UsuarioBeanServiceLocal dataService;

    public void execute(@Observes @Initialized(ApplicationScoped.class) Object event) {
        if (dataService.findAll().isEmpty()) {
            Usuario administrador = dataService.createUser("Admin", "admin","email@email.com","(38)111111111" ,"asd", "admin",false);
            Usuario comum = dataService.createUser("Comum", "user","email@email.com","(38)111111111", "asd", "user",false);
        }
    }
}