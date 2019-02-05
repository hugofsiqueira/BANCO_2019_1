package com.qualiti.banco.negocio;

import com.qualiti.banco.dados.ContaDAO;
import com.qualiti.banco.excecoes.BancoException;
import com.qualiti.banco.modelo.Conta;
import com.qualiti.banco.modelo.TipoConta;

public class ContaBOImpl implements ContaBO {
	
	private ContaDAO repositorio;
	
    public ContaBOImpl(ContaDAO repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public void inserir(Conta conta) throws BancoException {
		if(conta == null) {
			throw new BancoException("Objeto Conta null");
		}
		
		if(conta.getNumero() == null || conta.getNumero().isEmpty()) {
			throw new BancoException("Número da conta deve ser informado");
		}
		
		if(conta.getNumero().length() != 6) {
			throw new BancoException("Número de conta inválido");
		}
		
		Conta contaBusca = repositorio.procurar(conta.getNumero());
		if(contaBusca == null) { 
			repositorio.inserir(conta);
		}else {
			throw new BancoException("Número de conta já cadastrado");
		}
		
	}

	@Override
	public void atualizar(Conta conta) throws BancoException {
		if(conta == null) {
			throw new BancoException("Objeto Conta null");
		}
		
		if(conta.getNumero() == null || conta.getNumero().isEmpty()) {
			throw new BancoException("Número da conta deve ser informado");
		}
		
		if(conta.getNumero().length() != 6) {
			throw new BancoException("Número de conta inválido");
		}
		
		Conta contaBusca = repositorio.procurar(conta.getNumero());
		if(contaBusca != null) { 
			repositorio.atualizar(conta);
		}else {
			throw new BancoException("Número de conta não existe");
		}
		
	}

	@Override
	public void remover(String numero) throws BancoException {
		
		if(numero == null || numero.isEmpty()) {
			throw new BancoException("Número da conta deve ser informado");
		}
		
		if(numero.length() != 6) {
			throw new BancoException("Número de conta inválido");
		}
		
		repositorio.remover(numero);
		
	}

	@Override
	public Conta procurar(String numero) throws BancoException {
		if(numero == null || numero.isEmpty()) {
			throw new BancoException("Número da conta deve ser informado");
		}
		
		if(numero.length() != 6) {
			throw new BancoException("Número de conta inválido");
		}
		
		return repositorio.procurar(numero);
	}

	@Override
	public String gerarRelatorioContas() {
		return repositorio.gerarRelatorioContas();
	}

	@Override
	public double recuperarSaldoTotalContas(TipoConta tipo) {
		return repositorio.recuperarSaldoTotalContas(tipo);
	}

	@Override
	public void creditar(String numero, double valor) throws BancoException {
		if(numero == null || numero.isEmpty()) {
			throw new BancoException("Número da conta deve ser informado");
		}
		
		if(numero.length() != 6) {
			throw new BancoException("Número de conta inválido");
		}
		
		if(valor <= 0) {
			throw new BancoException("Valor para crédito deve ser maior que zero");
		}
		
		Conta contaRetorno = repositorio.procurar(numero);
		
		if(contaRetorno != null) {
			
			contaRetorno.creditar(valor);
			repositorio.atualizar(contaRetorno);
	
		}else {
			throw new BancoException("Numero da conta não existe");
		}
		
		
	}

	@Override
	public void debitar(String numero, double valor) throws BancoException {
		if(numero == null || numero.isEmpty()) {
			throw new BancoException("Número da conta deve ser informado");
		}
		
		if(numero.length() != 6) {
			throw new BancoException("Número de conta inválido");
		}
		
		if(valor <= 0) {
			throw new BancoException("Valor para crédito deve ser maior que zero");
		}
		
		Conta contaRetorno = repositorio.procurar(numero);
		
		if(contaRetorno != null) {
			
			contaRetorno.debitar(valor);
			repositorio.atualizar(contaRetorno);
	
		}else {
			throw new BancoException("Numero da conta não existe");
		}
	}

	@Override
	public void transferir(String numeroFonte,
			String numeroDestino, double valor) throws BancoException {
		if(numeroFonte == null || numeroFonte.isEmpty()) {
			throw new BancoException("Número da conta de origem deve ser informado");
		}
		
		if(numeroFonte.length() != 6) {
			throw new BancoException("Número da conta de origem inválido");
		}
		
		if(numeroDestino == null || numeroDestino.isEmpty()) {
			throw new BancoException("Número da conta de destino deve ser informado");
		}
		
		if(numeroDestino.length() != 6) {
			throw new BancoException("Número da conta de destino inválido");
		}
		
		if(valor <= 0) {
			throw new BancoException("Valor para crédito deve ser maior que zero");
		}
		
		Conta contaOrigem = repositorio.procurar(numeroFonte);
		
		if(contaOrigem != null) {
			
			Conta contaDestino = repositorio.procurar(numeroDestino);
			
			if(contaDestino != null) {
				
				contaOrigem.transferir(contaDestino, valor);
				repositorio.atualizar(contaDestino);
				repositorio.atualizar(contaOrigem);
				
			}else {
				throw new BancoException("Numero da conta destino não existe");
			}
			
		}else {
			throw new BancoException("Numero da conta origem não existe");
		}
		
	}

}
