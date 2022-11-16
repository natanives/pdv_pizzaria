package main.java.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.Funcionario;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.FlowLayout;

public class TelaVenda extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private DefaultTableModel modelo = new DefaultTableModel();
	private JTextArea observacao;
	private JButton btnCancelar;
	private JButton btnCadastrar;
	private JTextField txfNome;
	private JTextField txfTelefone;
	private JTextField txfEndereco;
	private JLabel lblNome;
	private JLabel lblTelefone;
	private JLabel lblEndereco;
	private JLabel lblTotalAPagar;
	private JPanel JPTotalAPagar;
	private JLabel lblValorTotal;
	private JMenuItem mntmAdminfuncionrio;
	private JMenuItem mntmAdminfuncionrio_1;
	private JMenuItem mntmCliente_1;
	private JMenuItem mntmProduto;

	public TelaVenda() {
		setForeground(new Color(20, 20, 20));

		setBounds(0, 0, 1100, 786);
		setLayout(null);
		setBackground(Color.DARK_GRAY);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1100, 21);
		add(menuBar);

		JMenu mnCadastrar = new JMenu("Cadastrar");
		menuBar.add(mnCadastrar);

		mntmAdminfuncionrio = new JMenuItem("Admin/Funcionário");
		mntmAdminfuncionrio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Funcionario funcionarioLogado = new Funcionario();
				funcionarioLogado = Main.getFuncionarioLogado();

				if (funcionarioLogado != null && funcionarioLogado.getIS_Admin() == 1) {
					int option = JOptionPane.showConfirmDialog(null, "Os dados da venda atulal serão perdidos",
							"Prosseguir?", JOptionPane.OK_CANCEL_OPTION);

					if (option == 0) {
						Main.carregarTelaCadastroFuncAdmin();
					}
				} else if (funcionarioLogado != null && funcionarioLogado.getIS_Admin() == 0) {
					JOptionPane.showMessageDialog(null, "Apenas o administrador tem acesso a esta area.");
				}

			}
		});
		mnCadastrar.add(mntmAdminfuncionrio);

		mntmProduto = new JMenuItem("Produto");
		mntmProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Object[] opções = { "Pizza", "Pizza meio meio", "Outro" };
				int escolha = JOptionPane.showOptionDialog(null, "Qual produto deseja cadastrar?", "Cadastrar produto",
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, opções, opções[0]);

				switch (escolha) {
					case 0:
						Main.carregarTelaCadastroPizza();
						break;
					case 1:
						Main.carregarTelaCadastroPizzaMeioMeio();
						break;
					case 2:
						Main.carregarTelaCadastroProduto();
						break;
				}

			}
		});
		mnCadastrar.add(mntmProduto);

		JMenuItem mntmCliente = new JMenuItem("Cliente");
		mntmCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.carregarTelaCadastroCliente();
			}
		});
		mnCadastrar.add(mntmCliente);

		JMenu mnEditar = new JMenu("Editar");
		menuBar.add(mnEditar);

		mntmAdminfuncionrio_1 = new JMenuItem("Admin/Funcionário");
		mnEditar.add(mntmAdminfuncionrio_1);

		JMenuItem mntmProduto_1 = new JMenuItem("Produto");
		mnEditar.add(mntmProduto_1);

		mntmCliente_1 = new JMenuItem("Cliente");
		mnEditar.add(mntmCliente_1);

		JMenu mnConsultar = new JMenu("Consultar");
		menuBar.add(mnConsultar);

		JMenuItem mntmPedido_1 = new JMenuItem("Pedido");
		mnConsultar.add(mntmPedido_1);

		JMenu mnLogout = new JMenu("Logout");
		menuBar.add(mnLogout);

		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.setFuncionarioLogado(null);
				Main.carregarTelaLogin();
			}
		});
		mnLogout.add(mntmSair);

		lblNome = new JLabel("Nome:");
		lblNome.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNome.setForeground(Color.WHITE);
		lblNome.setBounds(50, 653, 64, 15);
		add(lblNome);

		txfNome = new JTextField();
		txfNome.setBounds(120, 652, 248, 19);
		txfNome.setColumns(10);
		add(txfNome);

		lblTelefone = new JLabel("Telefone:");
		lblTelefone.setForeground(Color.WHITE);
		lblTelefone.setFont(new Font("Dialog", Font.BOLD, 18));
		lblTelefone.setBounds(20, 680, 94, 15);
		add(lblTelefone);

		txfTelefone = new JTextField();
		txfTelefone.setBounds(120, 680, 248, 19);
		add(txfTelefone);
		txfTelefone.setColumns(10);

		lblEndereco = new JLabel("Endereço:");
		lblEndereco.setForeground(Color.WHITE);
		lblEndereco.setFont(new Font("Dialog", Font.BOLD, 18));
		lblEndereco.setBounds(12, 708, 101, 15);
		add(lblEndereco);

		txfEndereco = new JTextField();
		txfEndereco.setBounds(120, 707, 248, 19);
		add(txfEndereco);
		txfEndereco.setColumns(10);

		JCheckBox CBIsEntrega = new JCheckBox("Entregar");
		CBIsEntrega.setForeground(Color.WHITE);
		CBIsEntrega.setBackground(Color.DARK_GRAY);
		CBIsEntrega.setBounds(522, 756, 94, 23);
		add(CBIsEntrega);

		observacao = new JTextArea();
		observacao.setBounds(479, 646, 609, 80);
		add(observacao);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addItem("Dinheiro");
		comboBox.addItem("Pix");
		comboBox.addItem("Cartão de crédito");
		comboBox.addItem("Cartão de débito");
		comboBox.setBounds(624, 755, 149, 24);
		add(comboBox);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Cancelar");
			}
		});
		btnCancelar.setBounds(963, 755, 117, 25);
		add(btnCancelar);

		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Cadastrar");
				
				
			}
		});
		btnCadastrar.setBounds(834, 755, 117, 25);
		add(btnCadastrar);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(0, 22, 1100, 597);
		add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 1100, 560);
		panel.add(scrollPane);

		table = new JTable(modelo);
		modelo.addColumn("Produto");
		modelo.addColumn("QTD");
		modelo.addColumn("Valor");
		table.getColumnModel().getColumn(0).setPreferredWidth(850);
		table.getColumnModel().getColumn(1).setPreferredWidth(15);


		scrollPane.setViewportView(table);

		JPTotalAPagar = new JPanel();
		JPTotalAPagar.setBounds(944, 568, 132, 23);
		panel.add(JPTotalAPagar);
		JPTotalAPagar.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		lblValorTotal = new JLabel("0,00");
		JPTotalAPagar.add(lblValorTotal);
		lblValorTotal.setFont(new Font("Dialog", Font.BOLD, 16));

		lblTotalAPagar = new JLabel("Total a pagar:");
		lblTotalAPagar.setBounds(793, 572, 149, 19);
		panel.add(lblTotalAPagar);
		lblTotalAPagar.setFont(new Font("Dialog", Font.BOLD, 18));
		lblTotalAPagar.setForeground(Color.DARK_GRAY);

		JButton btnAdcionarProduto = new JButton("Adcionar produto");
		btnAdcionarProduto.setBounds(8, 566, 157, 25);
		panel.add(btnAdcionarProduto);

		JButton btnRemoverProduto = new JButton("Remover produto");
		btnRemoverProduto.setBounds(175, 566, 157, 25);
		panel.add(btnRemoverProduto);

		JLabel lblNewLabel = new JLabel("Observação");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(479, 631, 126, 15);
		add(lblNewLabel);
	}
}
