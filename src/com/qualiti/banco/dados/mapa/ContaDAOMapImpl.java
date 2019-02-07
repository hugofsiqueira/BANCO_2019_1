package com.qualiti.banco.dados.mapa;

import java.util.HashMap;
import java.util.Map;

import com.qualiti.banco.dados.ContaDAO;
import com.qualiti.banco.modelo.Conta;
import com.qualiti.banco.modelo.Poupanca;
import com.qualiti.banco.modelo.TipoConta;

public class ContaDAOMapImpl implements ContaDAO {
	
	private Map<String, Conta> repositorio;
	
	public ContaDAOMapImpl() {
		repositorio = new HashMap<>();
	}

	@Override
	public void inserir(Conta conta) {
		repositorio.put(conta.getNumero(), conta);
	}

	@Override
	public void atualizar(Conta conta) {
		repositorio.put(conta.getNumero(), conta);
	}

	@Override
	public void remover(String numero) {
		repositorio.remove(numero);
	}

	@Override
	public Conta procurar(String numero) {
		return repositorio.get(numero);
	}

	@Override
	public String gerarRelatorioContas() {
		String retorno = "";
		for(Conta conta : repositorio.values()) {
			retorno = retorno + conta.getNumero() + " ----- "+
															conta.getSaldo()+"\n";
		}
		return retorno;
	}

	@Override
	public double recuperarSaldoTotalContas(TipoConta tipo) {
		double somatorio = 0;
		for(Conta conta : repositorio.values()) {
			if(tipo == null) {
				somatorio = somatorio + conta.getSaldo();
			}else if (tipo.equals(TipoConta.POUPANCA)) {
				if(conta.getClass() == Poupanca.class) {
					somatorio = somatorio + conta.getSaldo();
				}
			}else if(tipo.equals(TipoConta.CORRENTE)) {
				if(conta.getClass() ==  Conta.class) {
					somatorio = somatorio + conta.getSaldo();
				}
			}
		}
		
		return somatorio;
	}

}
