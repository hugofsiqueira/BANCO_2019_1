package com.qualiti.banco.dados.list;

import java.util.ArrayList;
import java.util.List;

import com.qualiti.banco.dados.ClienteDAO;
import com.qualiti.banco.modelo.Cliente;

public class ClienteDAOListImpl implements ClienteDAO {
	
	private List<Cliente> repositorio;
	
    public ClienteDAOListImpl() {
		repositorio = new ArrayList<>();
	}

	@Override
	public void inserir(Cliente cliente) {
		repositorio.add(cliente);
	}

	@Override
	public void atualizar(Cliente cliente) {
		int indice = repositorio.indexOf(cliente);
		repositorio.set(indice, cliente);
	}

	@Override
	public void remover(String cpf) {
		Cliente cliente = procurar(cpf);
		repositorio.remove(cliente);
	}

	@Override
	public Cliente procurar(String cpf) {
		for (Cliente cliente : repositorio) {
			if(cliente != null && cliente.getCpf().equals(cpf)) {
				return cliente;
			}
		}
		return null;
	}

}
