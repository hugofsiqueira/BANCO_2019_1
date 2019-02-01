package com.qualiti.banco.dados;

import com.qualiti.banco.modelo.Cliente;

public interface ClienteDAO {
	
	void inserir(Cliente cliente);
	void atualizar(Cliente cliente);
	void remover(String cpf);
	Cliente procurar(String cpf);

}
