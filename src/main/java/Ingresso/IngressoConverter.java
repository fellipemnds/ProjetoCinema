/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ingresso;


import javax.enterprise.context.ApplicationScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

@FacesConverter(value = "ingressoConverter", managed = true)
@ApplicationScoped
public class IngressoConverter implements Converter<Ingresso> {
    @Inject
    private IngressoBeanServiceLocal ingressoService;
    @Override
    public Ingresso getAsObject(FacesContext fc, UIComponent uic, String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Ingresso ingresso) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if (ingresso == null) {
            return null;
        }
        return ingresso.getId().toString();
    }
}
