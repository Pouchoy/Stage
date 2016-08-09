package javaPatternSingleton;

public class AppConfig {
	//cette variable de classe contiendra l'instance unique de notre configuration
	private static AppConfig instance;
	
	private String language;
	private String saveDirectory;
	
	
	
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getSaveDirectory() {
		return saveDirectory;
	}

	public void setSaveDirectory(String saveDirectory) {
		this.saveDirectory = saveDirectory;
	}

	public static AppConfig getInstance(){
		if(instance == null)
			instance = new AppConfig();
		return instance;
	}
	
	private AppConfig(){
		
	}
}
