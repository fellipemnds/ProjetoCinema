/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.security.enterprise.identitystore.Pbkdf2PasswordHash;

/**
 *
 * @author matec
 */
@Stateless
public class UsuarioBeanService implements UsuarioBeanServiceLocal {
    @PersistenceContext(unitName = "SistemaPU")
    EntityManager entityManager;
    
    @Inject
    Pbkdf2PasswordHash passwordHasher;
    
    @Override
    public void Salvar(Usuario usuario)
    {
        if(entityManager.contains(usuario))
        {
            System.out.println("TaskServiceBean::save[U].task=>"+usuario);
            entityManager.persist(usuario);
        }else if(usuario.getId()!=null)
        {
            System.out.println("TaskServiceBean::save[U].task=>"+usuario);
            entityManager.merge(usuario);
        }else
        {
            System.out.println("UsuarioServiceBean::save[U].task=>"+usuario);
            entityManager.merge(usuario);
        }
    }
    @Override
    public List<Usuario> findAll()
    {
        return entityManager.createNamedQuery("usuario.findAll",Usuario.class).getResultList();
    }
    
    @Override
    public void MoverLixeira(Usuario usuario)
    {
        usuario.setLixo(true);
        entityManager.merge(usuario);
    }

    @Override
    public Usuario loadUsuarioWithIngressos(Long id) { 
        return entityManager
                .createNamedQuery(
                        "usuario.loadUsuarioWithIngressos",
                        Usuario.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public Usuario findUsuarioById(Long id) {
        return entityManager
                .createNamedQuery(
                        "usuario.findUsuarioById",
                        Usuario.class)
                .setParameter("id", id)
                .getSingleResult();
    }
    @Override
    public Usuario createUser(String name, String username,String email, String telefone, String password, String group, Boolean lixo) {

        // @see ApplicationConfig
        Map<String, String> parameters = new HashMap<>();
        parameters.put("Pbkdf2PasswordHash.Iterations", "3071");
        parameters.put("Pbkdf2PasswordHash.Algorithm", "PBKDF2WithHmacSHA512");
        parameters.put("Pbkdf2PasswordHash.SaltSizeBytes", "64");
        passwordHasher.initialize(parameters);

        Usuario newUser = new Usuario(
                name,
                username,
                email,
                telefone,
                passwordHasher.generate(
                        password.toCharArray()),
                group, lixo);
        entityManager.persist(newUser);
//        em.flush();
        return newUser;
    }
    
    @Override
    public Optional<Usuario> getUser(String username) {
        return entityManager.createNamedQuery("usuario.findUsuarioByName", Usuario.class)
                .setParameter("username", username)
                .getResultList()
                .stream()
                .findFirst(); // Can be null (Optional)...
    }
    
    
    
}
