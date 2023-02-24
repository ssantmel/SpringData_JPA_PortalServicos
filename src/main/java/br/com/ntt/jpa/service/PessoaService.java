package br.com.ntt.jpa.service;

import br.com.ntt.jpa.model.Pessoas;

import java.util.List;

public interface PessoaService {

    List<Pessoas> findAll();

     void salvarPessoa(Pessoas pessoas);


    Object buscarPessoaPorID(Long id);
}
