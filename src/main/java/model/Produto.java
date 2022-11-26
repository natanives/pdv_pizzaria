package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.dao.FabricaDeConexoes;

public class Produto extends ProdutoGenerico {
	private static ArrayList<String> nomesCadastrados;
	private static ArrayList<String> tiposCadastrados;
	private static Connection c = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs;

	public static int cadastraTipoProduto(String tipoProduto) {
		int row = 0;

		try {
			String sql = "Insert into tbl_Tipo_produto(Tipo_Produto) values(?)";

			c = FabricaDeConexoes.abrirConexao();
			ps = c.prepareStatement(sql);
			ps.setString(1, tipoProduto);
			row = ps.executeUpdate();
			c.commit();
			FabricaDeConexoes.fecharConexao(rs, ps, c);

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}

		return row;
	}

	public int cadastrarProduto(String nome, int idTipoProduto, double valor) {
		int row = 0;

		try {
			String sql = "Insert into tbl_produto(Nome, ID_Tipo_Produto,Valor) values(?,?)";

			c = FabricaDeConexoes.abrirConexao();
			ps = c.prepareStatement(sql);
			ps.setString(1, nome);
			ps.setInt(2, idTipoProduto);
			ps.setDouble(3, valor);
			row = ps.executeUpdate();
			c.commit();
			FabricaDeConexoes.fecharConexao(rs, ps, c);

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}

		return row;
	}

	public static ArrayList<String> getNomeProdutoCadastrado(String nome) {
		nomesCadastrados = new ArrayList<String>();

		try {
			String sql = "Select Nome from tbl_produto where Nome like ? ";

			c = FabricaDeConexoes.abrirConexao();
			ps = c.prepareStatement(sql);
			ps.setString(1, '%' + nome + '%');
			rs = ps.executeQuery();

			if (rs.isClosed() == false) {
				while (rs.next()) {
					nomesCadastrados.add(rs.getString("Nome"));
				}
			} else {
				System.out.println("Nenhum resultado encontrado");
			}
			FabricaDeConexoes.fecharConexao(rs, ps, c);

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
		return nomesCadastrados;
	}

	public static ArrayList<String> getTipoProdutoCadastrado(String tipo) {
		tiposCadastrados = new ArrayList<String>();

		try {
			String sql = "Select Tipo_Produto from tbl_tipo_produto where Tipo_Produto like ? ";

			c = FabricaDeConexoes.abrirConexao();
			ps = c.prepareStatement(sql);
			ps.setString(1, '%' + tipo + '%');
			rs = ps.executeQuery();

			if (rs.isClosed() == false) {
				while (rs.next()) {
					tiposCadastrados.add(rs.getString("Tipo_Produto"));
				}
			} else {
				System.out.println("Nenhum resultado encontrado");
			}
			FabricaDeConexoes.fecharConexao(rs, ps, c);

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
		return tiposCadastrados;
	}

}
