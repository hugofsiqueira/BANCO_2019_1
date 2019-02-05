package com.qualiti.banco.negocio;

import com.qualiti.banco.excecoes.BancoException;
import com.qualiti.banco.modelo.Conta;
import com.qualiti.banco.modelo.TipoConta;

public interface ContaBO {
	
	void inserir(Conta conta) throws BancoException;
	void atualizar(Conta conta) throws BancoException;
	void remover(String numero) throws BancoException;
	Conta procurar(String numero) throws BancoException;
	String gerarRelatorioContas();
	double recuperarSaldoTotalContas(TipoConta tipo);
	void creditar(String numero, double valor) throws BancoException;
	void debitar(String numero, double valor) throws BancoException;
	void transferir(String numeroFonte, String numeroDestino, double valor) throws BancoException;

}
