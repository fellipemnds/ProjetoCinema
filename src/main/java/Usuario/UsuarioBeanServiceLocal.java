/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario;

import java.util.List;
import java.util.Optional;
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

    Usuario findUsuarioById(Long id);
    
    public Usuario createUser(String name, String username,String email, String telefone, String password, String group, Boolean lixo);
    public Optional<Usuario> getUser(String username);
}
