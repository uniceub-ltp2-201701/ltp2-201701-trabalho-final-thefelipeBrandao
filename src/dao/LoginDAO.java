package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
	
	private Connection conexao;
	
	
	public LoginDAO(Connection conexao) {
		this.conexao = conexao;
	}
	
	public boolean testeLogin(String nome, String senha) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ps = conexao.prepareStatement("SELECT nome, senha FROM filmes.usuario WHERE nome = ? and senha = ?");
		ps.setString(1, nome);
		ps.setString(2, senha);
		
		rs = ps.executeQuery();
		
		if (rs.first()) {
			return true;
		} else {
			return false;
		}
	}

}
