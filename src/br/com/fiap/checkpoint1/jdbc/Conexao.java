package br.com.fiap.checkpoint1.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	
		public static Connection getConexao() {
			String jdbc = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				return DriverManager.getConnection(jdbc, "rm93039", "100104");			
			}
			catch(Exception e) {
				throw new RuntimeException(e);
			}
		
		
	}

		
	
}
