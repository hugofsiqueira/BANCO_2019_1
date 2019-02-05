package com.qualiti.banco.negocio;

import com.qualiti.banco.dados.ClienteDAO;
import com.qualiti.banco.excecoes.BancoException;
import com.qualiti.banco.modelo.Cliente;

public class ClienteBOImpl implements ClienteBO {
	
	private ClienteDAO repositorio;
	
	public ClienteBOImpl(ClienteDAO repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public void inserir(Cliente cliente) throws BancoException {
		if(cliente == null) {
			throw new BancoException("Objeto Cliente null");
		}
		
		if(cliente.getCpf() == null || cliente.getCpf().isEmpty()) {
			throw new BancoException("CPF deve ser informado");
		}
		
		if(cliente.getCpf().length() != 14) {
			throw new BancoException("CPF inválido");
		}
		
		Cliente clienteBusca = repositorio.procurar(cliente.getCpf());
		if(clienteBusca == null) {
			repositorio.inserir(cliente);
		}else {
			throw new BancoException("CPF já cadastrado");
		}
	}

	@Override
	public void atualizar(Cliente cliente) throws BancoException {
		if(cliente == null) {
			throw new BancoException("Objeto Cliente null");
		}
		
		if(cliente.getCpf() == null || cliente.getCpf().isEmpty()) {
			throw new BancoException("CPF deve ser informado");
		}
		
		if(cliente.getCpf().length() != 14) {
			throw new BancoException("CPF inválido");
		}
		
		Cliente clienteBusca = repositorio.procurar(cliente.getCpf());
		if(clienteBusca != null) {
			repositorio.atualizar(cliente);
		}else {
			throw new BancoException("CPF não cadastrado");
		}
	}

	@Override
	public void remover(String cpf) throws BancoException {
		if(cpf == null || cpf.isEmpty()) {
			throw new BancoException("CPF deve ser informado");
		}
		
		if(cpf.length() != 14) {
			throw new BancoException("CPF inválido");
		}
		
		repositorio.remover(cpf);
		
	}

	@Override
	public Cliente procurar(String cpf) throws BancoException {
		if(cpf == null || cpf.isEmpty()) {
			throw new BancoException("CPF deve ser informado");
		}
		
		if(cpf.length() != 14) {
			throw new BancoException("CPF inválido");
		}
		
		return repositorio.procurar(cpf);
	}

}
