package com.qualiti.banco.dados.list;

import com.qualiti.banco.dados.ContaDAO;
import com.qualiti.banco.modelo.Conta;
import com.qualiti.banco.modelo.Poupanca;
import com.qualiti.banco.modelo.TipoConta;

public class ContaDAOListImpl  
		extends GenericDAOListImpl<Conta, String>implements ContaDAO {
	
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
