package com.qualiti.banco.dados;

public interface GenericDAO<T, CHAVE> {
	
	void inserir(T entity);
	void atualizar(T entity);
	void remover(CHAVE chave);
	T procurar(CHAVE chave);

}
