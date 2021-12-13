/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

/**
 *
 * @author matec
 */
@FacesConverter(value="usuarioConverter",managed=true)
@ApplicationScoped
public class UsuarioConverter implements Converter<Usuario> {
@Inject
private UsuarioBeanServiceLocal usuarioService;
@Override
    public Usuario getAsObject(FacesContext fc, UIComponent uic, String id) {
        if (id == null) {
            return null;
        }
        return usuarioService.findUsuarioById(Long.parseLong(id));  
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Usuario usuario) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if (usuario == null) {
            return null;
        }
        return usuario.getId().toString();
    }


    
}
