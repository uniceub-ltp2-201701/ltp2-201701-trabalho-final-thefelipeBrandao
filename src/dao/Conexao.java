package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

private static Connection conexao = null;
	
	public static Connection getConexao() throws ClassNotFoundException, SQLException {
		if(conexao == null){
			//referencia o driver de conexao
			Class.forName("com.mysql.jdbc.Driver");
			//pega as strings de conexao e realiza a conexao
			conexao = DriverManager.getConnection("jdbc:mysql://localhost/filmes", "root", "");
		}
		return conexao;	
	}
}
