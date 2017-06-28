package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ExcluiIntegranteDAO {
	
	private Connection conexao;

	
	public ExcluiIntegranteDAO(Connection conexao) {
		this.conexao = conexao;
	}
	
	
	//Primeiro excluo as relacoes do filme na tabela de relacionamento
		public boolean excluirIntegranteTabelaRelacao(String idIntegrante) throws SQLException {
			PreparedStatement ps = null;

			boolean resultado = false;

			ps = conexao.prepareStatement("DELETE FROM filmes.filme_genero_integrante_profissao WHERE filmes.filme_genero_integrante_profissao.id_Integrante = ?");
			ps.setInt(1, Integer.parseInt(idIntegrante));

			int resultUpdate = ps.executeUpdate();

			if (resultUpdate == 1) {
				resultado = true;
			}else
				resultado = false;

			
			ps.close();
			
			return resultado;
		}
		
		// depois excluo o filme na tabela filme
		public boolean excluirIntegrante(String idIntegrante) throws SQLException {
			PreparedStatement ps = null;

			boolean resultado = false;

			ps = conexao.prepareStatement("DELETE FROM integrante WHERE id_integrante = ?");
			ps.setInt(1, Integer.parseInt(idIntegrante));

			int resultUpdate = ps.executeUpdate();

			if (resultUpdate == 1) {
				resultado = true;
			}else
				resultado = false;

			
			
			ps.close();
			
			return resultado;
		}
	
}
