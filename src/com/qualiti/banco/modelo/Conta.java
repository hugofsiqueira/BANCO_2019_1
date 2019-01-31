package com.qualiti.banco.modelo;

import java.time.LocalDate;

public class Conta {
	
	private String numero;
	private double saldo;
	private Cliente cliente;
	private LocalDate dataAbertura;
	private TipoConta tipo;
	
	public Conta() {
		saldo = 1000;
	}
	
	public Conta(String numero) {
		this.numero = numero;
	}
	
	public void creditar(double valor) {
		saldo = saldo + valor;
	}
	
	public void debitar(double valor) {
		if(valor <= saldo) {
			saldo = saldo - valor;
		}else {
			System.out.println("Saldo insuficiente");
		}
	}
	
	public void transferir(Conta contaDestino, double valor) {
		if(valor <= saldo) {
			debitar(valor);
			contaDestino.creditar(valor);
		}else {
			System.out.println("Saldo insuficiente");
		}
	}
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public LocalDate getDataAbertura() {
		return dataAbertura;
	}
	public void setDataAbertura(LocalDate dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	public TipoConta getTipo() {
		return tipo;
	}
	public void setTipo(TipoConta tipo) {
		this.tipo = tipo;
	}
}
