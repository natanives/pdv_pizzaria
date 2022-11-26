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
	private JTextField txfTipoProduto;
	private JTextField txfValor;
	private Produto produto;
	private ArrayList<String> nomesCadastrados;
	private ArrayList<String> tiposCadastrados;
	private JScrollPane sPLNomesCadastrados;
	private JScrollPane sPLTiposProdutoCadastrados;
	private DefaultListModel<String> dflmN = new DefaultListModel<String>();
	private DefaultListModel<String> dflmT = new DefaultListModel<String>();
	private JList listaNomes;
	private JList ListaTipos;

	public TelaCadastroProduto() {
		setBackground(Color.DARK_GRAY);
		setBounds(0, 0, 1100, 820);
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(316, 145, 473, 521);
		add(panel);
		panel.setLayout(null);

		JLabel lblCadastroProduto = new JLabel("Cadastro de produto");
		lblCadastroProduto.setFont(new Font("Dialog", Font.BOLD, 18));
		lblCadastroProduto.setBounds(132, 12, 209, 15);
		panel.add(lblCadastroProduto);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(169, 169, 50, 15);
		lblNome.setFont(new Font("Dialog", Font.BOLD, 12));
		lblNome.setForeground(Color.DARK_GRAY);
		panel.add(lblNome);

		sPLNomesCadastrados = new JScrollPane();
		sPLNomesCadastrados.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sPLNomesCadastrados.setVisible(false);

		txfNome = new JTextField();
		txfNome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == 27) {
					listaNomes.removeAll();
					sPLNomesCadastrados.setVisible(false);
				} else {

					if (txfNome.getText().isBlank() == false) {
						String nome = txfNome.getText().trim();
						nomesCadastrados = Produto.getNomeProdutoCadastrado(nome);

						if (nomesCadastrados.isEmpty() == false) {
							dflmN.removeAllElements();

							int i = 0;
							while (i < nomesCadastrados.size()) {
								dflmN.addElement(nomesCadastrados.get(i));
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

		txfNome.setBounds(222, 167, 114, 19);
		panel.add(txfNome);
		txfNome.setColumns(10);
		sPLNomesCadastrados.setBounds(182, 186, 196, 163);
		panel.add(sPLNomesCadastrados);

		listaNomes = new JList<String>(dflmN);
		listaNomes.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == 27) {
					sPLNomesCadastrados.setVisible(false);
				}
			}
		});
		listaNomes.setBounds(183, 187, 195, 162);
		listaNomes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listaNomes.setVisibleRowCount(-1);
		sPLNomesCadastrados.setViewportView(listaNomes);

		JLabel lblTipoDeProduto = new JLabel("Tipo de produto:");
		lblTipoDeProduto.setFont(new Font("Dialog", Font.BOLD, 12));
		lblTipoDeProduto.setForeground(Color.DARK_GRAY);
		lblTipoDeProduto.setBounds(94, 232, 123, 15);
		panel.add(lblTipoDeProduto);

		sPLTiposProdutoCadastrados = new JScrollPane();
		sPLTiposProdutoCadastrados.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		sPLTiposProdutoCadastrados.setVisible(false);

		txfTipoProduto = new JTextField();
		txfTipoProduto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == 27) {
					ListaTipos.removeAll();
					sPLTiposProdutoCadastrados.setVisible(false);
				} else {
					if (txfTipoProduto.getText().isBlank() == false) {
						String tipo = txfTipoProduto.getText().trim();
						tiposCadastrados = Produto.getTipoProdutoCadastrado(tipo);

						if (tiposCadastrados.isEmpty() == false) {
							dflmT.removeAllElements();

							int i = 0;
							while (i < tiposCadastrados.size()) {
								dflmT.addElement(tiposCadastrados.get(i));
								i++;
							}

							sPLTiposProdutoCadastrados.setVisible(true);
						} else {
							sPLTiposProdutoCadastrados.setVisible(false);
						}
					} else {
						sPLTiposProdutoCadastrados.setVisible(false);
					}
				}
			}
		});

		txfTipoProduto.setBounds(222, 230, 114, 19);
		txfTipoProduto.setColumns(10);
		panel.add(txfTipoProduto);
		panel.add(sPLTiposProdutoCadastrados);
		sPLTiposProdutoCadastrados.setBounds(182, 249, 196, 163);

		ListaTipos = new JList<String>(dflmT);
		ListaTipos.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == 27) {
					sPLTiposProdutoCadastrados.setVisible(false);
				}
			}
		});

		ListaTipos.setBounds(183, 248, 195, 162);
		ListaTipos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ListaTipos.setVisibleRowCount(-1);
		sPLTiposProdutoCadastrados.setViewportView(ListaTipos);

		JLabel lblValor = new JLabel("Valor:");
		lblValor.setBounds(154, 286, 50, 15);
		panel.add(lblValor);
		lblValor.setFont(new Font("Dialog", Font.BOLD, 12));
		lblValor.setForeground(Color.DARK_GRAY);

		txfValor = new JTextField();
		txfValor.setBounds(222, 284, 114, 19);
		panel.add(txfValor);
		txfValor.setColumns(10);

		JButton btnCadastrar = new JButton("Cadastrar");
		/*
		 * btnCadastrar.addActionListener(new ActionListener() {
		 * 
		 * TODO pegar o tipo de produto no txfTipoProduto e buscar o id do produto,
		 * então passar como parametro.
		 * 
		 * public void actionPerformed(ActionEvent e) { produto = new Produto(); int row
		 * = produto.cadastrarProduto(txfNome.getText(), *insira idTipoProduto aqui*,
		 * Double.valueOf(txfValor.getText())); if (row == 1) {
		 * System.out.println("Cadastro Bem sucedido"); } } });
		 */
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
	}
}
