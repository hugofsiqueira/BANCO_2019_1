package com.qualiti.banco.fachada;

import com.qualiti.banco.modelo.Cliente;
import com.qualiti.banco.modelo.Conta;
import com.qualiti.banco.modelo.TipoConta;

public interface IFachada {
	
	void inserirConta(Conta conta);
	void atualizarConta(Conta conta);
	void removerConta(String numero);
	Conta procurarConta(String numero);
	String gerarRelatorioContas();
	double recuperarSaldoTotalContas(TipoConta tipo);
	
	void inserirCliente(Cliente cliente);
	void atualizarCliente(Cliente cliente);
	void removerCliente(String cpf);
	Cliente procurar(String cpf);
	
	

}
