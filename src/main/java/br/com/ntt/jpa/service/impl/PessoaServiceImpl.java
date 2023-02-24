package br.com.ntt.jpa.service.impl;

import br.com.ntt.jpa.model.Pessoas;
import br.com.ntt.jpa.repository.PessoaRepository;
import br.com.ntt.jpa.service.PessoaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@AllArgsConstructor
public class PessoaServiceImpl implements PessoaService {

    private PessoaRepository pessoaRepository;


    @Override
    public List<Pessoas> findAll() {
        return pessoaRepository.findAll();
    }

    @Override
    public void salvarPessoa(Pessoas pessoas) {
        pessoaRepository.save(pessoas);

    }

    @Override
    public Object buscarPessoaPorID(Long id) {
        return pessoaRepository.findById(id);
    }


}


