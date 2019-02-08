package com.qualiti.banco.dados;

import com.qualiti.banco.modelo.Conta;
import com.qualiti.banco.modelo.TipoConta;

public interface ContaDAO extends GenericDAO<Conta, String>{

	String gerarRelatorioContas();
	double recuperarSaldoTotalContas(TipoConta tipo);

}
