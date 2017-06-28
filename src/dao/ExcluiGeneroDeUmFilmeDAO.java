package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ExcluiGeneroDeUmFilmeDAO {
	
	private Connection conexao;
	
	public ExcluiGeneroDeUmFilmeDAO(Connection conexao) {
		this.conexao = conexao;
	}
	
	
	public boolean excluirGeneroDeUmFilme(String idFilme, String idGenero) throws SQLException {
		PreparedStatement ps = null;

		boolean resultado = false;

		ps = conexao.prepareStatement("DELETE FROM filmes.filme_genero_integrante_profissao WHERE filme_genero_integrante_profissao.id_filme = ? and filme_genero_integrante_profissao.id_genero = ?");
		ps.setInt(1, Integer.parseInt(idFilme));
		ps.setInt(2, Integer.parseInt(idGenero));
		
		
		
		int resultUpdate = ps.executeUpdate();

		if (resultUpdate == 1) {
			resultado = true;
		}else
			resultado = false;

		
		ps.close();
		
		return resultado;
	}
	

}
