package com.qualiti.banco.fachada;

import com.qualiti.banco.excecoes.BancoException;
import com.qualiti.banco.modelo.Cliente;
import com.qualiti.banco.modelo.Conta;
import com.qualiti.banco.modelo.TipoConta;

public interface IFachada {
	
	void inserirConta(Conta conta) throws BancoException;
	void atualizarConta(Conta conta) throws BancoException;
	void removerConta(String numero) throws BancoException;
	Conta procurarConta(String numero) throws BancoException;
	String gerarRelatorioContas();
	double recuperarSaldoTotalContas(TipoConta tipo);
	void creditar(String numero, double valor) throws BancoException;
	void debitar(String numero, double valor) throws BancoException;
	void transferir(String numeroFonte, String numeroDestino, double valor) throws BancoException;
	
	void inserirCliente(Cliente cliente) throws BancoException;
	void atualizarCliente(Cliente cliente) throws BancoException;
	void removerCliente(String cpf) throws BancoException;
	Cliente procurar(String cpf) throws BancoException;
	
	

}
