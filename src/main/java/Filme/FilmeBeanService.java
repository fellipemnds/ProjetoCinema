/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Filme;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Gealisson
 */
@Stateless
public class FilmeBeanService implements FilmeBeanServiceLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void Salvar(Filme filme) {
        if (entityManager.contains(filme)) {
            // Update attached -- Ever used??
            System.out.println("FilmeServiceBean::save[U].filme => " + filme);
            entityManager.persist(filme);
        } else if (filme.getId() != null) {
            // Detached entity
            System.out.println("FilmeServiceBean::save[U'].filme => " + filme);
            entityManager.merge(filme);
        } else {
            // Create new
            System.out.println("FilmeServiceBean::save[S].filme => " + filme);
            
            // entityManager.persist(filme);
            // Forces the merge to all related entities
            // (CascadeType.ALL) and avoids an exception.
            // However performance degrades. Review required.
            
            entityManager.merge(filme);
    }
    
    }

    @Override
    public List<Filme> findAll() {
        return entityManager
                .createNamedQuery(
                        "filme.findAll",
                        Filme.class)
                .getResultList();
    }

    @Override
    public void MoverLixeira(Filme filme) {
        filme.setLixo(true);
        entityManager.merge(filme);
    }

    @Override
    public Filme loadFilmeByIdWithSessoes(Long id) {        
        return entityManager
                .createNamedQuery(
                        "filme.loadFilmeByIdWithSessao",
                        Filme.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public Filme loadFilmeWithSessao(Long id) {
        return entityManager
                .createNamedQuery(
                        "filme.loadFilmeWithSession",
                        Filme.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public Filme findFilme(String titulo) {
        return entityManager
                .createNamedQuery(
                        "filme.findFilmeByName",
                        Filme.class)
                .setParameter("titulo", titulo)
                .getSingleResult();
    }
    
    
    
}
