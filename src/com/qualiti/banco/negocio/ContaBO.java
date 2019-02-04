package com.qualiti.banco.negocio;

import com.qualiti.banco.modelo.Conta;
import com.qualiti.banco.modelo.TipoConta;

public interface ContaBO {
	
	void inserir(Conta conta);
	void atualizar(Conta conta);
	void remover(String numero);
	Conta procurar(String numero);
	String gerarRelatorioContas();
	double recuperarSaldoTotalContas(TipoConta tipo);
	void creditar(String numero, double valor);
	void debitar(String numero, double valor);
	void transferir(String numeroFonte, String numeroDestino, double valor);

}
