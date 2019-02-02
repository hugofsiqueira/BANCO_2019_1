package com.qualiti.banco.fachada;

import com.qualiti.banco.dados.ClienteDAO;
import com.qualiti.banco.dados.ClienteDAOArrayImpl;
import com.qualiti.banco.dados.ContaDAO;
import com.qualiti.banco.dados.ContaDAOArrayImpl;
import com.qualiti.banco.modelo.Cliente;
import com.qualiti.banco.modelo.Conta;
import com.qualiti.banco.modelo.TipoConta;
import com.qualiti.banco.negocio.ClienteBO;
import com.qualiti.banco.negocio.ClienteBOImpl;
import com.qualiti.banco.negocio.ContaBO;
import com.qualiti.banco.negocio.ContaBOImpl;

public class Fachada implements IFachada {
	
	private ContaBO negocioContas;
	private ClienteBO negocioClientes;
	
	public Fachada() {
		ContaDAO contaDAO = new ContaDAOArrayImpl();
		ClienteDAO clienteDAO = new ClienteDAOArrayImpl();
		
		negocioContas = new ContaBOImpl(contaDAO);
		negocioClientes = new ClienteBOImpl(clienteDAO);
	}

	@Override
	public void inserirConta(Conta conta) {
		negocioContas.inserir(conta);
	}

	@Override
	public void atualizarConta(Conta conta) {
		negocioContas.atualizar(conta);
	}

	@Override
	public void removerConta(String numero) {
		negocioContas.remover(numero);
	}

	@Override
	public Conta procurarConta(String numero) {
		return negocioContas.procurar(numero);
	}

	@Override
	public String gerarRelatorioContas() {
		return negocioContas.gerarRelatorioContas();
	}

	@Override
	public double recuperarSaldoTotalContas(TipoConta tipo) {
		return negocioContas.recuperarSaldoTotalContas(tipo);
	}

	@Override
	public void inserirCliente(Cliente cliente) {
		negocioClientes.inserir(cliente);
	}

	@Override
	public void atualizarCliente(Cliente cliente) {
		negocioClientes.atualizar(cliente);
	}

	@Override
	public void removerCliente(String cpf) {
		negocioClientes.remover(cpf);
	}

	@Override
	public Cliente procurar(String cpf) {
		return negocioClientes.procurar(cpf);
	}

}
