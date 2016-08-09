package designPattern;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class DBSaveConfig implements IConfigApp{

	private Map<String,String> values;
	private String classeDriver;
	private String url;
	private String login;
	private String password;
	private String table;
	private String columnkey;
	private String columnvalue;
	private Connection connection;
	
	
	private PreparedStatement insertOneStatement;
	private PreparedStatement deleteTableStatement;
	private PreparedStatement selectLineStatement;
	
	public DBSaveConfig(String classeDriver, String url, String login, String password, String table, String columnkey,
			String columnvalue) {
		super();

		if(this.login != null )
			this.classeDriver = classeDriver;
		else
			this.classeDriver = "com.mysql.jdbc.Driver";
		this.url = url;
		if(this.login != null)
			this.login = login;
		else
			this.login = "root";
		if(this.password != null)
			this.password = password;
		else
			this.password = "";
		if(this.table != null)
			this.table = table;
		else
			this.table = "design";
		if(this.columnkey != null)
			this.columnkey = columnkey;
		else
			this.columnkey = "cle";
		if(this.columnvalue != null)
			this.columnvalue = columnvalue;
		else
			this.columnvalue = "valeur";
		
		this.values = new HashMap<String,String>();
		this.columnvalue = columnvalue;
		this.columnkey = columnkey;
		try {
			Class.forName(classeDriver);
			connection = DriverManager.getConnection(this.url, this.login, this.password);
			selectLineStatement  =  connection.prepareStatement("SELECT " + columnkey + ", " + columnvalue + " FROM " + table );
			insertOneStatement   =  connection.prepareStatement("INSERT INTO " + table + "(" + columnkey + ", " + columnvalue +") VALUES (?,?)" );
			deleteTableStatement =  connection.prepareStatement("DELETE FROM " + table);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public String toString() {
		return "DBSaveConfig [classeDriver=" + classeDriver + ", url=" + url + ", login=" + login + ", password="
				+ password + ", table=" + table + ", columnkey=" + columnkey + ", columnvalue=" + columnvalue + "]";
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
			deleteTableStatement.clearParameters();
			deleteTableStatement.executeUpdate();
			for(String cle : values.keySet())
			{
				insertOneStatement.clearParameters();
				insertOneStatement.setString(1, cle);
				insertOneStatement.setString(2, this.getConfigValue(cle));
				insertOneStatement.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void load() {
		try {
			ResultSet rst = selectLineStatement.executeQuery();
			while(rst.next())
			{
					setConfigValue(rst.getString(columnkey), rst.getString(columnvalue));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	public static class Builder{
		private String classeDriver;
		private String url;
		private String login;
		private String password;
		private String table;
		private String columnkey;
		private String columnvalue;
	
		public Builder(String url)
		{
			this.url= url;
			this.classeDriver = "com.mysql.jdbc.Driver";
			this.login = "root";
			this.password = "";
			this.table = "design";
			this.columnkey = "nom";
			this.columnvalue= "valeur";
			
		}
		
		public Builder classeDriver(String classeDriver)
		{
			this.classeDriver= classeDriver;
			return this;
		}
		
		public Builder login(String login)
		{
			this.login= login;
			return this;
		}
		
		public Builder password(String password)
		{
			this.password= password;
			return this;
		}
		
		public Builder table(String table)
		{
			this.table= table;
			return this;
		}
		
		public Builder columnkey(String columnkey)
		{
			this.columnkey= columnkey;
			return this;
		}
		
		public Builder columnvalue(String columnvalue)
		{
			this.columnvalue= columnvalue;
			return this;
		}
		
		public DBSaveConfig build(){
			if(url == null )
				throw new RuntimeException(
						"DBSaveConfig doit avoir une url!");
			return new DBSaveConfig(classeDriver, url, login,  password,  table,  columnkey, columnvalue);
		}
	}
	
}
