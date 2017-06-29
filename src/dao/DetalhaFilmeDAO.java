package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Filme;
import model.Genero;
import model.Integrante;

public class DetalhaFilmeDAO {
	
	
	private Connection conexao;
	
	public  DetalhaFilmeDAO(Connection conexao) {
		this.conexao = conexao;
	}
	
	public Filme getFilme(String idFilme) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Filme filme = null;
		
		ps = conexao.prepareStatement("SELECT distinct filme.id_filme, filme.nome_filme, filme.ano, filme.data_lancamento, filme.duracao, filme.sinopse, filme.avaliacao, filme.classificacao, url_imagem, votos  from filme WHERE id_filme = ?");
		ps.setInt(1, Integer.parseInt(idFilme));
		rs = ps.executeQuery();
		
		while (rs.next()) {
			filme = new Filme(rs.getInt("id_filme"), rs.getString("nome_filme"),rs.getString("ano"),
					rs.getDate("data_lancamento"), rs.getInt("duracao"), rs.getString("sinopse"),
					rs.getDouble("avaliacao"), rs.getString("classificacao"),rs.getString("url_imagem"),rs.getInt("votos"));
		}
		
		ps.close();
		rs.close();
		
		return filme;
				
	}
	
	public ArrayList<Genero> getGenerosDoFilme (String idFilme) throws SQLException {
		ArrayList<Genero> generosDoFilme = new ArrayList<Genero>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ps = conexao.prepareStatement("SELECT distinct genero.id_genero, genero.nome FROM genero, filme_genero_integrante_profissao, filme where filme_genero_integrante_profissao.id_filme = ? and "+
									  "filme_genero_integrante_profissao.id_filme = filme.id_filme and "+
									  "genero.id_genero = filme_genero_integrante_profissao.id_genero ORDER BY genero.nome");
		ps.setInt(1, Integer.parseInt(idFilme));
		rs = ps.executeQuery();
		
		while (rs.next()) {
			generosDoFilme.add(new Genero(rs.getInt("id_genero"), rs.getString("nome")));
		}
		
		ps.close();
		rs.close();
		
		return generosDoFilme;
		
	}
	
	public ArrayList<Integrante> getIntegrantesDofilme(String idFilme) throws SQLException {
		ArrayList<Integrante> integrantesDoFilme = new ArrayList<Integrante>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ps = conexao.prepareStatement("SELECT distinct integrante.id_integrante, integrante.nome, integrante.genero, integrante.biografia, integrante.nascimento "+
									  "FROM integrante, filmes.filme_genero_integrante_profissao, filme WHERE filmes.filme_genero_integrante_profissao.id_filme = ? and " +
									  "integrante.id_integrante = filmes.filme_genero_integrante_profissao.id_integrante and "+
									  "filmes.filme_genero_integrante_profissao.id_filme = filme.id_filme ORDER BY integrante.nome");
		ps.setInt(1, Integer.parseInt(idFilme));
		
		rs = ps.executeQuery();
		
		while (rs.next()) {
			integrantesDoFilme.add(new Integrante(rs.getInt("id_integrante"), rs.getString("nome"),
					  rs.getString("genero"), rs.getString("biografia"),rs.getDate("nascimento")));
		}
		
		ps.close();
		rs.close();
		
		return integrantesDoFilme;
		
	}
	

}
