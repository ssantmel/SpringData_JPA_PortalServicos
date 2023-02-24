package br.com.ntt.jpa.controller;

import br.com.ntt.jpa.dtos.PessoasDto;
import br.com.ntt.jpa.model.Pessoas;
import br.com.ntt.jpa.service.PessoaService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@Controller
public class PessoaController {

    private PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService){
        this.pessoaService= pessoaService;
    }


    @GetMapping("/Pessoas")
    public List<Pessoas> getAll(){
        return pessoaService.findAll();
    }

    @PostMapping("/Pessoa/criapessoa")
    public ResponseEntity<Pessoas> criaPessoas(@RequestBody PessoasDto pessoasDto){
        Pessoas pessoas = new Pessoas();
        BeanUtils.copyProperties(pessoasDto,pessoas);
        pessoaService.salvarPessoa(pessoas);
        return new ResponseEntity<>(pessoas, HttpStatus.CREATED);

    }


    @GetMapping("/Pessoas/buscaID")
   public ResponseEntity<Object> buscarPessoaPorID(@RequestBody Long id){
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.buscarPessoaPorID(id));


    }





}




