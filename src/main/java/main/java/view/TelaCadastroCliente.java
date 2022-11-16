package main.java.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Cliente;

public class TelaCadastroCliente extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField txfNome;
	private JTextField txfTelefone;
	private JTextField txfBairro;
	private JTextField txfRua;
	private JTextField txfNumCasa;
	private JTextField txfComplemento;

	public TelaCadastroCliente() {
		setBackground(Color.DARK_GRAY);
		setBounds(0, 0, 1100, 820);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(313, 149, 473, 521);
		add(panel);
		panel.setLayout(null);

		JLabel lblTitulo = new JLabel("Cadastro de Cliente");
		lblTitulo.setFont(new Font("Dialog", Font.BOLD, 18));
		lblTitulo.setBounds(137, 12, 199, 15);
		panel.add(lblTitulo);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(169, 132, 45, 15);
		panel.add(lblNome);

		txfNome = new JTextField();
		txfNome.setBounds(232, 130, 136, 19);
		panel.add(txfNome);
		txfNome.setColumns(10);

		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(152, 159, 62, 17);
		panel.add(lblTelefone);

		txfTelefone = new JTextField();
		txfTelefone.setBounds(232, 158, 136, 19);
		panel.add(txfTelefone);

		JLabel lblBairro = new JLabel("Bairro");
		lblBairro.setBounds(171, 188, 43, 15);
		panel.add(lblBairro);

		txfBairro = new JTextField();
		txfBairro.setBounds(232, 189, 136, 19);
		panel.add(txfBairro);
		txfBairro.setColumns(10);

		JLabel lblRua = new JLabel("Rua");
		lblRua.setBounds(187, 222, 27, 15);
		panel.add(lblRua);

		txfRua = new JTextField();
		txfRua.setBounds(232, 220, 136, 19);
		panel.add(txfRua);
		txfRua.setColumns(10);

		JLabel lblNumero = new JLabel("Número");
		lblNumero.setBounds(159, 253, 55, 15);
		panel.add(lblNumero);

		txfNumCasa = new JTextField();
		txfNumCasa.setBounds(232, 251, 136, 19);
		panel.add(txfNumCasa);
		txfNumCasa.setColumns(10);

		JLabel lblComplemento = new JLabel("Complemento");
		lblComplemento.setBounds(117, 284, 97, 15);
		panel.add(lblComplemento);

		txfComplemento = new JTextField();
		txfComplemento.setBounds(232, 282, 136, 19);
		panel.add(txfComplemento);
		txfComplemento.setColumns(10);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.carregarTelaCadastroVendas();
			}
		});

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (Cliente.isCadastrado(txfNome.getText().trim(), txfTelefone.getText().trim())) {
					JOptionPane.showMessageDialog(null, "O cliente em questão já está cadastrado");
				} else {
					Cliente.cadastrarCliente(txfNome.getText(), txfTelefone.getText(), txfBairro.getText(),
							txfRua.getText(), txfNumCasa.getText(), txfComplemento.getText());
				}

				// TODO Cadastrar clienete
				int row = Cliente.cadastrarCliente("nome", "telefone", "bairro", "rua", "numero", "complemento");
			}
		});
		btnCadastrar.setBounds(65, 423, 117, 25);
		panel.add(btnCadastrar);
		btnVoltar.setBounds(297, 423, 117, 25);
		panel.add(btnVoltar);

	}
}
