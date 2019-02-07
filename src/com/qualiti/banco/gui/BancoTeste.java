package com.qualiti.banco.gui;

import com.qualiti.banco.excecoes.BancoException;
import com.qualiti.banco.fachada.Fachada;
import com.qualiti.banco.fachada.IFachada;
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
		
		IFachada fachada = Fachada.getFachada();
		
		try {
			fachada.inserirConta(c);
		} catch (BancoException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			fachada.inserirConta(p);
		} catch (BancoException e) {
			System.out.println(e.getMessage());
		}
		
		
		Conta retorno;
		try {
			retorno = fachada.procurarConta("123");
			
			if(retorno != null) {
				System.out.println("Conta encontrada: Saldo - "+retorno.getSaldo());
			}else {
				System.out.println("Conta nao existe");
			}
			
		} catch (BancoException e) {
			System.out.println(e.getMessage());
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
