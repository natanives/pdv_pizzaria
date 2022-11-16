package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import main.java.view.Main;
import model.dao.FabricaDeConexoes;

public class Funcionario {
	private int ID_Funcionario;
	private String Nome;
	private int IS_Admin;
	private String Login;
	private String Senha;

	private static Connection c = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs;

	public boolean existeAdminCadastrado() {
		boolean existeAdmin = false;

		try {
			String sql = "Select ID_Funcionario from tbl_funcionario where IS_Admin = 1";

			c = FabricaDeConexoes.abrirConexao();
			ps = c.prepareStatement(sql);
			rs = ps.executeQuery();

			if (rs.isClosed()) {
				System.out.println("Não há nenhum admin cadastrado");
			} else {
				existeAdmin = true;
			}
			FabricaDeConexoes.fecharConexao(rs, ps, c);

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}
		return existeAdmin;
	}

	public Funcionario validarLogin(String login, String senha) {
		Funcionario funcionario = new Funcionario();

		try {
			String sql = "Select * from tbl_funcionario where Login = ? and Senha = ?";

			c = FabricaDeConexoes.abrirConexao();
			ps = c.prepareStatement(sql);
			ps.setString(1, login);
			ps.setString(2, senha);
			rs = ps.executeQuery();

			if (rs.isClosed() == false) {
				funcionario.Nome = rs.getString("Nome");
				funcionario.IS_Admin = rs.getInt("IS_Admin");
				Main.setFuncionarioLogado(funcionario);
			} else {
				System.out.println("Registro não encontrado");
			}

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
		}

		FabricaDeConexoes.fecharConexao(rs, ps, c);
		return funcionario;
	}

	//TODO Deve ser feita uma verificação para que não seja cadasrado mais de um funcionário/admin
	//com um mesmo login.
	public int cadastrarPrimeiroAdmin(String nome, String login, String senha) {
		int row = 0;
		if (nome.isBlank() != true && login.isBlank() != true && senha.isBlank() != true) {
			try {
				String sql = "Insert into tbl_funcionario(Nome, Login, Senha, IS_Admin) values(?,?,?,?)";

				c = FabricaDeConexoes.abrirConexao();
				ps = c.prepareStatement(sql);
				ps.setString(1, nome);
				ps.setString(2, login);
				ps.setString(3, senha);
				ps.setInt(4, 1);
				row = ps.executeUpdate();
				c.commit();
				FabricaDeConexoes.fecharConexao(rs, ps, c);

			} catch (Exception e) {
				System.err.println(e.getClass().getName() + ": " + e.getMessage());
			}
		} else {
			System.out.println("Cadastro inválido");
		}
		return row;
	}

	//TODO Deve ser feita uma verificação para que não seja cadasrado mais de um funcionário/admin
	//com um mesmo login.
	public int cadastrarFuncAdmin(String nome, String login, String senha, int admin) {
		int row = 0;

		if (nome.isBlank() != true && login.isBlank() != true && senha.isBlank() != true) {
			try {
				String sql = "Insert into tbl_funcionario(Nome, Login, Senha, IS_Admin) values(?,?,?,?)";

				c = FabricaDeConexoes.abrirConexao();
				ps = c.prepareStatement(sql);
				ps.setString(1, nome);
				ps.setString(2, login);
				ps.setString(3, senha);
				ps.setInt(4, admin);
				row = ps.executeUpdate();
				c.commit();
				FabricaDeConexoes.fecharConexao(rs, ps, c);

			} catch (Exception e) {
				System.err.println(e.getClass().getName() + ": " + e.getMessage());
			}
		} else {
			System.out.println("Cadastro inválido");
		}

		return row;
	}

	public int getID_Funcionario() {
		return this.ID_Funcionario;
	}

	public String getNome() {
		return Nome;
	}

	public int getIS_Admin() {
		return this.IS_Admin;
	}

	public String getLogin() {
		return this.Login;
	}

	public String getSenha() {
		return this.Senha;
	}

}
