/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Filme;

import Sessao.Sessao;
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
@SessionScoped
public class FilmeBean implements Serializable{

    @Inject
    private FilmeBeanServiceLocal filmeservice;
    
    private Filme selectedFilme;
    private Long selectedFilmeId;
    private List<Filme> allFilme;
    private List<Filme> filteredFilme;
    private String pesquisa;
    
    public FilmeBean() {
        
    }
    @PostConstruct
    public void init(){
        if(selectedFilme==null){
            selectedFilme = new Filme();
        }
    }

    public String getPesquisa() {
        return pesquisa;
    }

    public void setPesquisa(String pesquisa) {
        this.pesquisa = pesquisa;
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
    public List<Sessao> LoadFilmeSessao(Filme filme){
        if (filme != null) {
            Filme fullFilme = filmeservice.loadFilmeWithSessao(filme.getId());
            List<Sessao> sessao = fullFilme.getSessoes();           
            return sessao;
        } else {
            return null;
        }
    }
    public Filme findFilme(){
        String titulo = getPesquisa();
        System.out.println("titulo: "+titulo);
        if(titulo==null){
            System.out.println("titulo nulo");
            return null;
        }else{
            Filme findfilme = filmeservice.findFilme(titulo);
            System.out.println("filme: "+findfilme);
            selectedFilme =findfilme;
            return selectedFilme;
        }
    }
    public Filme pesquisaFilme(String pesquisa){
        for(Filme f:allFilme){
            if(f.getTitulo().equals(pesquisa)){
                return f;
            } else {
            }
        }
        return null;
    }
    
}
