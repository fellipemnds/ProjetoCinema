/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Filme;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.annotation.FacesConfig;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

/**
 *
 * @author Gealisson
 */
@FacesConverter(value = "filmeConverter", managed = true)
@ApplicationScoped
public class FilmeConverter implements Converter<Filme>{
    @Inject
    private FilmeBeanServiceLocal filmeService;
    @Override
    public Filme getAsObject(FacesContext fc, UIComponent uic, String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Filme filme) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if (filme == null) {
            return null;
        }
        return filme.getId().toString();
    }
    
}
