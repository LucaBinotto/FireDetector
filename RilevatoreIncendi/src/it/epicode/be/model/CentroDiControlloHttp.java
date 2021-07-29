package it.epicode.be.model;

public class CentroDiControlloHttp extends CentroDiControllo{

	@Override
	public void setAlarm() {
		System.out.println("Chiamata rest a http://host/alarm?=idsonda="+idSonda+"&lat="+latitude+"&lon="+longitude+"&smokelevel="+smokeLevel);
	}
	
	
	
}
