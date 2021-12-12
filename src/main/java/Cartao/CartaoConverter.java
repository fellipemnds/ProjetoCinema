/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cartao;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

/**
 *
 * @author Gealisson
 */

@FacesConverter(value = "cartaoConverter", managed = true)
@ApplicationScoped
public class CartaoConverter implements Converter<Cartao>{
    @Inject
    private CartaoBeanServiceLocal cartaoService;
    @Override
    public Cartao getAsObject(FacesContext fc, UIComponent uic, String id) {
      if (id == null) {
            return null;
        }
        return cartaoService.findCartaoByID(Long.parseLong(id));         
                      
    }
    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Cartao cartao) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if (cartao == null) {
            return null;
        }
        return cartao.getId().toString();
    }
    
}  

