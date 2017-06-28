package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Integrante;

public class ListaTodosOsIntegrantesDAO {
	
private Connection conexao;
	
	public ListaTodosOsIntegrantesDAO(Connection conexao){
		this.conexao = conexao;
	}
	
	public ArrayList<Integrante> getTodosOsIntegrantes() throws SQLException {
		ArrayList<Integrante> integrantes = new ArrayList<Integrante>();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ps = conexao.prepareStatement("SELECT id_integrante, nome, genero, biografia, nascimento,url_imagem FROM filmes.integrante "+
									  "ORDER BY nome");
		
		rs = ps.executeQuery();
		
		while (rs.next()) {
			integrantes.add(new Integrante(rs.getInt("id_integrante"), rs.getString("nome"), 
										   rs.getString("genero"), rs.getString("biografia"), rs.getDate("nascimento"),rs.getString("url_imagem")));
		}
				
		ps.close();
		rs.close();
		
		return integrantes;
	}

}
