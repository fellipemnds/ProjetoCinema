/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cartao;

import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

/**
 *
 * @author Gealisson
 */
@Named(value = "cartaoBean")
@SessionScoped
public class CartaoBean implements Serializable {

    @Inject
    private CartaoBeanServiceLocal cartaoservice;
    
    private Cartao selectedCartao;
    private Long selectedCartaoId;
    private List<Cartao> allCartao;
    private List<Cartao> filteredCartao;
    
    
    public CartaoBean() {
    }
    @PostConstruct
    public void init(){
        if(selectedCartao==null){
            selectedCartao = new Cartao();
        }
    }

    public Cartao getSelectedCartao() {
        return selectedCartao;
    }

    public void setSelectedCartao(Cartao selectedCartao) {
        this.selectedCartao = selectedCartao;
    }

    public Long getSelectedCartaoId() {
        if (selectedCartaoId== null || selectedCartao == null) {
            selectedCartao = new Cartao();
        }        
        return selectedCartaoId;
    }

    public void setSelectedCartaoId(Long selectedCartaoId) {
               
        this.selectedCartaoId = selectedCartaoId;
    }

    public List<Cartao> getAllCartao() {
        if(allCartao==null){
            reloadCartoes();
        }
        return allCartao;
    }

    public void setAllCartao(List<Cartao> allCartao) {
        this.allCartao = allCartao;
    }

    public List<Cartao> getFilteredCartao() {
        return filteredCartao;
    }

    public void setFilteredCartao(List<Cartao> filteredCartao) {
        this.filteredCartao = filteredCartao;
    }
    
    
    public String salvar(Cartao cartao){
        cartaoservice.Salvar(cartao);
        reloadCartoes();
        reset();
        return null;
    }
    public String salvarAtual(){
        salvar(selectedCartao);
        return "CRUD_Cartao?faces-redirect=true";
    }
    public List<Cartao> findAll(){
        return cartaoservice.findAll();
    }
    public void reset(){
        selectedCartao = new Cartao();
    }
    private void reloadCartoes(){
        allCartao=findAll();
    }
    public String MoverLixeira(Cartao cartao){
        cartaoservice.MoverLixeira(cartao);
        reloadCartoes();
        return null;
    }
    public String MoverAtualLixeira(){
        MoverLixeira(selectedCartao);
        return "CRUD_Cartao?faces-redirect=true";
    }
    
}
