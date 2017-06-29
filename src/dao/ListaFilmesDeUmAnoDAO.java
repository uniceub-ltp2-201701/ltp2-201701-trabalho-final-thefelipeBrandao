package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Filme;

public class ListaFilmesDeUmAnoDAO {
	
	private Connection conexao;

	
	public ListaFilmesDeUmAnoDAO(Connection conexao) {
		this.conexao = conexao;
	}
	
	
	public ArrayList<Filme> getFilmesDeUmAno(String ano) throws SQLException {
		ArrayList<Filme> filmes = new ArrayList<Filme>();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ps = conexao.prepareStatement("select distinct filme.id_filme, filme.nome_filme, filme.ano, filme.data_lancamento, filme.duracao, filme.sinopse, filme.avaliacao, filme.classificacao,filme.url_imagem,filme.votos "+
				 					  "from filme where ano like ? ORDER BY data_lancamento DESC");
		ps.setString(1, ano);
		
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
