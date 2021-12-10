/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sessao;

import Filme.Filme;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author PICHAU
 */
@Stateless
public class SessaoBeanService implements SessaoBeanServiceLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void Salvar(Sessao sessao) {
        if (entityManager.contains(sessao)) {
            // Update attached -- Ever used??
            System.out.println("SessaoServiceBean::save[U].task => " + sessao);
            entityManager.persist(sessao);
        } else if (sessao.getId() != null) {
            // Detached entity
            System.out.println("SessaoServiceBean::save[U'].task => " + sessao);
            entityManager.merge(sessao);
        } else {
            // Create new
            System.out.println("FilmeServiceBean::save[S].task => " + sessao);
            
            // entityManager.persist(filme);
            // Forces the merge to all related entities
            // (CascadeType.ALL) and avoids an exception.
            // However performance degrades. Review required.
            entityManager.merge(sessao);
        }
    }

    @Override
    public List<Sessao> findAll() {
        return entityManager
                .createNamedQuery(
                        "sessao.findAll",
                        Sessao.class)
                .getResultList();
    }

    @Override
    public void MoverLixeira(Sessao sessao) {
        sessao.setLixo(true);
        entityManager.merge(sessao);
    }

    @Override
    public Sessao findSessionById(Long sessaoId) {
         return entityManager
                .createNamedQuery(
                        "sessao.findSessaoById",
                        Sessao.class)
                .setParameter("id", sessaoId)
                .getSingleResult();
    }

    @Override
    public List<Sessao> findSessaoByFilme(Long id) {
        return entityManager
                .createNamedQuery(
                        "sessao.findSessaoByFilme",
                        Sessao.class)
                .setParameter("id", id)
                .getResultList();
    }

    @Override
    public Filme findFilmeBySessao(Long id) {
        return entityManager
                .createNamedQuery(
                        "sessao.findFilmeBySessao",
                        Filme.class)
                .setParameter("id", id)
                .getSingleResult();
    }
    
    
    
}
