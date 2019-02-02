package com.qualiti.banco.dados;

import com.qualiti.banco.modelo.Cliente;

public class ClienteDAOArrayImpl implements ClienteDAO {
	
	private Cliente[] bancoClientes;
	private int indice;
	
	public ClienteDAOArrayImpl() {
		bancoClientes = new Cliente[1000];
	}

	@Override
	public void inserir(Cliente cliente) {
		if(indice < 1000) {
			bancoClientes[indice] = cliente;
			indice++;
		}else {
			System.out.println("Limite de clientes atingido!!!");
		}
	}

	@Override
	public void atualizar(Cliente cliente) {
		for(int i = 0; i < indice; i++) {
			if(bancoClientes[i].equals(cliente)) {
				bancoClientes[i] = cliente;
			}
		}
	}

	@Override
	public void remover(String cpf) {
		for(int i = 0; i < indice; i++) {
			if(bancoClientes[i].getCpf().equals(cpf)) {
				bancoClientes[i] = bancoClientes[indice - 1];
				bancoClientes[indice - 1] = null;
				indice--;
			}
		}
	}

	@Override
	public Cliente procurar(String cpf) {
		for(int i = 0; i < indice; i++) {
			if(bancoClientes[i].getCpf().equals(cpf)) {
				return bancoClientes[i];
			}
		}
		return null;
	}

}
