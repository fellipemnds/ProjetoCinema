/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sessao;

import Filme.Filme;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

@Named(value = "sessaoBean")
//@Dependent
@SessionScoped
public class SessaoBean implements Serializable{

   @Inject
    private SessaoBeanServiceLocal sessaoservice;
   private Sessao selectedSessao;
    private Long selectedSessaoId;
    private List<Sessao> allSessao;
    private List<Sessao> filteredSessao;
   private List<Sessao> sessaobyfime;

    public List<Sessao> getSessaobyfime() {
        return sessaobyfime;
    }

    public void setSessaobyfime(List<Sessao> sessaobyfime) {
        this.sessaobyfime = sessaobyfime;
    }
   
    public SessaoBean() {
    }
    @PostConstruct
    public void init(){
        if(selectedSessao==null){
            selectedSessao = new Sessao();
        }
    }

    public Sessao getSelectedSessao() {
        return selectedSessao;
    }

    public void setSelectedSessao(Sessao selectedSessao) {
        this.selectedSessao = selectedSessao;
    }

    public Long getSelectedSessaoId() {
        if (selectedSessaoId== null || selectedSessao == null) {
            selectedSessao = new Sessao();
        }
        
        return selectedSessaoId;
    }

    public void setSelectedSessaoId(Long selectedSessaoId) {
        this.selectedSessaoId = selectedSessaoId;
    }

    public List<Sessao> getAllSessao() {
        if(allSessao==null){
            reloadSessao();
        }        
        return allSessao;
    }

    public void setAllSessao(List<Sessao> allSessao) {
        this.allSessao = allSessao;
    }

    public List<Sessao> getFilteredSessao() {
        return filteredSessao;
    }

    public void setFilteredSessao(List<Sessao> filteredSessao) {
        this.filteredSessao = filteredSessao;
    }
    public String salvar(Sessao sessao){
        sessaoservice.Salvar(sessao);
        reloadSessao();
        reset();
        return null;
    }
    public String salvarAtual(){
        salvar(selectedSessao);
        return "CRUD_Sessao?faces-redirect=true";
    }
    public List<Sessao> findAll(){
        return sessaoservice.findAll();
    }
    public void reset(){
        selectedSessao = new Sessao();
    }
    private void reloadSessao(){
        allSessao=findAll();
    }
    public String MoverLixeira(Sessao sessao){
        sessaoservice.MoverLixeira(sessao);
        reloadSessao();
        return null;
    }
    public String MoverAtualLixeira(){
        MoverLixeira(selectedSessao);
        return "CRUD_Sessao?faces-redirect=true";
    }
    public List<Sessao> findSessionByFilme(Filme filme){
        if(filme!=null){
            List<Sessao> sessaofull = new ArrayList<>();
            sessaofull = sessaoservice.findSessaoByFilme(filme.getId());
            sessaobyfime = sessaofull;
            //System.out.println(sessaofull);
            return sessaobyfime;
        }else {
            System.out.println("Nulo");
            return null;
        }
        
        
    }
    public Filme findFilmeBySessao(Sessao sessao){
        if(sessao!=null){
            Filme filme = sessaoservice.findFilmeBySessao(sessao.getFilme().getId());
            return filme;
            
        }else {
            System.out.println("Nulo");
            return null;
        }        
 
        
    }
    public Sessao loadSessao(Sessao sessao){
        if(sessao!=null){
            Sessao sessaofull = sessaoservice.findSessionById(sessao.getId());
            selectedSessao = sessaofull;
            return selectedSessao;
        }else{
            return null;
        }
        
        
        
    }
    
    
    
}
