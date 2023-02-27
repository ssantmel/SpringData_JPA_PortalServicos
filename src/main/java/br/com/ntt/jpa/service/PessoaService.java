package br.com.ntt.jpa.service;

import br.com.ntt.jpa.dtos.PessoaDto;

import java.util.List;

public interface PessoaService {

    List<PessoaDto> findAll();

     void salvarPessoa(PessoaDto pessoas);


    PessoaDto buscarPessoaPorID(Long id);
}
