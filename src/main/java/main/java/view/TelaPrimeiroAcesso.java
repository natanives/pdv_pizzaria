package main.java.view;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import model.Funcionario;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPrimeiroAcesso extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField txfNome;
	private JTextField txfLogin;
	private JPasswordField pwfSenha;

	public TelaPrimeiroAcesso() {
		setBackground(Color.DARK_GRAY);
		setBounds(0, 0, 1100, 820);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(313, 149, 473, 521);
		add(panel);
		panel.setLayout(null);

		JLabel lblPrimeiroAcesso = new JLabel("Primeiro acesso");
		lblPrimeiroAcesso.setFont(new Font("Dialog", Font.BOLD, 18));
		lblPrimeiroAcesso.setBounds(156, 12, 160, 15);
		panel.add(lblPrimeiroAcesso);

		txfNome = new JTextField();
		txfNome.setBounds(164, 114, 193, 19);
		panel.add(txfNome);
		txfNome.setColumns(10);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(101, 116, 45, 15);
		panel.add(lblNome);

		txfLogin = new JTextField();
		txfLogin.setBounds(164, 180, 193, 19);
		panel.add(txfLogin);
		txfLogin.setColumns(10);

		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setEnabled(true);
		lblLogin.setBounds(101, 182, 45, 15);
		panel.add(lblLogin);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(96, 241, 50, 17);
		panel.add(lblSenha);

		pwfSenha = new JPasswordField();
		pwfSenha.setBounds(165, 240, 192, 19);
		panel.add(pwfSenha);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Funcionario funcionario = new Funcionario();
				int row = funcionario.cadastrarPrimeiroAdmin(txfNome.getText(), txfLogin.getText(),
						String.valueOf(pwfSenha.getPassword()));
				if (row == 1) {
					Main.carregarTelaCadastroVendas();
				}
			}
		});
		btnCadastrar.setBounds(87, 411, 117, 25);
		panel.add(btnCadastrar);

		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnFechar.setBounds(286, 411, 117, 25);
		panel.add(btnFechar);
	}
}
