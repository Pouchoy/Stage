package javaPatternSingleton;

public class ProgramSingleton {

	public static void main(String[] args) {
		AppConfig cfg = AppConfig.getInstance();
		cfg.setLanguage("francais");
		cfg.setSaveDirectory("svg");
		
		AppConfig cfg2 = AppConfig.getInstance();
		System.out.println(cfg2.getLanguage());
		System.out.println(cfg2.getSaveDirectory());
	}

}
