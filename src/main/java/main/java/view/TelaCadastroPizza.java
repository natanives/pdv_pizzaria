package main.java.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaCadastroPizza extends JPanel {

	private static final long serialVersionUID = 1L;

	public TelaCadastroPizza() {
		setBackground(Color.DARK_GRAY);
		setBounds(0, 0, 1100, 820);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(313, 149, 473, 521);
		add(panel);
		panel.setLayout(null);

		JLabel lblTitulo = new JLabel("Cadastro de Pizza");
		lblTitulo.setFont(new Font("Dialog", Font.BOLD, 18));
		lblTitulo.setBounds(147, 12, 179, 15);
		panel.add(lblTitulo);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.carregarTelaCadastroVendas();
			}
		});

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnCadastrar.setBounds(65, 423, 117, 25);
		panel.add(btnCadastrar);
		btnVoltar.setBounds(297, 423, 117, 25);
		panel.add(btnVoltar);

	}

}
