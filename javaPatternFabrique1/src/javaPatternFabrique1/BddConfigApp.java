package javaPatternFabrique1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class BddConfigApp implements IConfigApp {

	private Map<String,String> values;
	private String urlBDD;
	private final static String NAME ="root";
	private final static String MDP ="";
	private PreparedStatement insertOneStatement;
	private PreparedStatement deleteTableStatement;
	private PreparedStatement selectLineStatement;
	private Connection connection;
	
	public static final String INSERT_ONE_SQL = "INSERT INTO design(nom,valeur) VALUES (?,?)";
	public static final String DELETE_TABLE_SQL = "DELETE FROM design";
	public static final String SELECT_LINE_SQL = "SELECT nom,valeur FROM design";
	
	public BddConfigApp(String urlBDD ){
		
		this.values = new HashMap<String,String>();
		this.urlBDD = urlBDD;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(urlBDD, NAME, MDP);
			selectLineStatement  =  connection.prepareStatement(SELECT_LINE_SQL);
			insertOneStatement   =  connection.prepareStatement(INSERT_ONE_SQL);
			deleteTableStatement =  connection.prepareStatement(DELETE_TABLE_SQL);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public String getConfigValue(String name) {
		return values.get(name);
	}

	@Override
	public void setConfigValue(String name, String value) {
		values.put(name, value);
	}

	@Override
	public void save() {
		try 
		{
			deleteTableStatement.executeUpdate();
			for(String cle : values.keySet())
			{
				insertOneStatement.clearParameters();
				insertOneStatement.setString(1, cle);
				insertOneStatement.setString(2, this.getConfigValue(cle));
				insertOneStatement.executeUpdate();
			}
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void load() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(urlBDD, NAME, MDP);
			ResultSet rst = selectLineStatement.executeQuery();
			while(rst.next())
			{
					setConfigValue(rst.getString("nom"), rst.getString("valeur"));
			}
			rst.close();
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
