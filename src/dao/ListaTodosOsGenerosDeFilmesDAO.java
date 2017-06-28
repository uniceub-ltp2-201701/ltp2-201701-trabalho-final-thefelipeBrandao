package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Genero;

public class ListaTodosOsGenerosDeFilmesDAO {

	private Connection conexao;
	
	public ListaTodosOsGenerosDeFilmesDAO(Connection conexao){
		this.conexao = conexao;
	}
	
	public ArrayList<Genero> getTodosOsGeneros() throws SQLException {
		ArrayList<Genero> generos = new ArrayList<Genero>();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ps = conexao.prepareStatement("SELECT id_genero, nome FROM genero ORDER BY nome");
		
		rs = ps.executeQuery();
		
		while (rs.next()) {
			generos.add(new Genero(rs.getInt("id_genero"), rs.getString("nome")));
		}
				
		ps.close();
		rs.close();
		
		return generos;
	}
}
