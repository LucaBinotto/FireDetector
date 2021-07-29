package it.epicode.be;

import it.epicode.be.model.CentroDiControllo;
import it.epicode.be.model.CentroDiControlloFactory;
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

		s1.setSmokeLevel(6);
		s2.setSmokeLevel(9);
		s3.setSmokeLevel(8);
		
	}
}
