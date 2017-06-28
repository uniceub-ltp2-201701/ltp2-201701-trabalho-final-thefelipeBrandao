package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ExcluiIntegranteDeUmFilmeDAO {
	
private Connection conexao;

	
	public ExcluiIntegranteDeUmFilmeDAO(Connection conexao) {
		this.conexao = conexao;
	}
	
	
	//Primeiro excluo as relacoes do filme na tabela de relacionamento
		public boolean excluirIntegranteDeUmFilme(String idFilme, String idIntegrante, String profissaoIntegrante) throws SQLException {
			PreparedStatement ps = null;

			boolean resultado = false;

			ps = conexao.prepareStatement("DELETE FROM filmes.filme_genero_integrante_profissao WHERE filme_genero_integrante_profissao.id_integrante = ? and filme_genero_integrante_profissao.id_filme = ? and "+
									"filme_genero_integrante_profissao.id_profissao = ?");
			ps.setInt(1, Integer.parseInt(idIntegrante));
			ps.setInt(2, Integer.parseInt(idFilme));
			ps.setInt(3, Integer.parseInt(profissaoIntegrante));
			
			
			int resultUpdate = ps.executeUpdate();

			if (resultUpdate == 1) {
				resultado = true;
			}else
				resultado = false;

			
			ps.close();
			
			return resultado;
		}

}
