package javaPatternFabrique1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TextConfigApp implements IConfigApp {

	private Map<String,String> values;
	private String configFileName;
	
	public TextConfigApp(String configFileName ){
		this.values = new HashMap<>();
		this.configFileName = configFileName;
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
		PrintWriter pw;
		try {
			pw = new PrintWriter(configFileName);
		
			for(String cle : values.keySet()){
				pw.println(cle + "=" + this.getConfigValue(cle));
			}
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void load() {
		try {
			Scanner reader = new Scanner( new File(configFileName));
			while(reader.hasNextLine())
			{
				String line = reader.nextLine();
				String[] champ = line.split("=");
				setConfigValue(champ[0], champ[1]);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
