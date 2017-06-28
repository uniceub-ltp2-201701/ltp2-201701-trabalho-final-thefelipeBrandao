package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Profissao;

public class DetalhaProfissaoDAO {
	
	private Connection conexao;
	
	public DetalhaProfissaoDAO(Connection conexao) {
		this.conexao = conexao;
	}
	
	public Profissao getProfissao(String idProfissao) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Profissao p = null;
		
		ps = conexao.prepareStatement("SELECT id_profissao, nome_profissao FROM filmes.profissao WHERE id_profissao = ?");
		ps.setInt(1, Integer.parseInt(idProfissao));
		
		rs = ps.executeQuery();
		
		while (rs.next()) {
			p = new Profissao(rs.getInt("id_profissao"), rs.getString("nome_profissao"));
		}
		
		ps.close();
		rs.close();
		
		return p;
	}

}
