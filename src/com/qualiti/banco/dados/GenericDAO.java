package com.qualiti.banco.dados;

import com.qualiti.banco.excecoes.BancoException;

public interface GenericDAO<T, CHAVE> {
	
	void inserir(T entity) throws BancoException;
	void atualizar(T entity) throws BancoException;
	void remover(CHAVE chave) throws BancoException;
	T procurar(CHAVE chave) throws BancoException;

}
