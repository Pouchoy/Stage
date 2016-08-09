package javaPatternFabrique1;

public class ProgramFabrique {

	public static void main(String[] args) {
		AppFactory factory = new AppFactory();
		IConfigApp cfg = factory.BuildConfig("memory", "langage=francais;savedir=svg");
		//System.out.println(cfg.getConfigValue("langage"));
		
		IConfigApp cfg2 = factory.BuildConfig("textFile", "appcfg.txt");
		//System.out.println(cfg2.getConfigValue("langage"));
		
		IConfigApp cfg3 = factory.BuildConfig("BDD", "jdbc:mysql://localhost:3306/base_designpattern");
		cfg3.load();
		System.out.println(cfg3.getConfigValue("langage"));
		cfg3.setConfigValue("text28", "ISO-1988");
		cfg3.save();
		
	}

}
