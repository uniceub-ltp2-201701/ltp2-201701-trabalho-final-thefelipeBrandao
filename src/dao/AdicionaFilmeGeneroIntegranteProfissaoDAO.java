package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdicionaFilmeGeneroIntegranteProfissaoDAO {
	
	private Connection conexao;
	
	public AdicionaFilmeGeneroIntegranteProfissaoDAO(Connection conexao) {
		this.conexao = conexao;		
	}
	
	public boolean adicionaFilmeIntegranteProfissao(String idFilme,String idIntegrante,String idProsissao) throws SQLException{
		PreparedStatement ps = null;
		boolean resultadoFinal = false;
		
		ps = conexao.prepareStatement("INSERT INTO filmes.filme_genero_integrante_profissao(id_filme,id_integrante,id_profissao) VALUES(?,?,?)");
		ps.setInt(1, Integer.parseInt(idFilme));
		ps.setInt(2, Integer.parseInt(idIntegrante));
		ps.setInt(3, Integer.parseInt(idProsissao));
		
		
		int resultadoUpdate = ps.executeUpdate();
		if (resultadoUpdate == 1) {
			resultadoFinal = true;
		}else
			resultadoFinal = false;
		
		return resultadoFinal;
		
		
	}
 
}
