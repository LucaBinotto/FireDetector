package it.epicode.be.factory;

import it.epicode.be.model.CentroDiControllo;
import it.epicode.be.model.CentroDiControlloHttp;
import it.epicode.be.model.CentroDiControlloSMS;
import it.epicode.be.model.InvalidResponseTypeException;

public class CentroDiControlloFactory {

	public CentroDiControllo creaCC(String responseType) throws InvalidResponseTypeException {
		if(responseType.equalsIgnoreCase("http")) {
			return new CentroDiControlloHttp();
		}else if(responseType.equalsIgnoreCase("sms")) {
			return new CentroDiControlloSMS();
		}else {
			throw new InvalidResponseTypeException();
		}
	}
}
