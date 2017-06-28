package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdicionaFilmeGeneroDAO {
	
	private Connection conexao;
	
	public AdicionaFilmeGeneroDAO(Connection conexao) {
		this.conexao = conexao;
	}
	
	public boolean adicionarFilmeGenero(String idFilme, String idGenero) throws SQLException {
		PreparedStatement ps = null;
		boolean resultadoFinal = false;
		
		ps = conexao.prepareStatement("INSERT INTO filmes.filme_genero_integrante_profissao(id_filme,id_genero) VALUES(?,?)");
		ps.setInt(1, Integer.parseInt(idFilme));
		ps.setInt(2, Integer.parseInt(idGenero));
		
		
		
		int resultadoUpdate = ps.executeUpdate();
		if (resultadoUpdate == 1) {
			resultadoFinal = true;
		}else
			resultadoFinal = false;
		
		return resultadoFinal;
	}

}
