/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sala;


import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

@Named(value = "salaBean")
//@Dependent
@SessionScoped
public class SalaBean implements Serializable{
    
    @Inject
    private SalaBeanServiceLocal salaservice;
    
    private Sala selectedSala;
    private Long selectedSalaId;
    private List<Sala> allSala;
    private List<Sala> filteredSala;
    public SalaBean() {
    }
    @PostConstruct
    public void init(){
        if(selectedSala==null){
            selectedSala = new Sala();
        }
    }

    public Sala getSelectedSala() {
        return selectedSala;
    }

    public void setSelectedSala(Sala selectedSala) {
        this.selectedSala = selectedSala;
    }

    public Long getSelectedSalaId() {
        if (selectedSalaId== null || selectedSala == null) {
            selectedSala = new Sala();
        }
        return selectedSalaId;
    }

    public void setSelectedSalaId(Long selectedSalaId) {
        this.selectedSalaId = selectedSalaId;
    }

    public List<Sala> getAllSala() {
        return allSala;
    }

    public void setAllSala(List<Sala> allSala) {
        if(allSala==null){
            reloadSalas();
        }
        this.allSala = allSala;
    }

    public List<Sala> getFilteredSala() {
        return filteredSala;
    }

    public void setFilteredSala(List<Sala> filteredSala) {
        this.filteredSala = filteredSala;
    }
    
    public String salvar(Sala sala){
        salaservice.Salvar(sala);
        reloadSalas();
        reset();
        return null;
    }
    public String salvarAtual(){
        salvar(selectedSala);
        return "CRUD_Sala?faces-redirect=true";
    }
    public List<Sala> findAll(){
        return salaservice.findAll();
    }
    public void reset(){
        selectedSala = new Sala();
    }
    private void reloadSalas(){
        allSala= findAll();
    }
    public String MoverLixeira(Sala sala){
        salaservice.MoverLixeira(sala);
        reloadSalas();
        return null;
    }
    public String MoverAtualLixeira(){
        MoverLixeira(selectedSala);
        return "CRUD_Sala?faces-redirect=true";
    }
    
}
