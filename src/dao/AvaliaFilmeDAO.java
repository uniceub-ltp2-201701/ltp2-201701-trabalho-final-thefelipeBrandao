package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AvaliaFilmeDAO {
	
	private Connection conexao;
	
	
	public AvaliaFilmeDAO(Connection conexao) {
		this.conexao = conexao;
	}
	
	
	public boolean avaliarFilme(String idFilme,String nota) throws SQLException {
		PreparedStatement ps = null;
		boolean resultado = false;
		
		try {
			this.icrementaVoto(idFilme);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ps = conexao.prepareStatement("UPDATE filme SET avaliacao = ((avaliacao + ?) / votos) WHERE id_filme = ?");
		ps.setDouble(1, Double.parseDouble((nota)));
		ps.setInt(2, Integer.parseInt(idFilme));

		int resultUpdate = ps.executeUpdate();

		if (resultUpdate == 1) {
			resultado = true;
		}else
			resultado = false;
		
		
		return resultado;
	}
	
	
	private void icrementaVoto(String idFilme) throws SQLException {
		PreparedStatement ps = null;
		
		ps = conexao.prepareStatement("UPDATE filme SET votos = (votos + 1) WHERE id_filme = ?");
		ps.setInt(1, Integer.parseInt((idFilme)));
		
		ps.executeUpdate();
		
	}
	
}
