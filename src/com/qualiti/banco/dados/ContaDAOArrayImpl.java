package com.qualiti.banco.dados;

import com.qualiti.banco.modelo.Conta;
import com.qualiti.banco.modelo.Poupanca;
import com.qualiti.banco.modelo.TipoConta;

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
		for(int i = 0; i < indice; i++) {
			if(bancoContas[i].equals(conta)) {
				bancoContas[i] = conta;
			}
		}
	}

	@Override
	public void remover(String numero) {
		for(int i = 0; i < indice; i++) {
			if(bancoContas[i].getNumero().equals(numero)) {
				bancoContas[i] = bancoContas[indice - 1];
				bancoContas[indice - 1] = null;
				indice--;
			}
		}
	}

	@Override
	public Conta procurar(String numero) {
		for(int i = 0; i < indice; i++) {
			if(bancoContas[i].getNumero().equals(numero)) {
				return bancoContas[i];
			}
		}
		return null;
	}

	@Override
	public String gerarRelatorioContas() {
		String retorno = "";
		for(int i = 0; i < indice; i++) {
			retorno = retorno + bancoContas[i].getNumero() + " ----- "+
															bancoContas[i].getSaldo()+"\n";
		}
		return retorno;
	}
	
	public double recuperarSaldoTotalContas(TipoConta tipo) {
		double somatorio = 0;
		for(int i = 0; i < indice; i++) {
			if(tipo == null) {
				somatorio = somatorio + bancoContas[i].getSaldo();
			}else if (tipo.equals(TipoConta.POUPANCA)) {
				if(bancoContas[i].getClass() == Poupanca.class) {
					somatorio = somatorio + bancoContas[i].getSaldo();
				}
			}else if(tipo.equals(TipoConta.CORRENTE)) {
				if(bancoContas[i].getClass() ==  Conta.class) {
					somatorio = somatorio + bancoContas[i].getSaldo();
				}
			}
		}
		
		return somatorio;
		
	}

}
