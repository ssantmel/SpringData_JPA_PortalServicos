package br.com.ntt.jpa;

import br.com.ntt.jpa.model.Cidade;
import br.com.ntt.jpa.model.Endereco;
import br.com.ntt.jpa.model.Estado;
import br.com.ntt.jpa.model.Pessoa;
import br.com.ntt.jpa.repository.CidadeRepository;
import br.com.ntt.jpa.repository.EnderecoRepository;
import br.com.ntt.jpa.repository.EstadoRepository;
import br.com.ntt.jpa.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class JpaApplication implements CommandLineRunner {

	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EstadoRepository estadoRepository;

	private EnderecoRepository enderecoRepository;

	private PessoaRepository pessoaRepository;


	@Autowired
	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}


	public void run (String... arg ) throws Exception{
		Cidade campinas = Cidade.criaNovaCidade("campinas");
		Cidade guarulhos = Cidade.criaNovaCidade("guarulhos");
		cidadeRepository.saveAll(Arrays.asList(campinas,guarulhos));


		Estado sp = Estado.criaNovoEstado("SP", Arrays.asList(campinas,guarulhos));
		estadoRepository.save(sp);



		Endereco endereco =	Endereco.criaNovoEndereco("rua geronimos","46","09785-100",sp,campinas);
		enderecoRepository.save(endereco);

		Pessoa pessoa = Pessoa.criaNovaPessoa("Maria","Melo","12345678-01","maria@gmail.com",endereco);
		pessoaRepository.save(pessoa);
	}


}
