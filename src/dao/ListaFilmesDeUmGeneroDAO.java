package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Filme;
import model.Genero;

public class ListaFilmesDeUmGeneroDAO {
	
	private Connection conexao;
	
	public ListaFilmesDeUmGeneroDAO(Connection conexao) {
		this.conexao = conexao;
	}
	
	public ArrayList<Filme> getFilmesDeUmGenero(String idGenero) throws SQLException {
		ArrayList<Filme> filmes = new ArrayList<Filme>();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ps = conexao.prepareStatement("SELECT distinct filme.id_filme, filme.nome_filme, filme.ano, filme.data_lancamento, filme.duracao, filme.sinopse, filme.avaliacao, filme.classificacao,filme.url_imagem,filme.votos "+
						              "FROM filme_genero_integrante_profissao,filme, genero "+ 
									  "WHERE filme_genero_integrante_profissao.id_genero = ? and  filme_genero_integrante_profissao.id_filme = filme.id_filme and " +
									  "filme_genero_integrante_profissao.id_genero = genero.id_genero ORDER BY data_lancamento DESC");
		ps.setInt(1, Integer.parseInt(idGenero));
		
		rs = ps.executeQuery();
		
		while (rs.next()) {
			filmes.add(new Filme(rs.getInt("id_filme"), rs.getString("nome_filme"), rs.getString("ano"), 
					rs.getDate("data_lancamento"), rs.getInt("duracao"), rs.getString("sinopse"), 
					rs.getDouble("avaliacao"), rs.getString("classificacao"),rs.getString("url_imagem"),rs.getInt("votos")));
		}
		
		ps.close();
		rs.close();
		
		return filmes;
	}
	
	public Genero getGenero(String idGenero) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Genero genero = null;
		
		ps = conexao.prepareStatement("SELECT id_genero, nome FROM filmes.genero WHERE id_genero = ?");
		ps.setInt(1, Integer.parseInt(idGenero));
		
		rs = ps.executeQuery();
		
		while (rs.next()) {
			genero = new Genero(rs.getInt("id_genero"), rs.getString("nome"));
		}
		
		ps.close();
		rs.close();
		
		return genero;
	}
	

}
