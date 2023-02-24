package br.com.ntt.jpa.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@Entity(name = "tb_estado")
public class Estado {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @OneToMany
    private List<Cidade> cidades = new ArrayList<>();


    public static  Estado criaNovoEstado(String nome, List<Cidade> Cidades){
        Estado estado = new Estado();
        estado.setNome(nome);
        estado.setCidades(Cidades);
        return estado;
    }


}
