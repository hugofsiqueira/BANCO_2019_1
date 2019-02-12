package com.qualiti.banco.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import com.qualiti.banco.excecoes.BancoException;
import com.qualiti.banco.fachada.Fachada;
import com.qualiti.banco.modelo.Cliente;
import com.qualiti.banco.modelo.Endereco;
import com.qualiti.banco.util.DateUtil;

public class ClienteCadastrarPanel extends JPanel {
	private JTextField nomeTxt;
	private JTextField loginTxt;
	private JPasswordField senhaTxt;
	private JTextField emailTxt;
	private JTextField telefoneTxt;
	private JTextField logradouroTxt;
	private JTextField numeroTxt;
	private JTextField complementoTxt;
	private JTextField bairroTxt;
	private JTextField cidadeTxt;
	private JFormattedTextField cpfTxt;
	private JComboBox<String> ufCb;
	private JButton btnAtualizar;
	private JButton btnCadastrar;
	private JButton btnProcurar;
	private JButton btnRemover;
	private JLabel lblDataNascimento;
	private JTextField dataNascimentoTxt;

	/**
	 * Create the panel.
	 */
	public ClienteCadastrarPanel() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setBounds(32, 88, 70, 15);
		add(lblNewLabel);
		
		nomeTxt = new JTextField();
		nomeTxt.setBounds(100, 86, 294, 19);
		add(nomeTxt);
		nomeTxt.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(32, 43, 49, 15);
		add(lblCpf);
		
		cpfTxt = new JFormattedTextField();
		cpfTxt.setBounds(100, 41, 183, 19);
		add(cpfTxt);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(32, 135, 70, 15);
		add(lblLogin);
		
		loginTxt = new JTextField();
		loginTxt.setBounds(100, 133, 183, 19);
		add(loginTxt);
		loginTxt.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(324, 135, 70, 15);
		add(lblSenha);
		
		senhaTxt = new JPasswordField();
		senhaTxt.setBounds(394, 133, 183, 19);
		add(senhaTxt);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(32, 182, 70, 15);
		add(lblEmail);
		
		emailTxt = new JTextField();
		emailTxt.setBounds(100, 180, 294, 19);
		add(emailTxt);
		emailTxt.setColumns(10);
		
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(32, 226, 70, 15);
		add(lblTelefone);
		
		telefoneTxt = new JTextField();
		telefoneTxt.setBounds(110, 224, 129, 19);
		add(telefoneTxt);
		telefoneTxt.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(32, 268, 545, 15);
		add(separator);
		
		JLabel lblNewLabel_1 = new JLabel("Endereço");
		lblNewLabel_1.setBounds(32, 268, 70, 15);
		add(lblNewLabel_1);
		
		JLabel lblLogradouro = new JLabel("Logradouro:");
		lblLogradouro.setBounds(32, 309, 101, 15);
		add(lblLogradouro);
		
		logradouroTxt = new JTextField();
		logradouroTxt.setBounds(144, 307, 433, 19);
		add(logradouroTxt);
		logradouroTxt.setColumns(10);
		
		JLabel lblNmero = new JLabel("Número:");
		lblNmero.setBounds(32, 344, 70, 15);
		add(lblNmero);
		
		numeroTxt = new JTextField();
		numeroTxt.setBounds(144, 342, 114, 19);
		add(numeroTxt);
		numeroTxt.setColumns(10);
		
		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setBounds(287, 344, 107, 15);
		add(lblComplemento);
		
		complementoTxt = new JTextField();
		complementoTxt.setBounds(394, 342, 183, 19);
		add(complementoTxt);
		complementoTxt.setColumns(10);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(32, 382, 70, 15);
		add(lblBairro);
		
		bairroTxt = new JTextField();
		bairroTxt.setBounds(144, 380, 250, 19);
		add(bairroTxt);
		bairroTxt.setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(32, 419, 70, 15);
		add(lblCidade);
		
		cidadeTxt = new JTextField();
		cidadeTxt.setBounds(144, 417, 250, 19);
		add(cidadeTxt);
		cidadeTxt.setColumns(10);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(416, 382, 70, 15);
		add(lblCep);
		
		JFormattedTextField cepTxt = new JFormattedTextField();
		cepTxt.setBounds(464, 380, 113, 19);
		add(cepTxt);
		
