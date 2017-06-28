package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AdicionaFilmeDAO {
	
	private Connection conexao;
	
	public AdicionaFilmeDAO(Connection conexao) {
		this.conexao = conexao;
	}
	
	
	public boolean adicionarFilme(String nomeFilme,String ano,String dataLancamento,String duracao,String sinopse,String avaliacao,String classificacao,String urlImagemFilme) throws SQLException {
		PreparedStatement ps = null;
		boolean resultadoFinal = false;
		
		ps = conexao.prepareStatement("INSERT INTO filme (nome_filme, ano, data_lancamento, duracao, sinopse, avaliacao, classificacao,url_imagem) VALUES(?,?,?,?,?,?,?,?)");
		ps.setString(1, nomeFilme);
		ps.setString(2, ano);
		ps.setString(3, dataLancamento);
		ps.setInt(4, Integer.parseInt(duracao));
		ps.setString(5, sinopse);
		ps.setDouble(6, Double.parseDouble(avaliacao));
		ps.setString(7, classificacao);
		ps.setString(8, urlImagemFilme);
		
		int resultadoUpdate = ps.executeUpdate();
		if (resultadoUpdate == 1) {
			resultadoFinal = true;
		}else
			resultadoFinal = false;
		
		return resultadoFinal;
		
	}
	
}
