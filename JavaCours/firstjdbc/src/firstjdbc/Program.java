package firstjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program {

	public static void main(String[] args) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/basetest1", "root", "");
				
				System.out.println("connexion réussie");
				
				Statement request = connection.createStatement();
				
				ResultSet rs = request.executeQuery("select id,titre from post");
				
				while(rs.next()){
					System.out.println("post d'id " + rs.getInt("id") + " et de titre '" + rs.getString("titre") + "'");
				}
				
				connection.close();
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
