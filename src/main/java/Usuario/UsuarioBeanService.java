/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author matec
 */
@Stateless
public class UsuarioBeanService implements UsuarioBeanServiceLocal {
    @PersistenceContext
    EntityManager entityManager;
    
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
    
    
}
