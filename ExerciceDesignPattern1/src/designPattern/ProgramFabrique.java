package designPattern;

public class ProgramFabrique {

	public static void main(String[] args) {
		//AppFactory factory = new AppFactory();
		/*IConfigApp cfg = factory.BuildConfig("memory", "langage=francais;savedir=svg");
		//System.out.println(cfg.getConfigValue("langage"));
		
		IConfigApp cfg2 = factory.BuildConfig("textFile", "appcfg.txt");
		//System.out.println(cfg2.getConfigValue("langage"));
		
		IConfigApp cfg3 = factory.BuildConfig("BDD", "jdbc:mysql://localhost:3306/base_designpattern");
		cfg3.load();
		System.out.println(cfg3.getConfigValue("langage"));
		cfg3.setConfigValue("text28", "ISO-1988");
		cfg3.save();*/
		
		IConfigApp cfg4 = new DBSaveConfig.Builder("jdbc:mysql://localhost:3306/base_designpattern")
											.table("design")
											.build();
		cfg4.load();
		cfg4.setConfigValue("text38", "ISO-1998");
		/*cfg4.setConfigValue("langage", "francais");
		cfg4.setConfigValue("adresse", "3 rue de la porte");
		cfg4.setConfigValue("email", "toto@gmail.com");*/
		
		System.out.println(cfg4.getConfigValue("text37"));
		cfg4.save();
		}

}
