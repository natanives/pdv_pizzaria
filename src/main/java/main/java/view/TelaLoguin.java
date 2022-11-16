package main.java.view;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import model.Funcionario;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class TelaLoguin extends JPanel {
	private static final long serialVersionUID = 1L;
	private Funcionario funcionario;
	private JTextField txfLogin;
	private JPasswordField pwfSenha;

	public TelaLoguin() {
		setBackground(Color.DARK_GRAY);
		setBounds(0, 0, 1100, 820);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(313, 149, 473, 521);
		add(panel);
		panel.setLayout(null);

		JLabel lblTitulo = new JLabel("LOGIN");
		lblTitulo.setFont(new Font("Dialog", Font.BOLD, 18));
		lblTitulo.setBounds(199, 12, 74, 15);
		panel.add(lblTitulo);

		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(123, 132, 45, 15);
		panel.add(lblLogin);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(123, 169, 45, 17);
		panel.add(lblSenha);

		txfLogin = new JTextField();
		txfLogin.setBounds(178, 130, 136, 19);
		panel.add(txfLogin);
		txfLogin.setColumns(10);

		pwfSenha = new JPasswordField();
		pwfSenha.setBounds(178, 168, 136, 19);
		panel.add(pwfSenha);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				funcionario = new Funcionario();
				funcionario = funcionario.validarLogin(txfLogin.getText(), String.valueOf(pwfSenha.getPassword()));
				boolean isAdmin = false;
				if (funcionario.getIS_Admin() == 1) {
					isAdmin = true;
				}

				System.out.println("Nome Do Funcionário: " + funcionario.getNome() + ", É admin: " + isAdmin);
				if (funcionario.getNome() != null) {
					Main.carregarTelaCadastroVendas();
				} else {
					System.out.println("funcionario não cadastrado");
				}
			}
		});
		btnEntrar.setBounds(96, 333, 117, 25);
		panel.add(btnEntrar);

		JButton btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnFechar.setBounds(251, 333, 117, 25);
		panel.add(btnFechar);
	}
}
