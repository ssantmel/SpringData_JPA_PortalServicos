package br.com.ntt.jpa.dtos;

import br.com.ntt.jpa.model.Endereco;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class PessoaDto {

    private Long id;
    private String nome;
    private String sobrenome;
    private String cpf;
    private String email;
    private EnderecoDto endereco;

    public void setEndereco(EnderecoDto enderecoDto) {
    }
}
