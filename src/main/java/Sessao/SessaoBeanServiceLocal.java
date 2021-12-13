/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sessao;

import Filme.Filme;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author PICHAU
 */
@Local
public interface SessaoBeanServiceLocal {

    void Salvar(Sessao sessao);

    List<Sessao> findAll();

    void MoverLixeira(Sessao sessao);

    Sessao findSessionById(Long sessaoId);

    List<Sessao> findSessaoByFilme(Long filmeId);

    Filme findFilmeBySessao(Long id);

    Sessao findSessaoByIngressos(Long id);
    
}
