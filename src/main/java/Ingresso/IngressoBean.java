/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ingresso;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;


@Named(value = "ingressoBean")
//@Dependent
@SessionScoped
public class IngressoBean implements Serializable{

   @Inject
    private IngressoBeanServiceLocal ingressoservice;
   
    private Ingresso selectedIngresso;
    private Long selectedIngressoId;
    private List<Ingresso> allIngresso;
    private List<Ingresso> filteredIngresso;
   
    public IngressoBean() {
        
    }
    @PostConstruct
    public void init(){
        if(selectedIngresso==null){
            selectedIngresso = new Ingresso();
        }
    }
    public Ingresso getSelectedIngresso() {
        return selectedIngresso;
    }

    public void setSelectedIngresso(Ingresso selectedIngresso) {
        this.selectedIngresso = selectedIngresso;
    }

    public Long getSelectedIngressoId() {
        if (selectedIngressoId== null || selectedIngresso == null) {
            selectedIngresso = new Ingresso();
        }
        return selectedIngressoId;
    }

    public void setSelectedIngressoId(Long selectedIngressoId) {
        this.selectedIngressoId = selectedIngressoId;
    }

    public List<Ingresso> getAllIngresso() {
        if(allIngresso==null){
            reloadIngressos();
        }
        return allIngresso;
    }

    public void setAllIngresso(List<Ingresso> allIngresso) {
        this.allIngresso = allIngresso;
    }

    public List<Ingresso> getFilteredIngresso() {
        return filteredIngresso;
    }

    public void setFilteredIngresso(List<Ingresso> filteredIngresso) {
        this.filteredIngresso = filteredIngresso;
    }
    public String salvar(Ingresso filme){
        ingressoservice.Salvar(filme);
        reloadIngressos();
        reset();
        return null;
    }
    public String salvarAtual(){
        salvar(selectedIngresso);
        return "CRUD_Ingresso?faces-redirect=true";
    }
    public List<Ingresso> findAll(){
        return ingressoservice.findAll();
    }
    public void reset(){
        selectedIngresso = new Ingresso();
    }
    private void reloadIngressos(){
        allIngresso=findAll();
    }
    public String MoverLixeira(Ingresso filme){
        ingressoservice.MoverLixeira(filme);
        reloadIngressos();
        return null;
    }
    public String MoverAtualLixeira(){
        MoverLixeira(selectedIngresso);
        return "CRUD_Ingresso?faces-redirect=true";
    }
}
