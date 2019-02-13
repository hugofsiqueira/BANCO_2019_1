package com.qualiti.banco.gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;

public class ContaCadastrarPanel extends JPanel {
	private JTextField numeroTxt;
	private JTextField cpfTxt;
	private JTextField saldoTxt;
	private JButton btnProcurar;
	private JButton btnRemover;
	private JButton btnCadastrar;
	private JButton btnAtualizar;
	private JRadioButton rdbtnCorrente;
	private JRadioButton rdbtnPoupana;
	private JRadioButton rdbtnBonus;
	private JLabel lblNmero;
	private JLabel lblCpf;
	private JLabel lblSaldo;
	private JLabel lblTipo;

	/**
	 * Create the panel.
	 */
	public ContaCadastrarPanel() {
		setLayout(null);
		
		lblNmero = new JLabel("Número:");
		lblNmero.setBounds(44, 50, 70, 15);
		add(lblNmero);
		
		numeroTxt = new JTextField();
		numeroTxt.setBounds(150, 48, 153, 19);
		add(numeroTxt);
		numeroTxt.setColumns(10);
		
		lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(44, 108, 70, 15);
		add(lblCpf);
		
		cpfTxt = new JTextField();
		cpfTxt.setBounds(150, 106, 153, 19);
		add(cpfTxt);
		cpfTxt.setColumns(10);
		
		lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(45, 222, 70, 15);
		add(lblTipo);
		
		rdbtnCorrente = new JRadioButton("Corrente");
		rdbtnCorrente.setSelected(true);
		rdbtnCorrente.setBounds(45, 265, 149, 23);
		add(rdbtnCorrente);
		
		rdbtnPoupana = new JRadioButton("Poupança");
		rdbtnPoupana.setBounds(194, 265, 149, 23);
		add(rdbtnPoupana);
		
		rdbtnBonus = new JRadioButton("Bônus");
		rdbtnBonus.setBounds(347, 265, 149, 23);
		add(rdbtnBonus);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(197, 319, 117, 25);
		add(btnCadastrar);
		
		btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(379, 319, 117, 25);
		add(btnAtualizar);
		
		btnProcurar = new JButton("Procurar");
		btnProcurar.setBounds(329, 45, 117, 25);
		add(btnProcurar);
		
		btnRemover = new JButton("Remover");
		btnRemover.setBounds(470, 45, 117, 25);
		add(btnRemover);
		
		lblSaldo = new JLabel("Saldo:");
		lblSaldo.setBounds(44, 167, 70, 15);
		add(lblSaldo);
		
		saldoTxt = new JTextField();
		saldoTxt.setBounds(150, 165, 153, 19);
		add(saldoTxt);
		saldoTxt.setColumns(10);

	}
}
