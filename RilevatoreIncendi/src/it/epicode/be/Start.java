package it.epicode.be;

import java.util.Random;

import it.epicode.be.factory.CentroDiControlloFactory;
import it.epicode.be.model.CentroDiControllo;
import it.epicode.be.model.InvalidResponseTypeException;
import it.epicode.be.model.Sonda;

public class Start {
	
	public static void main(String[] args) throws InvalidResponseTypeException {
		CentroDiControlloFactory fact = new CentroDiControlloFactory();
		
		CentroDiControllo uno = fact.creaCC("sms");
		Sonda s1 = new Sonda("41.902782", "12.597846");
		Sonda s2 = new Sonda("88.696969", "12.496366");
		Sonda s3 = new Sonda("66.000000", "12.456846");

		s1.register(uno);
		s2.register(uno);
		s3.register(uno);

		CentroDiControllo due = fact.creaCC("http");

		s1.register(due);
		s2.register(due);
		s3.register(due);
		
		Random x = new Random();
		
		int smokeLevel1 = x.nextInt(11);
		int smokeLevel2 = x.nextInt(11);
		int smokeLevel3 = x.nextInt(11);
		
		s1.setSmokeLevel(smokeLevel1);
		s2.setSmokeLevel(smokeLevel2);
		s3.setSmokeLevel(smokeLevel3);
		System.out.println();
		System.out.println("#INVIOSMS#\r\n"
				+ "ALLARME SCATTATO dalla sonda 1\r\n"
				+ "LATITUDINE 41.902782\r\n"
				+ "LONGITUDINE 12.597846\r\n"
				+ "LIVELLO DI FUMO 6");
		
	}
}
