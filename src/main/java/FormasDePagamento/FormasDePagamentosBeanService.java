/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormasDePagamento;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author matec
 */
@Stateless
public class FormasDePagamentosBeanService implements FormasDePagamentoBeanServiceLocal{
    @PersistenceContext
    EntityManager entityManager;
    
    @Override
    public void Salvar(FormasDePagamento formaDePagamento)
    {
        if(entityManager.contains(formaDePagamento))
        {
            System.out.println("TaskServiceBean::save[U].task=>"+formaDePagamento);
            entityManager.persist(formaDePagamento);
        }else if(formaDePagamento.getId()!=null)
        {
            System.out.println("TaskServiceBean::save[U].task=>"+formaDePagamento);
            entityManager.merge(formaDePagamento);
        }else
        {
            System.out.println("FormasDePagamentoServiceBean::save[U].task=>"+formaDePagamento);
            entityManager.merge(formaDePagamento);
        }
    }
    @Override
    public List<FormasDePagamento> findAll()
    {
        return entityManager.createNamedQuery("formasdepagamento.findAll",FormasDePagamento.class).getResultList();
    }
    
    @Override
    public void MoverLixeira(FormasDePagamento formaDePagamento)
    {
        formaDePagamento.setLixo(true);
        entityManager.merge(formaDePagamento);
    }

    @Override
    public FormasDePagamento loadFdePagamentos(Long id) {
        
        return entityManager
                .createNamedQuery(
                        "formasdepagamento.loadFdePaga",
                        FormasDePagamento.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public FormasDePagamento findFPById(Long id) {
        return entityManager
                .createNamedQuery(
                        "formasdepagamento.findFPById",
                        FormasDePagamento.class)
                .setParameter("id", id)
                .getSingleResult();
    }
    
    
}
