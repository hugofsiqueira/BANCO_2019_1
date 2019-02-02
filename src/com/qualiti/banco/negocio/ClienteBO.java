package com.qualiti.banco.negocio;

import com.qualiti.banco.modelo.Cliente;

public interface ClienteBO {
	
	void inserir(Cliente cliente);
	void atualizar(Cliente cliente);
	void remover(String cpf);
	Cliente procurar(String cpf);

}
