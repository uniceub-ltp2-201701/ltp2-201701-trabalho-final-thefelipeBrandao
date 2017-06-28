package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Integrante;

public class ListaIntegrantesDeUmaProfissaoDAO {
	
	private Connection conexao;
	
	public ListaIntegrantesDeUmaProfissaoDAO(Connection conexao) {
		this.conexao = conexao;
	}
	
	
	public ArrayList<Integrante> getIntegrantes(String idProfissao) throws SQLException {
		ArrayList<Integrante> integrantes = new ArrayList<Integrante>();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ps = conexao.prepareStatement("SELECT DISTINCT integrante.id_integrante, integrante.nome, integrante.genero, integrante.biografia, integrante.nascimento,integrante.url_imagem FROM "+ 
								      "filme_genero_integrante_profissao,filme, integrante, profissao WHERE filme_genero_integrante_profissao.id_profissao = ? AND "+
								 	  "filme_genero_integrante_profissao.id_integrante = integrante.id_integrante AND "+
								      "filme_genero_integrante_profissao.id_profissao = profissao.id_profissao ORDER BY integrante.nome");
		ps.setInt(1, Integer.parseInt(idProfissao));
		
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
