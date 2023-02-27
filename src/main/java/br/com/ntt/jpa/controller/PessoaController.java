package br.com.ntt.jpa.controller;

import br.com.ntt.jpa.dtos.PessoaDto;
import br.com.ntt.jpa.model.Pessoa;
import br.com.ntt.jpa.service.PessoaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/controle-pessoa")
public class PessoaController {

    private PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService){
        this.pessoaService= pessoaService;
    }


    @GetMapping("/Pessoas")
    public List<PessoaDto> getAll(){
        return pessoaService.findAll();
    }

    @PostMapping("/Pessoa/criapessoa")
    public ResponseEntity<PessoaDto> criaPessoas(@RequestBody PessoaDto pessoasDto){
        pessoaService.salvarPessoa(pessoasDto);
        return new ResponseEntity<>(pessoasDto, HttpStatus.CREATED);

    }


    @GetMapping("/Pessoas/buscaID")
   public PessoaDto buscarPessoaPorID(@RequestBody Long id){
        return   pessoaService.buscarPessoaPorID(id);



    }

}




