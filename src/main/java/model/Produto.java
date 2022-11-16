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

	// TODO Tem que ajeitar isso aqui.
	public int cadastrarProduto(String nome, double valor) {
		int row = 0;

		try {
			String sql = "Insert into tbl_produto(Nome, Valor) values(?,?)";

			c = FabricaDeConexoes.abrirConexao();
			ps = c.prepareStatement(sql);
			ps.setString(1, nome);
			ps.setDouble(2, valor);
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
					nomesCadastrados.add(rs.getString("nome"));
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
		
		/*
		 * TODO getTipoProdutoCadastrado()
		 * preciso do ID_Produto_cadastrado,
		 * 
		 * 
		 * 
		 */

		return tiposCadastrados;
	}

}
