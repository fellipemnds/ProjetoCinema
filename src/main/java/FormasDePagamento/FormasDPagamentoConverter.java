/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormasDePagamento;

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
@FacesConverter(value="formasdepagamentoConverter",managed=true)
@ApplicationScoped
public class FormasDPagamentoConverter implements Converter<FormasDePagamento>{
    
 @Inject
private FormasDePagamentoBeanServiceLocal FormasDePagamentoService;
@Override
public FormasDePagamento getAsObject(FacesContext fc, UIComponent uic, String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, FormasDePagamento formaDePagamento) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if (formaDePagamento == null) {
            return null;
        }
        return formaDePagamento.getId().toString();
    }
    
    
}
