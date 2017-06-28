package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Genero;

public class ListarGenerosDisponiveisDAO {

	
private Connection conexao;
	
	public ListarGenerosDisponiveisDAO(Connection conexao){
		this.conexao = conexao;
	}
	
	public ArrayList<Genero> getTodosOsGenerosDisponiveis(String idFilme) throws SQLException {
		ArrayList<Genero> generos = new ArrayList<Genero>();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		ps = conexao.prepareStatement("select distinct genero.id_genero, genero.nome from genero where genero.id_genero not in (select filme_genero_integrante_profissao.id_genero from filme_genero_integrante_profissao "+
									  "where filme_genero_integrante_profissao.id_filme = ? "+
									  "and genero.id_genero = filme_genero_integrante_profissao.id_genero)ORDER BY genero.nome");
		ps.setInt(1, Integer.parseInt(idFilme));
		rs = ps.executeQuery();
		
		while (rs.next()) {
			generos.add(new Genero(rs.getInt("id_genero"), rs.getString("nome")));
		}
				
		ps.close();
		rs.close();
		
		return generos;
	}
}
