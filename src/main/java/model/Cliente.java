package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import model.dao.FabricaDeConexoes;

public class Cliente {
	private int ID_Cliente;
	private String Nome_Cliente;
	private String Bairro;
	private String Rua;
	private String Numero;
	private String Complemento;

	private static Connection c = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs;

	public static int cadastrarCliente(String nome, String telefone, String bairro, String rua, String numero,
			String complemento) {
		int row = 0;
		if (nome.isBlank() == false) {

			try {
				String sql = "Insert into tbl_cliente(Nome_Cliente) values(?) ";

				c = FabricaDeConexoes.abrirConexao();
				ps = c.prepareStatement(sql);
				ps.setString(1, nome);
				row = ps.executeUpdate();
				c.commit();
				FabricaDeConexoes.fecharConexao(rs, ps, c);

			} catch (Exception e) {
				System.err.println(e.getClass().getName() + ": " + e.getMessage());
			}
		} else {
			JOptionPane.showMessageDialog(null, "O cadastro de cliente deve conter ao menos nome do cliente.");
		}

		return row;
	}

	public int getID_Cliente() {
		return this.ID_Cliente;
	}

	public String getNome_Cliente() {
		return this.Nome_Cliente;
	}

	public String getBairro() {
		return this.Bairro;
	}

	public String getRua() {
		return this.Rua;
	}

	public String getNumero() {
		return this.Numero;
	}

	public String getComplemento() {
		return this.Complemento;
	}

	public static boolean isCadastrado(String nome, String telefone) {
		boolean cadastrado = false;

		// TODO tem que ajeitar isso aqui
		try {
			String sql = "Select * from tbl_cliente where Nome_Cliente like ? and Telefone_Cliente = ? ";

			c = FabricaDeConexoes.abrirConexao();
			ps = c.prepareStatement(sql);
			ps.setString(1, nome);
			ps.setString(2, telefone);
			rs = ps.executeQuery();

			if (rs.isClosed() == false) {
				cadastrado = true;
			} else {
				System.out.println("o resultSet está fechado");
			}

			FabricaDeConexoes.fecharConexao(rs, ps, c);

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}

		return cadastrado;
	}

}
