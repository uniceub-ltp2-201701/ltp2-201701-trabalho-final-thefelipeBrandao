package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Integrante;

public class ListarIntegrantesDisponiveisDAO {

	private Connection conexao;
	
	public ListarIntegrantesDisponiveisDAO(Connection conexao){
		this.conexao = conexao;
	}
	
	public ArrayList<Integrante> getTodosOsIntegrantesDisponiveis(String idFilme) throws SQLException {
		ArrayList<Integrante> integrantes = new ArrayList<Integrante>();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ps = conexao.prepareStatement("select integrante.id_integrante, integrante.nome, integrante.genero, integrante.biografia, integrante.nascimento,integrante.url_imagem  from integrante where integrante.id_integrante not in "+ 
								 	  "(select filme_genero_integrante_profissao.id_integrante from filme_genero_integrante_profissao "+
								      "where filme_genero_integrante_profissao.id_filme = ? and "+
								 	  "filme_genero_integrante_profissao.id_integrante = integrante.id_integrante)ORDER BY integrante.nome");
		ps.setInt(1, Integer.parseInt(idFilme));
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
