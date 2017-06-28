package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AvaliaFilmeDAO {
	
	private Connection conexao;
	private int contador;
	
	public AvaliaFilmeDAO(Connection conexao) {
		this.conexao = conexao;
	}
	
	
	public boolean avaliarFilme(String idFilme, String nota) throws SQLException {
		PreparedStatement ps = null;
		boolean resultado = false;
		this.contador =+ contador;
		if(this.contador == 1){
		}
		ps = conexao.prepareStatement("UPDATE filme SET avaliacao = ((avaliacao + ?) / ?) WHERE id_filme = ?");
		ps.setDouble(1, Double.parseDouble((nota)));
		ps.setInt(2, this.contador);
		ps.setInt(3, Integer.parseInt(idFilme));

		int resultUpdate = ps.executeUpdate();

		if (resultUpdate == 1) {
			resultado = true;
		}else
			resultado = false;
		
		this.contador++;
		return resultado;
	}
	
	public int contador(int votos) {
		this.contador =  this.contador + votos;
		return this.contador;
	}
	
}
