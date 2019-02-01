package com.qualiti.banco.dados;

import com.qualiti.banco.modelo.Conta;

public class ContaDAOArrayImpl implements ContaDAO {
	
	private Conta[] bancoContas;
	private int indice;
	
	public ContaDAOArrayImpl() {
		bancoContas = new Conta[1000];
	}

	@Override
	public void inserir(Conta conta) {
		if(indice < 1000) {
			bancoContas[indice] = conta;
			indice++;
		}else {
			System.out.println("Limite de contas atingido!!!");
		}
	}

	@Override
	public void atualizar(Conta conta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remover(String numero) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Conta procurar(String numero) {
		// TODO Auto-generated method stub
		return null;
	}

}
