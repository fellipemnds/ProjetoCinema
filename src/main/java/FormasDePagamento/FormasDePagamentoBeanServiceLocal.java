/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormasDePagamento;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author matec
 */
@Local
public interface FormasDePagamentoBeanServiceLocal  {
     public void Salvar(FormasDePagamento formaDePagamento);

    public List<FormasDePagamento> findAll();

    public void MoverLixeira(FormasDePagamento formaDePagamento);

    FormasDePagamento loadFdePagamentos(Long id);

    FormasDePagamento findFPById(Long id);
}
