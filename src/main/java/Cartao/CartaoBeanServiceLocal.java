/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cartao;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author PICHAU
 */
@Local
public interface CartaoBeanServiceLocal {

    void Salvar(Cartao cartao);

    List<Cartao> findAll();

    void MoverLixeira(Cartao cartao);
    
}