		JLabel lblUf = new JLabel("UF:");
		lblUf.setBounds(416, 419, 70, 15);
		add(lblUf);
		
		ufCb = new JComboBox<>();
		
		ufCb.addItem("");
		ufCb.addItem("AL");
		ufCb.addItem("PE");
		ufCb.addItem("RJ");
		ufCb.addItem("SP");
		ufCb.addItem("BA");
		
		ufCb.setBounds(464, 414, 113, 24);
		add(ufCb);
		
		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String cpf = cpfTxt.getText();
				String nome = nomeTxt.getText();
				String login = loginTxt.getText();
				String senha = new String(senhaTxt.getPassword());
				String telefone = telefoneTxt.getText();
				String email = emailTxt.getText();
				String dataNascimento = dataNascimentoTxt.getText();
				
				try {
				
					LocalDate dataNascimentoDate = 
							DateUtil.converterTextoData(dataNascimento);
					
					String logradouro = logradouroTxt.getText();
					String numero = numeroTxt.getText();
					String complemento = complementoTxt.getText();
					String bairro = bairroTxt.getText();
					String cidade = cidadeTxt.getText();
					String cep = cepTxt.getText();
					String uf = (String)ufCb.getSelectedItem();
					
					Endereco end = new Endereco();
					end.setLogradouro(logradouro);
					end.setNumero(numero);
					end.setComplemento(complemento);
					end.setBairro(bairro);
					end.setCidade(cidade);
					end.setCep(cep);
					end.setUf(uf);
					
				
					Cliente cliente = new Cliente();
					cliente.setCpf(cpf);
					cliente.setNome(nome);
					cliente.setDataNascimento(dataNascimentoDate);
					cliente.setLogin(login);
					cliente.setSenha(senha);
					cliente.setEmail(email);
					cliente.setTelefone(telefone);
					
					cliente.setEndereco(end);
					
					
					Fachada.getFachada().inserirCliente(cliente);
					
					JOptionPane.showMessageDialog(
							null, "Cliente cadastrado com sucesso", 
							"Cadastrar Cliente", 
							JOptionPane.INFORMATION_MESSAGE);
				
				
				}catch(BancoException ex) {
					
					JOptionPane.showMessageDialog(
							null, ex.getMessage(), 
							"Cadastrar Cliente", JOptionPane.ERROR_MESSAGE);
					
				}catch(DateTimeParseException ex) {
					
					JOptionPane.showMessageDialog(
							null, "Data Inválida", 
							"Cadastrar Cliente", JOptionPane.ERROR_MESSAGE);
					
				}
			}
		});
		btnCadastrar.setBounds(262, 487, 117, 25);
		add(btnCadastrar);
		
		btnProcurar = new JButton("Procurar");
		btnProcurar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String cpf = cpfTxt.getText();
				
				try {
					Cliente clienteBusca = Fachada.getFachada().procurar(cpf);
					
					if(clienteBusca != null) {
						
						nomeTxt.setText(clienteBusca.getNome());
						emailTxt.setText(clienteBusca.getEmail());
						
					}else {
						
						JOptionPane.showMessageDialog(
								null, "CPF não cadastrado", 
								"Cadastrar Cliente", JOptionPane.INFORMATION_MESSAGE);
						
					}
					
					
				} catch (BancoException e1) {
					
					JOptionPane.showMessageDialog(
							null, e1.getMessage(), 
							"Cadastrar Cliente", JOptionPane.ERROR_MESSAGE);
					
				}
				
			}
		});
		btnProcurar.setBounds(319, 38, 117, 25);
		add(btnProcurar);
		
		btnRemover = new JButton("Remover");
		btnRemover.setBounds(460, 38, 117, 25);
		add(btnRemover);
		
		btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(438, 487, 117, 25);
		add(btnAtualizar);
		
		lblDataNascimento = new JLabel("Data Nascimento:");
		lblDataNascimento.setBounds(324, 226, 133, 15);
		add(lblDataNascimento);
		
		dataNascimentoTxt = new JTextField();
		dataNascimentoTxt.setBounds(463, 224, 114, 19);
		add(dataNascimentoTxt);
		dataNascimentoTxt.setColumns(10);

	}
}
