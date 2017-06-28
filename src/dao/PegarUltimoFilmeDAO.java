package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PegarUltimoFilmeDAO {
	
	private Connection conexao;
	
	public PegarUltimoFilmeDAO(Connection conexao) {
		this.conexao = conexao;
	}
	
	
	public String getIDultimoFilme () throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String idFilme = "";
		
		ps = conexao.prepareStatement("SELECT MAX(id_filme) FROM filme");
		rs = ps.executeQuery();
		
		while (rs.next()) {
			idFilme = rs.getString("MAX(id_filme)");
		}
		
		ps.close();
		rs.close();
		
		return idFilme;
		
	}

}
