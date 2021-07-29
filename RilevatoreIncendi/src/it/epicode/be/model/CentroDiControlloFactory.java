package it.epicode.be.model;

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
