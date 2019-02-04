package com.qualiti.banco.negocio;

import com.qualiti.banco.dados.ContaDAO;
import com.qualiti.banco.modelo.Conta;
import com.qualiti.banco.modelo.TipoConta;

public class ContaBOImpl implements ContaBO {
	
	private ContaDAO repositorio;
	
    public ContaBOImpl(ContaDAO repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public void inserir(Conta conta) {
		if(conta == null) {
			System.out.println("Objeto Conta null");
			return;
		}
		
		if(conta.getNumero() == null || conta.getNumero().isEmpty()) {
			System.out.println("Número da conta deve ser informado");
			return;
		}
		
		if(conta.getNumero().length() != 6) {
			System.out.println("Número de conta inválido");
			return;
		}
		
		Conta contaBusca = repositorio.procurar(conta.getNumero());
		if(contaBusca == null) { 
			repositorio.inserir(conta);
		}else {
			System.out.println("Número de conta já cadastrado");
		}
		
	}

	@Override
	public void atualizar(Conta conta) {
		if(conta == null) {
			System.out.println("Objeto Conta null");
			return;
		}
		
		if(conta.getNumero() == null || conta.getNumero().isEmpty()) {
			System.out.println("Número da conta deve ser informado");
			return;
		}
		
		if(conta.getNumero().length() != 6) {
			System.out.println("Número de conta inválido");
			return;
		}
		
		Conta contaBusca = repositorio.procurar(conta.getNumero());
		if(contaBusca != null) { 
			repositorio.atualizar(conta);
		}else {
			System.out.println("Número de conta não existe");
		}
		
	}

	@Override
	public void remover(String numero) {
		
		if(numero == null || numero.isEmpty()) {
			System.out.println("Número da conta deve ser informado");
			return;
		}
		
		if(numero.length() != 6) {
			System.out.println("Número de conta inválido");
			return;
		}
		
		repositorio.remover(numero);
		
	}

	@Override
	public Conta procurar(String numero) {
		if(numero == null || numero.isEmpty()) {
			System.out.println("Número da conta deve ser informado");
			return null;
		}
		
		if(numero.length() != 6) {
			System.out.println("Número de conta inválido");
			return null;
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
	public void creditar(String numero, double valor) {
		if(numero == null || numero.isEmpty()) {
			System.out.println("Número da conta deve ser informado");
			return;
		}
		
		if(numero.length() != 6) {
			System.out.println("Número de conta inválido");
			return;
		}
		
		if(valor <= 0) {
			System.out.println("Valor para crédito deve ser maior que zero");
			return;
		}
		
		Conta contaRetorno = repositorio.procurar(numero);
		
		if(contaRetorno != null) {
			
			contaRetorno.creditar(valor);
			repositorio.atualizar(contaRetorno);
	
		}else {
			System.out.println("Numero da conta não existe");
		}
		
		
	}

	@Override
	public void debitar(String numero, double valor) {
		if(numero == null || numero.isEmpty()) {
			System.out.println("Número da conta deve ser informado");
			return;
		}
		
		if(numero.length() != 6) {
			System.out.println("Número de conta inválido");
			return;
		}
		
		if(valor <= 0) {
			System.out.println("Valor para crédito deve ser maior que zero");
			return;
		}
		
		Conta contaRetorno = repositorio.procurar(numero);
		
		if(contaRetorno != null) {
			
			contaRetorno.debitar(valor);
			repositorio.atualizar(contaRetorno);
	
		}else {
			System.out.println("Numero da conta não existe");
		}
	}

	@Override
	public void transferir(String numeroFonte, String numeroDestino, double valor) {
		if(numeroFonte == null || numeroFonte.isEmpty()) {
			System.out.println("Número da conta de origem deve ser informado");
			return;
		}
		
		if(numeroFonte.length() != 6) {
			System.out.println("Número da conta de origem inválido");
			return;
		}
		
		if(numeroDestino == null || numeroDestino.isEmpty()) {
			System.out.println("Número da conta de destino deve ser informado");
			return;
		}
		
		if(numeroDestino.length() != 6) {
			System.out.println("Número da conta de destino inválido");
			return;
		}
		
		if(valor <= 0) {
			System.out.println("Valor para crédito deve ser maior que zero");
			return;
		}
		
		Conta contaOrigem = repositorio.procurar(numeroFonte);
		
		if(contaOrigem != null) {
			
			Conta contaDestino = repositorio.procurar(numeroDestino);
			
			if(contaDestino != null) {
				
				contaOrigem.transferir(contaDestino, valor);
				repositorio.atualizar(contaDestino);
				repositorio.atualizar(contaOrigem);
				
			}else {
				System.out.println("Numero da conta destino não existe");
			}
			
		}else {
			System.out.println("Numero da conta origem não existe");
		}
		
	}

}
