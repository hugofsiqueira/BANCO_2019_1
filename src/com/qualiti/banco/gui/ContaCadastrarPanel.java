package com.qualiti.banco.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import com.qualiti.banco.excecoes.BancoException;
import com.qualiti.banco.fachada.Fachada;
import com.qualiti.banco.modelo.Cliente;
import com.qualiti.banco.modelo.Conta;
import com.qualiti.banco.modelo.ContaBonus;
import com.qualiti.banco.modelo.Poupanca;
import com.qualiti.banco.modelo.TipoConta;
import javax.swing.ButtonGroup;

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
	private final ButtonGroup buttonGroup = new ButtonGroup();

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
		lblCpf.setEnabled(false);
		lblCpf.setBounds(44, 108, 70, 15);
		add(lblCpf);
		
		cpfTxt = new JTextField();
		cpfTxt.setEnabled(false);
		cpfTxt.setBounds(150, 106, 153, 19);
		add(cpfTxt);
		cpfTxt.setColumns(10);
		
		lblTipo = new JLabel("Tipo:");
		lblTipo.setEnabled(false);
		lblTipo.setBounds(45, 222, 70, 15);
		add(lblTipo);
		
		rdbtnCorrente = new JRadioButton("Corrente");
		buttonGroup.add(rdbtnCorrente);
		rdbtnCorrente.setEnabled(false);
		rdbtnCorrente.setSelected(true);
		rdbtnCorrente.setBounds(45, 265, 149, 23);
		add(rdbtnCorrente);
		
		rdbtnPoupana = new JRadioButton("Poupança");
		buttonGroup.add(rdbtnPoupana);
		rdbtnPoupana.setEnabled(false);
		rdbtnPoupana.setBounds(194, 265, 149, 23);
		add(rdbtnPoupana);
		
		rdbtnBonus = new JRadioButton("Bônus");
		buttonGroup.add(rdbtnBonus);
		rdbtnBonus.setEnabled(false);
		rdbtnBonus.setBounds(347, 265, 149, 23);
		add(rdbtnBonus);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String cpf = cpfTxt.getText();
				String numero = numeroTxt.getText();
				String saldoTexto = saldoTxt.getText();
				
				TipoConta tipo = null;
				
				Conta conta = null;
				
				if(rdbtnCorrente.isSelected()) {
					tipo = TipoConta.CORRENTE;
					conta = new Conta();
				}
				
				if(rdbtnPoupana.isSelected()) {
					tipo = TipoConta.POUPANCA;
					conta = new Poupanca();
				}
				
				if(rdbtnBonus.isSelected()) {
					tipo = TipoConta.BONUS;
					conta = new ContaBonus();
				}
				
				
				try {
					Cliente cliente = Fachada.getFachada().procurar(cpf);
					
					if(cliente != null) {
						
						conta.setCliente(cliente);
						conta.setNumero(numero);
						
						double saldo = Double.parseDouble(saldoTexto);
						
						conta.setSaldo(saldo);
						conta.setTipo(tipo);
						
						Fachada.getFachada().inserirConta(conta);
						
						JOptionPane.showMessageDialog
						(null, "Conta inserida com sucesso", "Cadastrar Conta",
								JOptionPane.INFORMATION_MESSAGE);
						
						cpfTxt.setText("");
						numeroTxt.setText("");
						rdbtnCorrente.setSelected(true);
						saldoTxt.setText("");
						
						lblCpf.setEnabled(false);
						lblSaldo.setEnabled(false);
						lblTipo.setEnabled(false);
						
						cpfTxt.setEnabled(false);
						saldoTxt.setEnabled(false);
						
						rdbtnBonus.setEnabled(false);
						rdbtnCorrente.setEnabled(false);
						rdbtnPoupana.setEnabled(false);
						
						btnCadastrar.setEnabled(false);
						btnRemover.setEnabled(false);
						btnAtualizar.setEnabled(false);
						
						
					}else {
						
						JOptionPane.showMessageDialog
						(null, "CPF não cadastrado", "Cadastrar Conta",
								JOptionPane.ERROR_MESSAGE);
						
					}
					
					
				} catch (BancoException e1) {
					
					JOptionPane.showMessageDialog
					(null, e1.getMessage(), "Cadastrar Conta",
							JOptionPane.ERROR_MESSAGE);
					
				}
				
				
			}
		});
		btnCadastrar.setEnabled(false);
		btnCadastrar.setBounds(197, 319, 117, 25);
		add(btnCadastrar);
		
		btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String cpf = cpfTxt.getText();
				String numero = numeroTxt.getText();
				String saldoTexto = saldoTxt.getText();
				
				TipoConta tipo = null;
				
				Conta conta = null;
				
				if(rdbtnCorrente.isSelected()) {
					tipo = TipoConta.CORRENTE;
					conta = new Conta();
				}
				
				if(rdbtnPoupana.isSelected()) {
					tipo = TipoConta.POUPANCA;
					conta = new Poupanca();
				}
				
				if(rdbtnBonus.isSelected()) {
					tipo = TipoConta.BONUS;
					conta = new ContaBonus();
				}
				
				
				try {
					Cliente cliente = Fachada.getFachada().procurar(cpf);
					
					if(cliente != null) {
						
						conta.setCliente(cliente);
						conta.setNumero(numero);
						
						double saldo = Double.parseDouble(saldoTexto);
						
						conta.setSaldo(saldo);
						conta.setTipo(tipo);
						
						Fachada.getFachada().atualizarConta(conta);
						
						JOptionPane.showMessageDialog
						(null, "Conta atualizada com sucesso", "Atualizar Conta",
								JOptionPane.INFORMATION_MESSAGE);
						
						cpfTxt.setText("");
						numeroTxt.setText("");
						rdbtnCorrente.setSelected(true);
						saldoTxt.setText("");
						
						lblCpf.setEnabled(false);
						lblSaldo.setEnabled(false);
						lblTipo.setEnabled(false);
						
						cpfTxt.setEnabled(false);
						saldoTxt.setEnabled(false);
						
						rdbtnBonus.setEnabled(false);
						rdbtnCorrente.setEnabled(false);
						rdbtnPoupana.setEnabled(false);
						
						btnCadastrar.setEnabled(false);
						btnRemover.setEnabled(false);
						btnAtualizar.setEnabled(false);
						
						
					}else {
						
						JOptionPane.showMessageDialog
						(null, "CPF não cadastrado", "Cadastrar Conta",
								JOptionPane.ERROR_MESSAGE);
						
					}
					
					
				} catch (BancoException e1) {
					
					JOptionPane.showMessageDialog
					(null, e1.getMessage(), "Cadastrar Conta",
							JOptionPane.ERROR_MESSAGE);
					
				}
				
			}
		});
		btnAtualizar.setEnabled(false);
		btnAtualizar.setBounds(379, 319, 117, 25);
		add(btnAtualizar);
		
		btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String numero = numeroTxt.getText();
				
				try {
					Conta contaBusca = Fachada.getFachada().
												procurarConta(numero);
					if(contaBusca != null) {
						
						cpfTxt.setText(contaBusca.getCliente().getCpf());
						
						String saldoTexto = 
								Double.toString(contaBusca.getSaldo());
						
						saldoTxt.setText(saldoTexto);
						
						TipoConta tipo = contaBusca.getTipo();
						
						if(tipo.equals(TipoConta.CORRENTE)) {
							rdbtnCorrente.setSelected(true);
						}
						
						if(tipo.equals(TipoConta.POUPANCA)) {
							rdbtnPoupana.setSelected(true);
						}
						
						if(tipo.equals(TipoConta.BONUS)) {
							rdbtnBonus.setSelected(true);
						}
						
						lblCpf.setEnabled(true);
						lblSaldo.setEnabled(true);
						lblTipo.setEnabled(true);
						
						cpfTxt.setEnabled(true);
						saldoTxt.setEnabled(true);
						
						rdbtnBonus.setEnabled(true);
						rdbtnCorrente.setEnabled(true);
						rdbtnPoupana.setEnabled(true);
						
						btnAtualizar.setEnabled(true);
						btnRemover.setEnabled(true);
						btnCadastrar.setEnabled(false);
						
					}else {
						
						int escolha = JOptionPane.showConfirmDialog
						(null, "Conta não existe. Deseja Cadastrar?", 
								"Cadastrar Conta", JOptionPane.YES_NO_OPTION);
						
						if(escolha == JOptionPane.YES_OPTION) {
							
							lblCpf.setEnabled(true);
							lblSaldo.setEnabled(true);
							lblTipo.setEnabled(true);
							
							cpfTxt.setEnabled(true);
							saldoTxt.setEnabled(true);
							
							rdbtnBonus.setEnabled(true);
							rdbtnCorrente.setEnabled(true);
							rdbtnPoupana.setEnabled(true);
							
							btnAtualizar.setEnabled(false);
							btnRemover.setEnabled(false);
							btnCadastrar.setEnabled(true);
							
						}
						
					}
					
				} catch (BancoException e1) {
					
					JOptionPane.showMessageDialog
							(null, e1.getMessage(), "Procurar Conta",
									JOptionPane.ERROR_MESSAGE);
					
				}
				
				
			}
		});
		btnProcurar.setBounds(329, 45, 117, 25);
		add(btnProcurar);
		
		btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String numero = numeroTxt.getText();
				
				int escolha = JOptionPane.showConfirmDialog(null, 
						"Deseja remover a conta?", 
						"Remover Conta", JOptionPane.YES_NO_OPTION);
				
				if(escolha == JOptionPane.YES_OPTION) {
				
					try {
						Fachada.getFachada().removerConta(numero);
						
						JOptionPane.showMessageDialog
						(null, "Conta removida com sucesso", "Remover Conta",
								JOptionPane.INFORMATION_MESSAGE);
						
						cpfTxt.setText("");
						numeroTxt.setText("");
						rdbtnCorrente.setSelected(true);
						saldoTxt.setText("");
						
						lblCpf.setEnabled(false);
						lblSaldo.setEnabled(false);
						lblTipo.setEnabled(false);
						
						cpfTxt.setEnabled(false);
						saldoTxt.setEnabled(false);
						
						rdbtnBonus.setEnabled(false);
						rdbtnCorrente.setEnabled(false);
						rdbtnPoupana.setEnabled(false);
						
						btnCadastrar.setEnabled(false);
						btnRemover.setEnabled(false);
						btnAtualizar.setEnabled(false);
						
						
					} catch (BancoException e1) {
						
						JOptionPane.showMessageDialog
						(null, e1.getMessage(), "Remover Conta",
								JOptionPane.ERROR_MESSAGE);
					}
					
				}
					
			}
		});
		btnRemover.setEnabled(false);
		btnRemover.setBounds(470, 45, 117, 25);
		add(btnRemover);
		
		lblSaldo = new JLabel("Saldo:");
		lblSaldo.setEnabled(false);
		lblSaldo.setBounds(44, 167, 70, 15);
		add(lblSaldo);
		
		saldoTxt = new JTextField();
		saldoTxt.setEnabled(false);
		saldoTxt.setBounds(150, 165, 153, 19);
		add(saldoTxt);
		saldoTxt.setColumns(10);

	}
}
