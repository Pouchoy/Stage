package javaBuildJson;

import java.io.PrintWriter;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonWriter;

public class ProgramJson {

	public static void main(String[] args) {

		PrintWriter pw = new PrintWriter(System.out);
		
		//on instancie pas le JsonWriter
		JsonWriter jsonwriter = Json.createWriter(pw);
		
		/*** JSON -< javascript object notation
		 * pour un objet
		 * {
		 * 		attr1 : valeur1,
		 * 		attr2 : valeur2
		 * }
		 */
		JsonObjectBuilder builder1 = Json.createObjectBuilder();
		builder1.add("nom","courtalon")
				.add("prenom", "vincent")
				.add("solde", 1000000000)
				.add("email", "vincent.courtalon@gmail.com")
				.add("java", true);
		
		//build construit l'objet JSon
		JsonObject jobj1 = builder1.build();
		
		jsonwriter.writeObject(jobj1);
		/*** un tableau en Json
		 * [val3, val4, val5]
		 * 
		 * 
		 */
		JsonArrayBuilder builder2 = Json.createArrayBuilder();
		builder2.add("lundi").add("mardi").add("mercredi");
		
		JsonArray jarr1 = builder2.build();
		jsonwriter.writeArray(jarr1);
		jsonwriter.close();
		
	}

}
