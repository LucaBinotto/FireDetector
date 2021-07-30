package it.epicode.be.model;

public class CentroDiControlloHttp extends CentroDiControllo{

	@Override
	public void setAlarm() {
		System.out.println("Chiamata rest a http://host/alarm?=idsonda="+lastUpdatedSonda.getIdSonda()+"&lat="+lastUpdatedSonda.getLatitude()+"&lon="+lastUpdatedSonda.getLongitude()+"&smokelevel="+lastUpdatedSonda.getSmokeLevel());
	}
	
	
	
}
