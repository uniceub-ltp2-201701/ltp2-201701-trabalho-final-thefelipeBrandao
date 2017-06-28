package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Filme;

public class ListaFilmesDeUmaProfissaoDeUmIntegranteDAO {
	
	private Connection conexao;
	
	public ListaFilmesDeUmaProfissaoDeUmIntegranteDAO(Connection conexao) {
		this.conexao = conexao;
	}
	
	
	public ArrayList<Filme> getListaDeFilmes(String idIntegrante, String idProfissao) throws SQLException {
		ArrayList<Filme> filmes = new ArrayList<Filme>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ps = conexao.prepareStatement("SELECT distinct filme.id_filme, filme.nome_filme, filme.ano, filme.data_lancamento, filme.duracao, filme.sinopse, filme.avaliacao, filme.classificacao,filme.url_imagem FROM "+
										"filme_genero_integrante_profissao,filme, integrante, profissao WHERE filme_genero_integrante_profissao.id_profissao = ? AND "+
										"filmes.filme_genero_integrante_profissao.id_integrante = ? and filme_genero_integrante_profissao.id_profissao = profissao.id_profissao AND "+
										"filmes.filme_genero_integrante_profissao.id_integrante = integrante.id_integrante AND "+	
										"filmes.filme_genero_integrante_profissao.id_filme = filme.id_filme ORDER BY nome_filme");
		ps.setInt(1, Integer.parseInt(idProfissao));
		ps.setInt(2, Integer.parseInt(idIntegrante));
		
		rs = ps.executeQuery();
		
		while (rs.next()) {
			filmes.add(new Filme(rs.getInt("id_filme"), rs.getString("nome_filme"), 
					 rs.getString("ano"), rs.getDate("data_lancamento"), rs.getInt("duracao"), 
					 rs.getString("sinopse"), rs.getDouble("avaliacao"), rs.getString("classificacao"),rs.getString("url_imagem")));
		}
		
		ps.close();
		rs.close();
		
		return filmes;
		
	}

}
