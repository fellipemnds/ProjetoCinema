/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sessao;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

@FacesConverter(value = "salaConverter", managed = true)
@ApplicationScoped
public class SessaoConverter implements Converter<Sessao>{
    @Inject
    private SessaoBeanServiceLocal sessaoService;
    @Override
    public Sessao getAsObject(FacesContext fc, UIComponent uic, String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Sessao sessao) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if (sessao == null) {
            return null;
        }
        return sessao.getId().toString();
    }
}
