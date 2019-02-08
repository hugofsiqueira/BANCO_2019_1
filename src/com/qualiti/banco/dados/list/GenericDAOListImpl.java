package com.qualiti.banco.dados.list;

import java.util.ArrayList;
import java.util.List;

import com.qualiti.banco.dados.GenericDAO;
import com.qualiti.banco.modelo.BancoEntity;

public class GenericDAOListImpl<T extends BancoEntity<CHAVE>, CHAVE> 
															implements GenericDAO<T, CHAVE> {
	
	private List<T> repositorio;
	
	public GenericDAOListImpl() {
		repositorio = new ArrayList<>();
	}

	@Override
	public void inserir(T entity) {
		repositorio.add(entity);
	}

	@Override
	public void atualizar(T entity) {
		int indice = repositorio.indexOf(entity);
		repositorio.set(indice, entity);
	}

	@Override
	public void remover(CHAVE chave) {
		T entityRetorno = procurar(chave);
		repositorio.remove(entityRetorno);
	}

	@Override
	public T procurar(CHAVE chave) {
		for (T entity : repositorio) {
			if(entity != null && entity.getChave().equals(chave)) {
				return entity;
			}
		}
		return null;
	}
}
