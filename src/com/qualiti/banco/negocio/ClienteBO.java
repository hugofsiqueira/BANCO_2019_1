package com.qualiti.banco.negocio;

import com.qualiti.banco.excecoes.BancoException;
import com.qualiti.banco.modelo.Cliente;

public interface ClienteBO {
	
	void inserir(Cliente cliente) throws BancoException;
	void atualizar(Cliente cliente) throws BancoException;
	void remover(String cpf) throws BancoException;
	Cliente procurar(String cpf) throws BancoException;

}
