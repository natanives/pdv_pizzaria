package main.java.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Funcionario;
import model.dao.Banco;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	private static JPanel contentPane;
	private static Funcionario funcionarioLogado;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setTitle("PDV Pizzaria");
					frame.setResizable(false);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Main() {
		if(!Banco.isConfigurado()) {
			Banco.configurar();
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(170, 40, 1100, 820);

		contentPane = new JPanel();
		Funcionario funcionario = new Funcionario();

		if (funcionario.existeAdminCadastrado()) {
			JPanel telaLogin = new TelaLoguin();
			contentPane = telaLogin;
			setContentPane(contentPane);
		} else {
			JPanel telaPrimeiroAcesso = new TelaPrimeiroAcesso();
			contentPane = telaPrimeiroAcesso;
			setContentPane(contentPane);
		}
	}

	public static void setFuncionarioLogado(Funcionario funcionario) {
		funcionarioLogado = funcionario;
	}

	public static Funcionario getFuncionarioLogado() {
		return funcionarioLogado;
	}

	public static void carregarTelaCadastroVendas() {
		contentPane.removeAll();
		contentPane.repaint();
		contentPane.revalidate();

		TelaVenda telaVenda = new TelaVenda();
		contentPane.add(telaVenda);
		contentPane.repaint();
		contentPane.revalidate();
	}

	public static void carregarTelaLogin() {
		contentPane.removeAll();
		contentPane.repaint();
		contentPane.revalidate();

		TelaLoguin telaLogin = new TelaLoguin();
		contentPane.add(telaLogin);
		contentPane.repaint();
		contentPane.revalidate();
	}

	public static void carregarTelaCadastroFuncAdmin() {
		contentPane.removeAll();
		contentPane.repaint();
		contentPane.revalidate();

		TelaCadastroFuncAdmin telaCadastroFuncAdmin = new TelaCadastroFuncAdmin();
		contentPane.add(telaCadastroFuncAdmin);
		contentPane.repaint();
		contentPane.revalidate();
	}
	
	public static void carregarTelaCadastroPizza() {
		contentPane.removeAll();
		contentPane.repaint();
		contentPane.revalidate();

		TelaCadastroPizza telaCadastroPizza = new TelaCadastroPizza();
		contentPane.add(telaCadastroPizza);
		contentPane.repaint();
		contentPane.revalidate();
	}

	public static void carregarTelaCadastroPizzaMeioMeio() {
		contentPane.removeAll();
		contentPane.repaint();
		contentPane.revalidate();

		TelaCadastroPizzaMeioMeio telaCadastroPizzaMeioMeio = new TelaCadastroPizzaMeioMeio();
		contentPane.add(telaCadastroPizzaMeioMeio);
		contentPane.repaint();
		contentPane.revalidate();
	}

	public static void carregarTelaCadastroProduto() {
		contentPane.removeAll();
		contentPane.repaint();
		contentPane.revalidate();

		TelaCadastroProduto telaCadastroProduto = new TelaCadastroProduto();
		contentPane.add(telaCadastroProduto);
		contentPane.repaint();
		contentPane.revalidate();
	}

	public static void carregarTelaCadastroCliente() {
		contentPane.removeAll();
		contentPane.repaint();
		contentPane.revalidate();

		TelaCadastroCliente telaCadastroCliente = new TelaCadastroCliente();
		contentPane.add(telaCadastroCliente);
		contentPane.repaint();
		contentPane.revalidate();
	}
}
