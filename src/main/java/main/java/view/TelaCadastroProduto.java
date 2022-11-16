package main.java.view;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import model.Produto;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.Font;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.ScrollPaneConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaCadastroProduto extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField txfNome;
	private JTextField txfValor;
	private Produto produto;
	private ArrayList<String> nomesCadastrados;
	private ArrayList<String> tiposCadastrados;
	private JScrollPane sPLNomesCadastrados;
	private DefaultListModel<String> dflm = new DefaultListModel<String>();
	private JList list;

	public TelaCadastroProduto() {
		setBackground(Color.DARK_GRAY);
		setBounds(0, 0, 1100, 820);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(313, 149, 473, 521);
		add(panel);
		panel.setLayout(null);

		sPLNomesCadastrados = new JScrollPane();
		sPLNomesCadastrados.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sPLNomesCadastrados.setVisible(false);

		txfNome = new JTextField();
		txfNome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == 27) {
					list.removeAll();
					sPLNomesCadastrados.setVisible(false);
				} else {

					if (txfNome.getText().isBlank() == false) {
						String nome = txfNome.getText().trim();
						nomesCadastrados = produto.getNomeProdutoCadastrado(nome);

						if (nomesCadastrados.isEmpty() == false) {
							dflm.removeAllElements();

							int i = 0;
							while (i < nomesCadastrados.size()) {
								dflm.addElement(nomesCadastrados.get(i));
								i++;
							}

							sPLNomesCadastrados.setVisible(true);
						} else {
							sPLNomesCadastrados.setVisible(false);
						}
					} else {
						sPLNomesCadastrados.setVisible(false);
					}
				}
			}
		});

		sPLNomesCadastrados.setBounds(182, 186, 196, 163);
		panel.add(sPLNomesCadastrados);

		list = new JList<String>(dflm);
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		list.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(e.getKeyCode() == 27) {
					sPLNomesCadastrados.setVisible(false);
				}
			}
		});
		list.setBounds(183, 187, 195, 162);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setVisibleRowCount(-1);
		sPLNomesCadastrados.setViewportView(list);

		txfNome.setBounds(222, 167, 114, 19);
		panel.add(txfNome);
		txfNome.setColumns(10);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(169, 169, 50, 15);
		panel.add(lblNome);
		lblNome.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNome.setForeground(Color.DARK_GRAY);

		txfValor = new JTextField();
		txfValor.setBounds(222, 284, 114, 19);
		panel.add(txfValor);
		txfValor.setColumns(10);

		JLabel lblValor = new JLabel("Valor:");
		lblValor.setBounds(154, 286, 50, 15);
		panel.add(lblValor);
		lblValor.setFont(new Font("Dialog", Font.BOLD, 12));
		lblValor.setForeground(Color.DARK_GRAY);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				produto = new Produto();
				int row = produto.cadastrarProduto(txfNome.getText(), Double.valueOf(txfValor.getText()));
				if (row == 1) {
					System.out.println("Cadastro Bem sucedido");
				}
			}
		});
		btnCadastrar.setBounds(53, 453, 117, 25);
		panel.add(btnCadastrar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.carregarTelaCadastroVendas();
			}
		});
		btnCancelar.setBounds(320, 453, 117, 25);
		panel.add(btnCancelar);

		JLabel lblCadastroProduto = new JLabel("Cadastro de produto");
		lblCadastroProduto.setFont(new Font("Dialog", Font.BOLD, 18));
		lblCadastroProduto.setBounds(132, 12, 209, 15);
		panel.add(lblCadastroProduto);
	}
}
