package model.dao;

import java.sql.*;

public class FabricaDeConexoes {
	private static Connection c = null;

	public static Connection abrirConexao() {
		try {
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:.pdvpizzaria.db");
			c.setAutoCommit(false);
			System.out.println("conexão aberta com sucesso!");
			return c;

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
		return c;
	}
	
	public static void fecharConexao(ResultSet rs, PreparedStatement ps, Connection c) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (c != null) {
				c.close();
			}
			System.out.println("Conexão fechada");
		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		}
	}
}
