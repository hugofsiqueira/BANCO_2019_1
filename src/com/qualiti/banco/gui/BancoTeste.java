package com.qualiti.banco.gui;

import com.qualiti.banco.fachada.Fachada;
import com.qualiti.banco.modelo.Conta;
import com.qualiti.banco.modelo.Poupanca;
import com.qualiti.banco.modelo.TipoConta;

public class BancoTeste {

	public static void main(String[] args) {
		
		Conta c = new Conta();
		c.setNumero("123");
		c.setSaldo(1290);
		
		Poupanca p = new Poupanca();
		p.setNumero("129");
		p.setSaldo(8000);
		
		Fachada fachada = new Fachada();
		
		fachada.inserirConta(c);
		fachada.inserirConta(p);
		
		Conta retorno = fachada.procurarConta("123");
		
		if(retorno != null) {
			System.out.println("Conta encontrada: Saldo - "+retorno.getSaldo());
		}else {
			System.out.println("Conta nao existe");
		}
		
		String relatorio = fachada.gerarRelatorioContas();
		System.out.println(relatorio);
		
		double totalSaldos = fachada.recuperarSaldoTotalContas(null);
		System.out.println("O saldo total é: "+ totalSaldos);
		
		double totalSaldoPoupancas = 
				fachada.recuperarSaldoTotalContas(TipoConta.POUPANCA);
		
		System.out.println("O saldo total Poupancas é: "+ totalSaldoPoupancas);
		
		double totalSaldoContasCorrentes = 
				fachada.recuperarSaldoTotalContas(TipoConta.CORRENTE);
	
		System.out.println("O saldo total C/C é: "+ 
																totalSaldoContasCorrentes);

	}

}
