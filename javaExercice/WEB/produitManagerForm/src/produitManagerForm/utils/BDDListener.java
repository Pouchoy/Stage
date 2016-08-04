package produitManagerForm.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class BDDListener implements ServletContextListener {

	
	public BDDListener() {
		
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/base_produitmanager", "root", "");
			
			System.out.println("connexion réussie");
			
			//instanciation du produitDAO (auquel on forunit la conenction a la base)
			ProduitDAO produitdao = new ProduitDAO(connection);
			arg0.getServletContext().setAttribute("produitDAO", produitdao);
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}

}
