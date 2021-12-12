/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author matec
 */
@Local
public interface UsuarioBeanServiceLocal {
    public void Salvar(Usuario usuario);

    public List<Usuario> findAll();

    public void MoverLixeira(Usuario usuario);

    Usuario loadUsuarioWithIngressos(Long id);
    
}
