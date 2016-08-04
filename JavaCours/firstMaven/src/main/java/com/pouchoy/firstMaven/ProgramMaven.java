package com.pouchoy.firstMaven;

import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public class ProgramMaven {

	public static void main(String[] args) {
		System.out.println("Hello Maven");
		CSVFormat format = CSVFormat.DEFAULT.withDelimiter(';');
		try {
			FileWriter writer = new FileWriter("export.csv");
			CSVPrinter printer = new CSVPrinter(writer, format);
			printer.printRecord("chaise", 45.99, 2.5);
			printer.printRecord("bureau", 425.99, 8.5);
			printer.printRecord("lampe", 34.99, 0.85);
			printer.printRecord("stylo", 1.99, 0.008);
			printer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//CSVPrinter p = new CSVPrinter(arg0, arg1);
	}

}
