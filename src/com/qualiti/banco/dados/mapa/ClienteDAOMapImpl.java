package com.qualiti.banco.dados.mapa;

import java.util.Hashtable;
import java.util.Map;

import com.qualiti.banco.dados.ClienteDAO;
import com.qualiti.banco.modelo.Cliente;

public class ClienteDAOMapImpl implements ClienteDAO {
	
	private Map<String, Cliente> repositorio;
	
	public ClienteDAOMapImpl() {
		repositorio = new Hashtable<>();
	}

	@Override
	public void inserir(Cliente cliente) {
		repositorio.put(cliente.getCpf(), cliente);
	}

	@Override
	public void atualizar(Cliente cliente) {
		repositorio.put(cliente.getCpf(), cliente);
	}

	@Override
	public void remover(String cpf) {
		repositorio.remove(cpf);
	}

	@Override
	public Cliente procurar(String cpf) {
		return repositorio.get(cpf);
	}

}
