package com.pedrohnf688.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.pedrohnf688.modelo.Pessoa;

@Repository("pessoaRepositorio")
public interface PessoaRepositorio extends CrudRepository<Pessoa, Long>{

	
}
