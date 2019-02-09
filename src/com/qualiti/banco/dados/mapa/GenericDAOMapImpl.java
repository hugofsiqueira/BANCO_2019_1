package com.qualiti.banco.dados.mapa;

import java.util.Hashtable;
import java.util.Map;

import com.qualiti.banco.dados.GenericDAO;
import com.qualiti.banco.modelo.BancoEntity;

public class GenericDAOMapImpl<T extends BancoEntity<CHAVE>, CHAVE> 
												implements GenericDAO<T, CHAVE> {
	
	protected Map<CHAVE, T> repositorio;
	
	public GenericDAOMapImpl() {
		repositorio = new Hashtable<>();
	}

	@Override
	public void inserir(T entity) {
		repositorio.put(entity.getChave(),  entity);
	}

	@Override
	public void atualizar(T entity) {
		repositorio.put(entity.getChave(),  entity);
	}

	@Override
	public void remover(CHAVE chave) {
		repositorio.remove(chave);
	}

	@Override
	public T procurar(CHAVE chave) {
		return repositorio.get(chave);
	}

}
