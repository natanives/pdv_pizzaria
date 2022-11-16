package model.dao;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Banco {
	private static Connection c = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs;

	public static boolean isConfigurado() {
		boolean configurado = false;

		File diretorio = new File(".pdvpizzaria.db");
		if (diretorio.exists()) {
			System.out.println("O banco de dados já existe");
			configurado = true;
		}

		return configurado;
	}

	public static void configurar() {
		criarTblBairro();
		criarTblCliente();
		criarTblComplemento();
		criarTblEnderecoCliente();
		criarTblEnderecoPedido();
		criarTblFormaPagamento();
		criarTblFormaPagamentoPedido();
		criarTblFuncionario();
		criarTblNumero();
		criarTblPedido();
		criarTblPizza();
		criarTblPizzaMeioMeio();
		criarTblPizzaMeioMeioPedido();
		criarTblPizzaPedido();
		criarTblProduto();
		criarTblProdutoPedido();
		criarTblRua();
		criarTblSaborPrimario();
		criarTblSaborSecundario();
		criarTblTelefone();
		criarTblTelefoneCliente();
	}

	private static void criarTblTelefoneCliente() {

		try {
			String sql = "CREATE TABLE tbl_telefone_cliente (ID_Telefone INTEGER NOT NULL, "
					+ "ID_Cliente INTEGER NOT NULL, " + "FOREIGN KEY(ID_Cliente) REFERENCES tbl_cliente(ID_Cliente), "
					+ "FOREIGN KEY(ID_Telefone) REFERENCES tbl_telefone_cliente(ID_Telefone))";

			c = FabricaDeConexoes.abrirConexao();
			ps = c.prepareStatement(sql);
			ps.executeUpdate();
			c.commit();
			FabricaDeConexoes.fecharConexao(rs, ps, c);

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}

	}

	private static void criarTblTelefone() {

		try {
			String sql = "CREATE TABLE tbl_telefone (ID_Telefone INTEGER PRIMARY KEY AUTOINCREMENT, "
					+ "Telefone TEXT NOT NULL UNIQUE)";

			c = FabricaDeConexoes.abrirConexao();
			ps = c.prepareStatement(sql);
			ps.executeUpdate();
			c.commit();
			FabricaDeConexoes.fecharConexao(rs, ps, c);

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}

	}

	private static void criarTblSaborSecundario() {

		try {
			String sql = "CREATE TABLE tbl_sabor_secundario (ID_Sabor_Secundario INTEGER PRIMARY KEY AUTOINCREMENT, "
					+ "Sabor_Secundario TEXT NOT NULL UNIQUE, " + "Valor REAL NOT NULL)";

			c = FabricaDeConexoes.abrirConexao();
			ps = c.prepareStatement(sql);
			ps.executeUpdate();
			c.commit();
			FabricaDeConexoes.fecharConexao(rs, ps, c);

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}

	}

	private static void criarTblSaborPrimario() {

		try {
			String sql = "CREATE TABLE tbl_sabor_primario (ID_Sabor_Primario INTEGER PRIMARY KEY AUTOINCREMENT, "
					+ "Sabor_Primario TEXT NOT NULL UNIQUE, " + "Valor REAL NOT NULL)";

			c = FabricaDeConexoes.abrirConexao();
			ps = c.prepareStatement(sql);
			ps.executeUpdate();
			c.commit();
			FabricaDeConexoes.fecharConexao(rs, ps, c);

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}

	}

	private static void criarTblRua() {

		try {
			String sql = "CREATE TABLE tbl_rua (ID_Rua INTEGER PRIMARY KEY AUTOINCREMENT, "
					+ "Rua TEXT NOT NULL UNIQUE)";

			c = FabricaDeConexoes.abrirConexao();
			ps = c.prepareStatement(sql);
			ps.executeUpdate();
			c.commit();
			FabricaDeConexoes.fecharConexao(rs, ps, c);

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}

	}

	private static void criarTblProdutoPedido() {

		try {
			String sql = "CREATE TABLE tbl_produto_pedido (ID_Produto INTEGER NOT NULL, "
					+ "ID_Pedido INTEGER NOT NULL, " + "Quantidade INTEGER NOT NULL, "
					+ "FOREIGN KEY(ID_Produto) REFERENCES tbl_produto_pedido(ID_Produto), "
					+ "FOREIGN KEY(ID_Pedido) REFERENCES tbl_pedido(ID_Pedido))";

			c = FabricaDeConexoes.abrirConexao();
			ps = c.prepareStatement(sql);
			ps.executeUpdate();
			c.commit();
			FabricaDeConexoes.fecharConexao(rs, ps, c);

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}

	}

	private static void criarTblProduto() {

		try {
			String sql = "CREATE TABLE tbl_produto (ID_Produto INTEGER PRIMARY KEY AUTOINCREMENT, "
					+ "Nome TEXT NOT NULL UNIQUE, " + "Valor REAL NOT NULL)";

			c = FabricaDeConexoes.abrirConexao();
			ps = c.prepareStatement(sql);
			ps.executeUpdate();
			c.commit();
			FabricaDeConexoes.fecharConexao(rs, ps, c);

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}

	}

	private static void criarTblPizzaPedido() {

		try {
			String sql = "CREATE TABLE tbl_pizza_pedido (ID_Pizza INTEGER NOT NULL, " + "ID_Pedido INTEGER NOT NULL, "
					+ "Quantidade INTEGER NOT NULL, " + "FOREIGN KEY(ID_Pizza) REFERENCES tbl_pizza_pedido(ID_Pizza), "
					+ "FOREIGN KEY(ID_Pedido) REFERENCES tbl_pedido(ID_Pedido))";

			c = FabricaDeConexoes.abrirConexao();
			ps = c.prepareStatement(sql);
			ps.executeUpdate();
			c.commit();
			FabricaDeConexoes.fecharConexao(rs, ps, c);

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}

	}

	private static void criarTblPizzaMeioMeioPedido() {

		try {
			String sql = "CREATE TABLE tbl_pizza_meio_meio_pedido (ID_Pizza_Meio_Meio INTEGER NOT NULL, "
					+ "ID_Pedido INTEGER NOT NULL, " + "Quantidade INTEGER NOT NULL, "
					+ "FOREIGN KEY(ID_Pedido) REFERENCES tbl_pedido(ID_Pedido), "
					+ "FOREIGN KEY(ID_Pizza_Meio_Meio) REFERENCES tbl_pizza_meio_meio(ID_Pizza_Meio_Meio))";

			c = FabricaDeConexoes.abrirConexao();
			ps = c.prepareStatement(sql);
			ps.executeUpdate();
			c.commit();
			FabricaDeConexoes.fecharConexao(rs, ps, c);

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}

	}

	private static void criarTblPizzaMeioMeio() {

		try {
			String sql = "CREATE TABLE tbl_pizza_meio_meio (ID_Pizza_Meio_Meio INTEGER PRIMARY KEY AUTOINCREMENT, "
					+ "Nome TEXT NOT NULL UNIQUE, " 
					+ "ID_Sabor_Primario INTEGER NOT NULL, "
					+ "ID_Sabor_Secundario INTEGER NOT NULL, "
					+ "FOREIGN KEY(ID_Sabor_Secundario) REFERENCES tbl_sabor_secundario(ID_Sabor_Secundario), "
					+ "FOREIGN KEY(ID_Sabor_Primario) REFERENCES tbl_sabor_primario(ID_Sabor_Primario))";

			c = FabricaDeConexoes.abrirConexao();
			ps = c.prepareStatement(sql);
			ps.executeUpdate();
			c.commit();
			FabricaDeConexoes.fecharConexao(rs, ps, c);

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}

	}

	private static void criarTblPizza() {

		try {
			String sql = "CREATE TABLE tbl_pizza (ID_Pizza INTEGER PRIMARY KEY AUTOINCREMENT, "
					+ "Nome TEXT NOT NULL UNIQUE, " + "ID_Sabor_Primario INTEGER NOT NULL, "
					+ "FOREIGN KEY(ID_Sabor_Primario) REFERENCES tbl_sabor_primario(ID_Sabor_Primario))";

			c = FabricaDeConexoes.abrirConexao();
			ps = c.prepareStatement(sql);
			ps.executeUpdate();
			c.commit();
			FabricaDeConexoes.fecharConexao(rs, ps, c);

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}

	}

	private static void criarTblPedido() {

		try {
			String sql = "CREATE TABLE tbl_pedido (ID_Pedido INTEGER PRIMARY KEY AUTOINCREMENT, "
					+ "ID_Cliente INTEGER NOT NULL, " + "ID_Funcionario INTEGER NOT NULL, "
					+ "Data_Pedido TEXT NOT NULL, " + "Obs_Pedido TEXT, " + "Is_Entrega INTEGER NOT NULL, "
					+ "Valor_Total REAL NOT NULL, " + "FOREIGN KEY(ID_Cliente) REFERENCES tbl_cliente(ID_Cliente), "
					+ "FOREIGN KEY(ID_Funcionario) REFERENCES tbl_funcionario(ID_Funcionario))";

			c = FabricaDeConexoes.abrirConexao();
			ps = c.prepareStatement(sql);
			ps.executeUpdate();
			c.commit();
			FabricaDeConexoes.fecharConexao(rs, ps, c);

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}

	}

	private static void criarTblNumero() {

		try {
			String sql = "CREATE TABLE tbl_numero (ID_Numero INTEGER PRIMARY KEY AUTOINCREMENT, "
					+ "Numero TEXT NOT NULL UNIQUE)";

			c = FabricaDeConexoes.abrirConexao();
			ps = c.prepareStatement(sql);
			ps.executeUpdate();
			c.commit();
			FabricaDeConexoes.fecharConexao(rs, ps, c);

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}

	}

	private static void criarTblFuncionario() {

		try {
			String sql = "CREATE TABLE tbl_funcionario (ID_Funcionario INTEGER PRIMARY KEY AUTOINCREMENT, "
					+ "Nome TEXT NOT NULL, " + "IS_Admin INTEGER NOT NULL, " + "Login TEXT NOT NULL, "
					+ "Senha TEXT NOT NULL)";

			c = FabricaDeConexoes.abrirConexao();
			ps = c.prepareStatement(sql);
			ps.executeUpdate();
			c.commit();
			FabricaDeConexoes.fecharConexao(rs, ps, c);

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}

	}

	private static void criarTblFormaPagamentoPedido() {

		try {
			String sql = "CREATE TABLE tbl_forma_pagamento_pedido (ID_Forma_Pagamento INTEGER NOT NULL, "
					+ "ID_Pedido INTEGER NOT NULL, "
					+ "FOREIGN KEY(ID_Forma_Pagamento) REFERENCES tbl_forma_pagamento(ID_Forma_Pagamento), "
					+ "FOREIGN KEY(ID_Pedido) REFERENCES tbl_pedido(ID_Pedido))";

			c = FabricaDeConexoes.abrirConexao();
			ps = c.prepareStatement(sql);
			ps.executeUpdate();
			c.commit();
			FabricaDeConexoes.fecharConexao(rs, ps, c);

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}

	}

	private static void criarTblFormaPagamento() {

		try {
			String sql = "CREATE TABLE tbl_forma_pagamento (ID_Forma_Pagamento INTEGER PRIMARY KEY AUTOINCREMENT, "
					+ "Forma_Pagamento TEXT NOT NULL UNIQUE)";

			c = FabricaDeConexoes.abrirConexao();
			ps = c.prepareStatement(sql);
			ps.executeUpdate();
			c.commit();
			FabricaDeConexoes.fecharConexao(rs, ps, c);

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}

	}

	private static void criarTblEnderecoPedido() {

		try {
			String sql = "CREATE TABLE tbl_endereco_pedido (ID_Bairro INTEGER NOT NULL, " + "ID_Rua INTEGER NOT NULL, "
					+ "ID_Numero INTEGER NOT NULL, " + "ID_Complemento INTEGER NOT NULL, "
					+ "ID_Pedido INTEGER NOT NULL, " + "FOREIGN KEY(ID_Pedido) REFERENCES tbl_pedido(ID_Pedido), "
					+ "FOREIGN KEY(ID_Complemento) REFERENCES tbl_complemento(ID_Complemento), "
					+ "FOREIGN KEY(ID_Numero) REFERENCES tbl_numero(ID_Numero), "
					+ "FOREIGN KEY(ID_Rua) REFERENCES tbl_rua(ID_Rua), "
					+ "FOREIGN KEY(ID_Bairro) REFERENCES tbl_bairro(ID_Bairro))";

			c = FabricaDeConexoes.abrirConexao();
			ps = c.prepareStatement(sql);
			ps.executeUpdate();
			c.commit();
			FabricaDeConexoes.fecharConexao(rs, ps, c);

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}

	}

	private static void criarTblEnderecoCliente() {

		try {
			String sql = "CREATE TABLE tbl_endereco_cliente (ID_Bairro INTEGER NOT NULL, " + "ID_Rua INTEGER NOT NULL, "
					+ "ID_Numero INTEGER NOT NULL, " + "ID_Complemento INTEGER NOT NULL, "
					+ "ID_Cliente INTEGER NOT NULL, " + "FOREIGN KEY(ID_Cliente) REFERENCES tbl_cliente(ID_Cliente), "
					+ "FOREIGN KEY(ID_Complemento) REFERENCES tbl_complemento(ID_Complemento), "
					+ "FOREIGN KEY(ID_Numero) REFERENCES tbl_numero(ID_Numero), "
					+ "FOREIGN KEY(ID_Rua) REFERENCES tbl_rua(ID_Rua), "
					+ "FOREIGN KEY(ID_Bairro) REFERENCES tbl_bairro(ID_Bairro))";

			c = FabricaDeConexoes.abrirConexao();
			ps = c.prepareStatement(sql);
			ps.executeUpdate();
			c.commit();
			FabricaDeConexoes.fecharConexao(rs, ps, c);

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}

	}

	private static void criarTblComplemento() {

		try {
			String sql = "CREATE TABLE tbl_complemento (ID_Complemento	INTEGER PRIMARY KEY AUTOINCREMENT, "
					+ "Complemento TEXT NOT NULL UNIQUE)";

			c = FabricaDeConexoes.abrirConexao();
			ps = c.prepareStatement(sql);
			ps.executeUpdate();
			c.commit();
			FabricaDeConexoes.fecharConexao(rs, ps, c);

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}

	}

	private static void criarTblCliente() {

		try {
			String sql = "CREATE TABLE tbl_cliente (ID_Cliente INTEGER PRIMARY KEY AUTOINCREMENT, "
					+ "Nome_Cliente TEXT NOT NULL)";

			c = FabricaDeConexoes.abrirConexao();
			ps = c.prepareStatement(sql);
			ps.executeUpdate();
			c.commit();
			FabricaDeConexoes.fecharConexao(rs, ps, c);

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}

	}

	private static void criarTblBairro() {

		try {
			String sql = "CREATE TABLE tbl_bairro (ID_Bairro INTEGER PRIMARY KEY AUTOINCREMENT, "
					+ "Bairro TEXT NOT NULL UNIQUE)";

			c = FabricaDeConexoes.abrirConexao();
			ps = c.prepareStatement(sql);
			ps.executeUpdate();
			c.commit();
			FabricaDeConexoes.fecharConexao(rs, ps, c);

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}

	}

}