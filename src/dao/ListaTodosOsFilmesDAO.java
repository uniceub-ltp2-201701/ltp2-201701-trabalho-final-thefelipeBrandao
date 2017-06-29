package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Filme;

public class ListaTodosOsFilmesDAO {
	
	private Connection conexao;
	
	public ListaTodosOsFilmesDAO(Connection conexao) {
		this.conexao = conexao;
	}
	
	public ArrayList<Filme> getTodosOsFilmes() throws SQLException {
		ArrayList<Filme> filmes = new ArrayList<Filme>();
		
		PreparedStatement ps = null;
		
		ResultSet rs = null;
		
		ps = conexao.prepareStatement("SELECT id_filme, nome_filme, ano, data_lancamento, duracao, sinopse, avaliacao, classificacao,url_imagem,votos FROM " +
									  "filmes.filme ORDER BY  data_lancamento desc");
		
		rs = ps.executeQuery();
		
		while (rs.next()) {
			filmes.add(new Filme(rs.getInt("id_filme"), rs.getString("nome_filme"), 
								 rs.getString("ano"), rs.getDate("data_lancamento"), rs.getInt("duracao"), 
								 rs.getString("sinopse"), rs.getDouble("avaliacao"), rs.getString("classificacao"),rs.getString("url_imagem"),rs.getInt("votos")));
		}
		
		ps.close();
		rs.close();
		
		return filmes;
	}
	
}
