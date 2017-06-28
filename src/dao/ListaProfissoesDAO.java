package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Profissao;

public class ListaProfissoesDAO {
	
private Connection conexao;
	
	public ListaProfissoesDAO(Connection conexao){
		this.conexao = conexao;
	}
	
	public ArrayList<Profissao> getTodosAsProfissoes() throws SQLException {
		ArrayList<Profissao> profissoes = new ArrayList<Profissao>();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ps = conexao.prepareStatement("SELECT id_profissao, nome_profissao FROM profissao ORDER BY nome_profissao");
		
		rs = ps.executeQuery();
		
		while (rs.next()) {
			profissoes.add(new Profissao(rs.getInt("id_profissao"), rs.getString("nome_profissao")));
		}
				
		ps.close();
		rs.close();
		
		return profissoes;
	}

}
