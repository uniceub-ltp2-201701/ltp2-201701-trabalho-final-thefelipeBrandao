package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Filme;
import model.Integrante;
import model.Profissao;

public class DetalhaIntegranteDAO {
	
	private Connection conexao;
	
	public DetalhaIntegranteDAO(Connection conexao){
		this.conexao = conexao;
	}
	
	public Integrante getIntegrante(String idIntegrante) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Integrante integrante = null;
		
		
		ps = conexao.prepareStatement("SELECT id_integrante, nome, genero, biografia, nascimento,url_imagem FROM filmes.integrante WHERE id_integrante = ?");
		ps.setInt(1, Integer.parseInt(idIntegrante));
		
		rs = ps.executeQuery();
		
		while (rs.next()) {
			integrante = new Integrante(rs.getInt("id_integrante"), rs.getString("nome"), 
					rs.getString("genero"), rs.getString("biografia"), rs.getDate("nascimento"),rs.getString("url_imagem"));
		}
		
		ps.close();
		rs.close();
		
		return integrante;
				
	}
	
	
	public ArrayList<Profissao> getProfissoesDoIntegrante(String idIntegrante) throws SQLException {
		ArrayList<Profissao> profissoes = new ArrayList<Profissao>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ps = conexao.prepareStatement("SELECT distinct profissao.id_profissao,profissao.nome_profissao FROM profissao,filmes.filme_genero_integrante_profissao, filme, integrante "+
				"WHERE filmes.filme_genero_integrante_profissao.id_integrante = ? and filmes.filme_genero_integrante_profissao.id_profissao = profissao.id_profissao and "+
				"filmes.filme_genero_integrante_profissao.id_integrante = integrante.id_integrante");
		ps.setInt(1, Integer.parseInt(idIntegrante));
		
		
		rs = ps.executeQuery();
		
		while (rs.next()) {
			profissoes.add(new Profissao(rs.getInt("id_profissao"), rs.getString("nome_profissao")));
		}
		
		ps.close();
		rs.close();
		
		return profissoes;
				
	}
	
	
	public ArrayList<Filme> getFilmesDoIntegrante(String idIntegrante) throws SQLException {
		ArrayList<Filme> filmes = new ArrayList<Filme>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ps = conexao.prepareStatement("SELECT distinct filme.id_filme, filme.nome_filme, filme.ano, filme.data_lancamento, filme.duracao, filme.sinopse, filme.avaliacao, filme.classificacao FROM "+ 
				"filme_genero_integrante_profissao,filme, integrante WHERE filme_genero_integrante_profissao.id_integrante = ? "+
				"and filmes.filme_genero_integrante_profissao.id_integrante = integrante.id_integrante and "+ 
				"filmes.filme_genero_integrante_profissao.id_filme = filme.id_filme");
		ps.setInt(1, Integer.parseInt(idIntegrante));
		
		
		rs = ps.executeQuery();
		
		while (rs.next()) {
			filmes.add(new Filme(rs.getInt("id_filme"), rs.getString("nome_filme"), rs.getString("ano"), 
					rs.getDate("data_lancamento"),rs.getInt("duracao"), rs.getString("sinopse"), 
					rs.getDouble("avaliacao"), rs.getString("classificacao")));
		}
		
		ps.close();
		rs.close();
		
		return  filmes;
				
	}
	
}
