package br.com.ntt.jpa.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name= "tb_pessoas")
public class Pessoas {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sobrenome;
    private String cpf;
    private String email;
    @OneToOne
    private Endereco endereco;


    public static Pessoas criaNovaPessoa(String nome, String sobrenome, String cpf, String email, Endereco endereco){
       Pessoas pessoa = new Pessoas();
       pessoa.setNome(nome);
       pessoa.setSobrenome(sobrenome);
       pessoa.setCpf(cpf);
       pessoa.setEmail(email);
       pessoa.setEndereco(endereco);
        return pessoa;
    }

}
