package it.epicode.be.model;

public class CentroDiControlloSMS extends CentroDiControllo{

	@Override
	public void setAlarm() {
		System.out.println("#INVIOSMS#\nALLARME SCATTATO dalla sonda "+idSonda+"\nLATITUDINE "+latitude+"\nLONGITUDINE "+longitude+"\nLIVELLO DI FUMO "+smokeLevel);
	}
}
