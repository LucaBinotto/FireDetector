package it.epicode.be.model;

public class CentroDiControlloSMS extends CentroDiControllo{

	@Override
	public void setAlarm() {
		System.out.println("#INVIOSMS#\nALLARME SCATTATO dalla sonda "+lastUpdatedSonda.getIdSonda()+"\nLATITUDINE "+lastUpdatedSonda.getLatitude()+"\nLONGITUDINE "+lastUpdatedSonda.getLongitude()+"\nLIVELLO DI FUMO "+lastUpdatedSonda.getSmokeLevel());
	}
}
