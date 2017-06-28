package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdicionaIntegranteDAO {

	private Connection conexao;

	public AdicionaIntegranteDAO(Connection conexao) {
		this.conexao = conexao;
	}

	public boolean adicionarIntegrante(String nome, String genero, String biografia,String nascimento,String urlImagemIntegrante) throws SQLException {
		PreparedStatement ps = null;
		boolean resultadoFinal = false;
		
		ps = conexao.prepareStatement("INSERT INTO integrante(nome, genero, biografia, nascimento,url_imagem) VALUES (?,?,?,?,?)");
		ps.setString(1, nome);
		ps.setString(2, genero);
		ps.setString(3, biografia);
		ps.setString(4, nascimento);
		ps.setString(5, urlImagemIntegrante);
		
		int resultadoUpdate = ps.executeUpdate();
		if (resultadoUpdate == 1) {
			resultadoFinal = true;
		}else
			resultadoFinal = false;
		
		
		ps.close();
		
		return resultadoFinal;
	}

}
