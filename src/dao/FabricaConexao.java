package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class FabricaConexao {
	
	private static Connection conn;
	
	public static Connection fazerConexao() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String strConn = "jdbc:mysql://localhost:3306/aula_dwc_2021_1";
			String user = "root";
			String pass = "root";
			
			conn = DriverManager.getConnection(strConn, user, pass);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return conn;
	}

}
