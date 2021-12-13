/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ingresso;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author PICHAU
 */
@Local
public interface IngressoBeanServiceLocal {

    void Salvar(Ingresso ingresso);

    List<Ingresso> findAll();

    void MoverLixeira(Ingresso ingresso);

    Ingresso loadIngresso(Long id);

    Ingresso findIngressoById(Long id);
    
}
