package com.qualiti.banco.dados.list;

import java.util.ArrayList;
import java.util.List;

import com.qualiti.banco.dados.ContaDAO;
import com.qualiti.banco.modelo.Conta;
import com.qualiti.banco.modelo.Poupanca;
import com.qualiti.banco.modelo.TipoConta;

public class ContaDAOListImpl  implements ContaDAO {
	
	private List<Conta> repositorio;
	
	public ContaDAOListImpl() {
		repositorio = new ArrayList<>();
	}

	@Override
	public void inserir(Conta conta) {
		repositorio.add(conta);
	}

	@Override
	public void atualizar(Conta conta) {
		int indice = repositorio.indexOf(conta);
		repositorio.set(indice, conta);
	}

	@Override
	public void remover(String numero) {
		Conta contaRetorno = procurar(numero);
		repositorio.remove(contaRetorno);
	}

	@Override
	public Conta procurar(String numero) {
		for (Conta conta : repositorio) {
			if(conta != null && conta.getNumero().equals(numero)) {
				return conta;
			}
		}
		return null;
	}

	@Override
	public String gerarRelatorioContas() {
		String retorno = "";
		for(Conta conta : repositorio) {
			retorno = retorno + conta.getNumero() + " ----- "+
															conta.getSaldo()+"\n";
		}
		return retorno;
	}

	@Override
	public double recuperarSaldoTotalContas(TipoConta tipo) {
		double somatorio = 0;
		for(Conta conta : repositorio) {
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
