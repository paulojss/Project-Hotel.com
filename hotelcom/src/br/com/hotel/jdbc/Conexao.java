package br.com.hotel.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	public static Connection getConnection(){
		Connection connection = null;
		
		try {
			Class.forName("org.postgresql.Driver");//forca o carregamento do driver
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/hotelcom","postgres","postgres");
			System.out.println("conectado");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Erro de conexao com o bd!");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Driver nao encontrado!");
			e.printStackTrace();
		}
		
		return connection;
		
	}

}
