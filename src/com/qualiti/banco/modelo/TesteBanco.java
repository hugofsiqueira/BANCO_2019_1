package com.qualiti.banco.modelo;

public class TesteBanco {

	public static void main(String[] args) {
		Conta c1 = new Conta();
		
		Conta c3 = new Conta("8888-9");
		
		Cliente cli = new Cliente();
		
		Cliente cli2 = new Cliente("Ana Maria", "088");
		
		Poupanca p = new Poupanca();
		p.setSaldo(1000);
		p.setNumero("47653-x");
		
		ContaBonus cb1 = new ContaBonus();
		cb1.creditar(1000);
		
		System.out.println("SALDO CB: "+cb1.getSaldo());
		System.out.println("BONUS CB: "+cb1.getBonus());
		
		p.creditar(500);
		p.debitar(200);
		p.renderJuros(0.1);
		
		c1.setNumero("1234-x");
		c1.setSaldo(500);
		c1.creditar(1000);
		
		Conta c2 = new Conta();
		c2.setNumero("3456-1");
		c2.setSaldo(2000);
		
		c2.debitar(500);
		
		System.out.println("Saldo C2 = "+c2.getSaldo());
		
		System.out.println("Saldo C1 =  "+c1.getSaldo());
		
		c1.setSaldo(1000);
		c2.setSaldo(1000);
		
		c1.transferir(c2, 500);
		
		System.out.println("Saldo C2 = "+c2.getSaldo());
		
		System.out.println("Saldo C1 =  "+c1.getSaldo());
		
		c1.transferir(c2, 1000);
		
		System.out.println("Saldo C2 = "+c2.getSaldo());
		
		System.out.println("Saldo C1 =  "+c1.getSaldo());
		
	}

}
