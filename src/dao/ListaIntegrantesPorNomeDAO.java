package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Integrante;

public class ListaIntegrantesPorNomeDAO {


	private Connection conexao;

	public ListaIntegrantesPorNomeDAO(Connection conexao) {
		this.conexao = conexao;
	}


	public ArrayList<Integrante> getIntegrantes(String nomeIntegrante) throws SQLException {
		ArrayList<Integrante> integrantes = new ArrayList<Integrante>();
		PreparedStatement ps = null;
		ResultSet rs = null;

		ps = conexao.prepareStatement("SELECT  DISTINCT id_integrante, nome, genero, biografia, nascimento, url_imagem FROM "+ 
									  "integrante WHERE nome LIKE ? ORDER BY nome");
		ps.setString(1, "%"+nomeIntegrante+"%");

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
