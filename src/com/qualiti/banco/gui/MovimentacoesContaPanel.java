package com.qualiti.banco.gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import com.qualiti.banco.excecoes.BancoException;
import com.qualiti.banco.fachada.Fachada;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class MovimentacoesContaPanel extends JPanel {
	private JTextField contaOrigemTxt;
	private JTextField contaDestinoTxt;
	private JTextField valorTxt;
	private JComboBox<String> tipoCb;
	private JLabel lblCondaDestino;
	private JButton btnConfirmar;

	/**
	 * Create the panel.
	 */
	public MovimentacoesContaPanel() {
		setLayout(null);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(70, 81, 70, 15);
		add(lblTipo);
		
		lblCondaDestino = new JLabel("Conta destino:");
		lblCondaDestino.setEnabled(false);
		lblCondaDestino.setBounds(70, 173, 119, 15);
		add(lblCondaDestino);
		
		contaDestinoTxt = new JTextField();
		contaDestinoTxt.setEnabled(false);
		contaDestinoTxt.setBounds(211, 169, 114, 19);
		add(contaDestinoTxt);
		contaDestinoTxt.setColumns(10);
		
		tipoCb = new JComboBox<>();
		tipoCb.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				String tipo = (String)tipoCb.getSelectedItem();
				
				if(tipo.equals("Transferência")) {
					lblCondaDestino.setEnabled(true);
					contaDestinoTxt.setText("");
					contaDestinoTxt.setEnabled(true);
				}else {
					lblCondaDestino.setEnabled(false);
					contaDestinoTxt.setText("");
					contaDestinoTxt.setEnabled(false);
				}
			}
		});
		
		tipoCb.addItem("");
		tipoCb.addItem("Crédito");
		tipoCb.addItem("Débito");
		tipoCb.addItem("Transferência");
		
		tipoCb.setBounds(211, 76, 183, 24);
		add(tipoCb);
		
		JLabel lblContaOrigem = new JLabel("Conta origem:");
		lblContaOrigem.setBounds(70, 128, 100, 15);
		add(lblContaOrigem);
		
		contaOrigemTxt = new JTextField();
		contaOrigemTxt.setBounds(211, 126, 114, 19);
		add(contaOrigemTxt);
		contaOrigemTxt.setColumns(10);
		
		JLabel lblValor = new JLabel("Valor:");
		lblValor.setBounds(70, 216, 70, 15);
		add(lblValor);
		
		valorTxt = new JTextField();
		valorTxt.setBounds(211, 214, 114, 19);
		add(valorTxt);
		valorTxt.setColumns(10);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String tipo = (String)tipoCb.getSelectedItem();
				String numero = contaOrigemTxt.getText();
				String valorTexto = valorTxt.getText();
				
				double valor = Double.parseDouble(valorTexto);
				
				
				if(tipo.isEmpty()) {
					JOptionPane.showMessageDialog(null, 
							"Informe o tipo da movimentação", 
							"Movimentação Conta", 
							JOptionPane.INFORMATION_MESSAGE);
					
					return;
				}
				
				if(tipo.equals("Crédito")) {
					
					try {
						Fachada.getFachada().creditar(numero, valor);
						
						JOptionPane.showMessageDialog(null, 
								"Crédito realizado com sucesso", 
								"Movimentação Conta", 
								JOptionPane.INFORMATION_MESSAGE);
						
						tipoCb.setSelectedItem("");
						contaOrigemTxt.setText("");
						valorTxt.setText("");
						
					} catch (BancoException e1) {
						
						JOptionPane.showMessageDialog(null, 
								e1.getMessage(), 
								"Movimentação Conta", 
								JOptionPane.ERROR_MESSAGE);
						
					}
					
				}
				
				if(tipo.equals("Débito")) {
					
					try {
						Fachada.getFachada().debitar(numero, valor);
						
						JOptionPane.showMessageDialog(null, 
								"Débito realizado com sucesso", 
								"Movimentação Conta", 
								JOptionPane.INFORMATION_MESSAGE);
						
						tipoCb.setSelectedItem("");
						contaOrigemTxt.setText("");
						valorTxt.setText("");
						
					} catch (BancoException e1) {
						
						JOptionPane.showMessageDialog(null, 
								e1.getMessage(), 
								"Movimentação Conta", 
								JOptionPane.ERROR_MESSAGE);
						
					}
					
				}
				
				if(tipo.equals("Transferência")) {
					
					try {
						
						String numeroDestino = contaDestinoTxt.getText();
						
						Fachada.getFachada().
						transferir(numero, numeroDestino, valor);
						
						JOptionPane.showMessageDialog(null, 
								"Transferência realizada com sucesso", 
								"Movimentação Conta", 
								JOptionPane.INFORMATION_MESSAGE);
						
						tipoCb.setSelectedItem("");
						contaOrigemTxt.setText("");
						contaDestinoTxt.setText("");
						valorTxt.setText("");
						
					} catch (BancoException e1) {
						
						JOptionPane.showMessageDialog(null, 
								e1.getMessage(), 
								"Movimentação Conta", 
								JOptionPane.ERROR_MESSAGE);
						
					}
					
				}
				
				
				
				
			}
		});
		btnConfirmar.setBounds(211, 296, 117, 25);
		add(btnConfirmar);

	}
}
