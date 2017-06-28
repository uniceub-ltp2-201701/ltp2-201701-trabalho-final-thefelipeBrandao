package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ExcluiFilmeDAO {

	private Connection conexao;

	public ExcluiFilmeDAO(Connection conexao) {
		this.conexao = conexao;
	}

	//Primeiro excluo as relacoes do filme na tabela de relacionamento
	public boolean excluirFilmeGeneroIntegranteProfissao(String idFilme) throws SQLException {
		PreparedStatement ps = null;

		boolean resultado = false;

		ps = conexao.prepareStatement("DELETE FROM filmes.filme_genero_integrante_profissao WHERE filmes.filme_genero_integrante_profissao.id_filme = ?");
		ps.setInt(1, Integer.parseInt(idFilme));

		int resultUpdate = ps.executeUpdate();

		if (resultUpdate == 1) {
			resultado = true;
		}else
			resultado = false;

		return resultado;
	}
	
	// depois excluo o filme na tabela filme
	public boolean excluirFilme(String idFilme) throws SQLException {
		PreparedStatement ps = null;

		boolean resultado = false;

		ps = conexao.prepareStatement("DELETE FROM filme WHERE id_filme = ?");
		ps.setInt(1, Integer.parseInt(idFilme));

		int resultUpdate = ps.executeUpdate();

		if (resultUpdate == 1) {
			resultado = true;
		}else
			resultado = false;

		return resultado;
	}

}
