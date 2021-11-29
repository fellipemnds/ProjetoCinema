/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ingresso;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author PICHAU
 */
@Stateless
public class IngressoBeanService implements IngressoBeanServiceLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void Salvar(Ingresso ingresso) {
        if (entityManager.contains(ingresso)) {
            // Update attached -- Ever used??
            System.out.println("TaskServiceBean::save[U].task => " + ingresso);
            entityManager.persist(ingresso);
        } else if (ingresso.getId() != null) {
            // Detached entity
            System.out.println("TaskServiceBean::save[U'].task => " + ingresso);
            entityManager.merge(ingresso);
        } else {
            // Create new
            System.out.println("FilmeServiceBean::save[S].task => " + ingresso);
            
            // entityManager.persist(ingresso);
            // Forces the merge to all related entities
            // (CascadeType.ALL) and avoids an exception.
            // However performance degrades. Review required.
            entityManager.merge(ingresso);
    }
        
    }

    @Override
    public List<Ingresso> findAll() {
        return entityManager
                .createNamedQuery(
                        "ingresso.findAll",
                        Ingresso.class)
                .getResultList();
    }

    @Override
    public void MoverLixeira(Ingresso ingresso) {
        ingresso.setLixo(true);
        entityManager.merge(ingresso);
    }
    
    
}
