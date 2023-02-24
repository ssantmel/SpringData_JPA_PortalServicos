package br.com.ntt.jpa.repository;

import br.com.ntt.jpa.model.Pessoas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoas,Long> {



}
