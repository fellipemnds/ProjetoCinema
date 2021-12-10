/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Filme;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;


/**
 *
 * @author Gealisson
 */
@Named(value = "filmeBean")
//@Dependent
//@ViewScoped
@SessionScoped
public class FilmeBean implements Serializable{

    @Inject
    private FilmeBeanServiceLocal filmeservice;
    
    private Filme selectedFilme;
    private Long selectedFilmeId;
    private List<Filme> allFilme;
    private List<Filme> filteredFilme;
    
    public FilmeBean() {
    }
    @PostConstruct
    public void init(){
        if(selectedFilme==null){
            selectedFilme = new Filme();
        }
    }

    public Filme getSelectedFilme() {
        return selectedFilme;
    }

    public void setSelectedFilme(Filme selectedFilme) {
        this.selectedFilme = selectedFilme;
    }

    public Long getSelectedFilmeId() {
        if (selectedFilmeId== null || selectedFilme == null) {
            selectedFilme = new Filme();
        }

        return selectedFilmeId;
    }

    public void setSelectedFilmeId(Long selectedFilmeId) {
        this.selectedFilmeId = selectedFilmeId;
    }

    public List<Filme> getAllFilme() {
        if(allFilme==null){
            reloadFilmes();
        }
        return allFilme;
    }

    public void setAllFilme(List<Filme> allFilme) {
        this.allFilme = allFilme;
    }

    public List<Filme> getFilteredFilme() {
        return filteredFilme;
    }

    public void setFilteredFilme(List<Filme> filteredFilme) {
        this.filteredFilme = filteredFilme;
    }
    public String salvar(Filme filme){
        filmeservice.Salvar(filme);
        reloadFilmes();
        reset();
        return null;
    }
    public String salvarAtual(){
        salvar(selectedFilme);
        return "CRUD_Filme?faces-redirect=true";
    }
    public List<Filme> findAll(){
        return filmeservice.findAll();
    }
    public void reset(){
        selectedFilme = new Filme();
    }
    private void reloadFilmes(){
        allFilme=findAll();
    }
    public String MoverLixeira(Filme filme){
        filmeservice.MoverLixeira(filme);
        reloadFilmes();
        return null;
    }
    public String MoverAtualLixeira(){
        MoverLixeira(selectedFilme);
        return "CRUD_Filme?faces-redirect=true";
    }
    public Filme LoadFilmeWithSessoes(Filme filme){
        if (filme != null) {
            Filme fullFilme = filmeservice.loadFilmeByIdWithSessoes(filme.getId());
            selectedFilme = fullFilme;
            return selectedFilme;
        } else {
            return null;
        }
    }
    public Filme LoadFilmeSessao(Filme filme){
        if (filme != null) {
            Filme fullFilme = filmeservice.loadFilmeWithSessao(filme.getId());
            selectedFilme = fullFilme;
            return selectedFilme;
        } else {
            return null;
        }
        
        
        
    }
}
