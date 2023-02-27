package br.com.ntt.jpa.service.populator.impl;

import br.com.ntt.jpa.dtos.EnderecoDto;
import br.com.ntt.jpa.dtos.PessoaDto;
import br.com.ntt.jpa.model.Endereco;
import br.com.ntt.jpa.model.Pessoa;
import br.com.ntt.jpa.service.populator.Populator;

public class ReversePopulatorImpl implements Populator <Pessoa, PessoaDto>{
    @Override
    public void populate(Pessoa source, PessoaDto target) {


        target.setNome(source.getNome());
        target.setSobrenome(source.getSobrenome());
        target.setCpf(source.getCpf());
        target.setEmail(source.getEmail());

        target.setEndereco(new EnderecoDto());

        target.getEndereco().setLogradouro(source.getEndereco().getLogradouro());
        target.getEndereco().setNumero(source.getEndereco().getNumero());
        target.getEndereco().setCep(source.getEndereco().getCep());
        target.getEndereco().setCidade(source.getEndereco().getCidade());
        target.getEndereco().setEstado(source.getEndereco().getEstado());


    }
}
