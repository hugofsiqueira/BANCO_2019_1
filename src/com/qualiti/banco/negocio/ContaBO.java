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

}
