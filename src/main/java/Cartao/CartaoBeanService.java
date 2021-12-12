/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cartao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author PICHAU
 */
@Stateless
public class CartaoBeanService implements CartaoBeanServiceLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void Salvar(Cartao cartao) {
        if (entityManager.contains(cartao)) {
            // Update attached -- Ever used??
            System.out.println("CartaoServiceBean::save[U].task => " + cartao);
            entityManager.persist(cartao);
        } else if (cartao.getId() != null) {
            // Detached entity
            System.out.println("CartaoServiceBean::save[U'].task => " + cartao);
            entityManager.merge(cartao);
        } else {
            // Create new
            System.out.println("CartaoServiceBean::save[S].task => " + cartao);
            
            // entityManager.persist(cartao);
            // Forces the merge to all related entities
            // (CascadeType.ALL) and avoids an exception.
            // However performance degrades. Review required.
            entityManager.merge(cartao);
    }
        
    }

    @Override
    public List<Cartao> findAll() {
        return entityManager
                .createNamedQuery(
                        "cartao.findAll",
                        Cartao.class)
                .getResultList();
    }

    @Override
    public void MoverLixeira(Cartao cartao) {
        cartao.setLixo(true);
        entityManager.merge(cartao);
    }

    @Override
    public Cartao findCartaoByID(Long id) {
        return entityManager
                .createNamedQuery(
                        "cartao.findCartaoByID",
                        Cartao.class)
                .setParameter("id", id)
                .getSingleResult();
    }
    
    
    
}
