package br.com.ntt.jpa.service.populator.impl;

import br.com.ntt.jpa.dtos.EnderecoDto;
import br.com.ntt.jpa.dtos.PessoaDto;
import br.com.ntt.jpa.model.Endereco;
import br.com.ntt.jpa.model.Pessoa;
import br.com.ntt.jpa.repository.EnderecoRepository;
import br.com.ntt.jpa.service.populator.Populator;
import org.springframework.stereotype.Component;

@Component
public class PessoaPopulatorImpl implements Populator<PessoaDto, Pessoa> {

    private EnderecoRepository enderecoRepository;


    @Override
    public void populate(PessoaDto source, Pessoa target) {
        //TODO impelemtar sets e validações

       target.setNome(source.getNome());
       target.setSobrenome(source.getSobrenome());
       target.setCpf(source.getCpf());
       target.setEmail(source.getEmail());

       populateEndereco(source.getEndereco(),target);


    }

    private void populateEndereco(EnderecoDto source, Pessoa target) {

        Endereco endereco = new Endereco();
        target.setEndereco(endereco);

        target.getEndereco().setLogradouro(source.getLogradouro());
        target.getEndereco().setNumero(source.getNumero());
        target.getEndereco().setCep(source.getCep());
        target.getEndereco().setCidade(source.getCidade());
        target.getEndereco().setEstado(source.getEstado());


        enderecoRepository.save(target.getEndereco());

    }




    }






