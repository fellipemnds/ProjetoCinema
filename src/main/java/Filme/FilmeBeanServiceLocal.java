/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Filme;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Gealisson
 */
@Local
public interface FilmeBeanServiceLocal {

    public void Salvar(Filme filme);

    public List<Filme> findAll();

    public void MoverLixeira(Filme filme);

    Filme loadFilmeByIdWithSessoes(Long id);

    Filme loadFilmeWithSessao(Long id);

    Filme findFilme(String titulo);
    
}
