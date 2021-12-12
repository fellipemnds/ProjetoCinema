/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FormasDePagamento;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author matec
 */
@Named(value = "formasDePagamentoBean")
//@Dependent
@ViewScoped
public class FormasDePagamentoBean implements Serializable{
    
     @Inject
    private FormasDePagamentoBeanServiceLocal FormasDePagamentoservice;
    
    private FormasDePagamento selectedFormasDePagamento;
    private Long selectedFormasDePagamentoId;
    private List<FormasDePagamento> allFormasDePagamento;
    private List<FormasDePagamento> filteredFormasDePagamento;

    public FormasDePagamentoBean(){
        
    }
    @PostConstruct
    public void init()
    {
        if(selectedFormasDePagamento==null)
            selectedFormasDePagamento = new FormasDePagamento();
    }
    
    
    
    public FormasDePagamentoBeanServiceLocal getFormasDePagamentoservice() {
        return FormasDePagamentoservice;
    }

    public void setFormasDePagamentoservice(FormasDePagamentoBeanServiceLocal FormasDePagamentoservice) {
        this.FormasDePagamentoservice = FormasDePagamentoservice;
    }

    public FormasDePagamento getSelectedFormasDePagamento() {
        return selectedFormasDePagamento;
    }

    public void setSelectedFormasDePagamento(FormasDePagamento selectedFormasDePagamento) {
        this.selectedFormasDePagamento = selectedFormasDePagamento;
    }

    public Long getSelectedFormasDePagamentoId() {
        
        if (selectedFormasDePagamentoId== null || selectedFormasDePagamento == null) {
             selectedFormasDePagamento = new FormasDePagamento();
         }
        return selectedFormasDePagamentoId;
    }

    public void setSelectedFormasDePagamentoId(Long selectedFormasDePagamentoId) {
        this.selectedFormasDePagamentoId = selectedFormasDePagamentoId;
    }

    public List<FormasDePagamento> getAllFormasDePagamento() {
        if(allFormasDePagamento==null)
            reloadFormasDePagamentos();
        
        return allFormasDePagamento;
    }

    public void setAllFormasDePagamento(List<FormasDePagamento> allFormasDePagamento) {
        this.allFormasDePagamento = allFormasDePagamento;
    }

    public List<FormasDePagamento> getFilteredFormasDePagamento() {
        return filteredFormasDePagamento;
    }

    public void setFilteredFormasDePagamento(List<FormasDePagamento> filteredFormasDePagamento) {
        this.filteredFormasDePagamento = filteredFormasDePagamento;
    }
    
    public String salvar(FormasDePagamento formaDePagamento)
    {
        FormasDePagamentoservice.Salvar(formaDePagamento);
        reloadFormasDePagamentos();
        reset();
        return null;
    }
    
    public String salvarAtual()
    {
        salvar(selectedFormasDePagamento);
        return "CRUD_FormasDePagamento?faces-redirect=true";
    }
    
    public List<FormasDePagamento> findAll(){
        return FormasDePagamentoservice.findAll();
    }
    
    public void reset(){
        selectedFormasDePagamento=new FormasDePagamento();
    }
    public void reloadFormasDePagamentos(){
        allFormasDePagamento=findAll();
    }
    public String MoverLixeira(FormasDePagamento formaDePagamento)
    {
        FormasDePagamentoservice.MoverLixeira(formaDePagamento);
        reloadFormasDePagamentos();
        return null;
    }
    public String MoverAtualLixeira(){
        MoverLixeira(selectedFormasDePagamento);
        return "CRUD_FormasDePagamento?faces-redirect=true";
    }
    public FormasDePagamento loadFdP(FormasDePagamento formadepagamento){
        if(formadepagamento!=null){
            FormasDePagamento FdPagmt = FormasDePagamentoservice.loadFdePagamentos(formadepagamento.getId());
            selectedFormasDePagamento = FdPagmt;
            System.out.println("FDP: "+selectedFormasDePagamento);
            return selectedFormasDePagamento;
        }else{
            return null;
        }
        
        
    }
    
    
}
