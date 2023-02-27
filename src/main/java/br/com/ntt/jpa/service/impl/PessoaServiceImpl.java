package br.com.ntt.jpa.service.impl;

import br.com.ntt.jpa.dtos.PessoaDto;
import br.com.ntt.jpa.exceptiion.PessoaException;
import br.com.ntt.jpa.model.Pessoa;
import br.com.ntt.jpa.repository.PessoaRepository;
import br.com.ntt.jpa.service.PessoaService;
import br.com.ntt.jpa.service.populator.Populator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PessoaServiceImpl implements PessoaService {

    private PessoaRepository pessoaRepository;
    private Populator<PessoaDto, Pessoa> pessoaPopulator;

    private Populator<Pessoa , PessoaDto> pessoaReversePopulator;


    @Override
    public List<PessoaDto> findAll() {
        //TODO fazer conversão para pessoa DTO utilizando o padrão populator

        List<PessoaDto> pessoaDtoList = new ArrayList<>();
        List <Pessoa> pessoaList = pessoaRepository.findAll();

        for (Pessoa pe : pessoaList){
            PessoaDto pessoaDto = new PessoaDto();

            pessoaReversePopulator.populate(pe , pessoaDto);

            pessoaDtoList.add(pessoaDto);

        }

        return pessoaDtoList;
    }

    @Override
    public void salvarPessoa(PessoaDto pessoaDto) {
        //TODO Método deve receber PessoaDTO e aqui fazer a conversão via populate para salvar entidade

        Pessoa pessoa = new Pessoa();
        pessoaPopulator.populate(pessoaDto, pessoa);
        pessoaRepository.save(pessoa);

    }

    @Override
    public PessoaDto buscarPessoaPorID(Long id) {
        //TODO deve devolver um pessoaDTO

        PessoaDto pessoaDto = new PessoaDto();
        Pessoa pessoa = pessoaRepository.findById(id).orElseThrow(() -> new PessoaException("Pessoa não encontrada"));
        pessoaReversePopulator.populate(pessoa, pessoaDto);
        return pessoaDto;
    }


}


