/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sala;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class SalaBeanService implements SalaBeanServiceLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void Salvar(Sala sala) {
        if (entityManager.contains(sala)) {
            // Update attached -- Ever used??
            System.out.println("TaskServiceBean::save[U].task => " + sala);
            entityManager.persist(sala);
        } else if (sala.getId() != null) {
            // Detached entity
            System.out.println("TaskServiceBean::save[U'].task => " + sala);
            entityManager.merge(sala);
        } else {
            // Create new
            System.out.println("FilmeServiceBean::save[S].task => " + sala);
            
            // entityManager.persist(sala);
            // Forces the merge to all related entities
            // (CascadeType.ALL) and avoids an exception.
            // However performance degrades. Review required.
            entityManager.merge(sala);
    }
    }

    @Override
    public List<Sala> findAll() {
       return entityManager
                .createNamedQuery(
                        "sala.findAll",
                        Sala.class)
                .getResultList();
    }

    @Override
    public void MoverLixeira(Sala sala) {
        sala.setLixo(true);
        entityManager.merge(sala);
    }

    @Override
    public Sala loadSalaWithSessao(Long id) {
        return entityManager
                .createNamedQuery(
                        "sala.loadSalaWithSessoes",
                        Sala.class)
                .setParameter("id", id)
                .getSingleResult();       
        
        
    }
    
    
    
}
