package br.com.ntt.jpa.dtos;


import br.com.ntt.jpa.model.Cidade;
import br.com.ntt.jpa.model.Estado;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EnderecoDto {

    private Long id;
    private String logradouro;
    private String numero;
    private String cep;
    private Cidade cidade;
    private Estado estado;

}
