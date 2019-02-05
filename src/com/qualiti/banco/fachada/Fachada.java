package com.qualiti.banco.fachada;

import com.qualiti.banco.dados.ClienteDAO;
import com.qualiti.banco.dados.ClienteDAOArrayImpl;
import com.qualiti.banco.dados.ContaDAO;
import com.qualiti.banco.dados.ContaDAOArrayImpl;
import com.qualiti.banco.excecoes.BancoException;
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
	public void inserirConta(Conta conta) throws BancoException {
		negocioContas.inserir(conta);
	}

	@Override
	public void atualizarConta(Conta conta) throws BancoException {
		negocioContas.atualizar(conta);
	}

	@Override
	public void removerConta(String numero) throws BancoException {
		negocioContas.remover(numero);
	}

	@Override
	public Conta procurarConta(String numero) throws BancoException {
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
	public void inserirCliente(Cliente cliente) throws BancoException {
		negocioClientes.inserir(cliente);
	}

	@Override
	public void atualizarCliente(Cliente cliente) throws BancoException {
		negocioClientes.atualizar(cliente);
	}

	@Override
	public void removerCliente(String cpf) throws BancoException {
		negocioClientes.remover(cpf);
	}

	@Override
	public Cliente procurar(String cpf) throws BancoException {
		return negocioClientes.procurar(cpf);
	}

	@Override
	public void creditar(String numero, double valor) throws BancoException {
		negocioContas.creditar(numero, valor);
	}

	@Override
	public void debitar(String numero, double valor) throws BancoException {
		negocioContas.debitar(numero, valor);
	}

	@Override
	public void transferir(String numeroFonte, String numeroDestino, 
			double valor) throws BancoException {
		negocioContas.transferir(numeroFonte, numeroDestino, valor);
	}

}
