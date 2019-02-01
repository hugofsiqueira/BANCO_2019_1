package com.qualiti.banco.dados;

import com.qualiti.banco.modelo.Conta;

public interface ContaDAO {
	
	void inserir(Conta conta);
	void atualizar(Conta conta);
	void remover(String numero);
	Conta procurar(String numero);

}
