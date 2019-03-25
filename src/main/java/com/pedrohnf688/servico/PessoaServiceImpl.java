package com.pedrohnf688.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pedrohnf688.modelo.Pessoa;
import com.pedrohnf688.repositorio.PessoaRepositorio;

@Service("pessoaService")
public class PessoaServiceImpl implements PessoaService{

	@Autowired
	private PessoaRepositorio pessoaRepositorio;
	
	@Override
	public Pessoa save(Pessoa pessoa) {
		return pessoaRepositorio.save(pessoa);
	}

}
