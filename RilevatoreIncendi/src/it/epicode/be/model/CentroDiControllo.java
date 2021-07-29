package it.epicode.be.model;

import it.epicode.be.observer.Observer;

public abstract class CentroDiControllo implements Observer  {

	protected int idSonda;
	protected String latitude;
	protected String longitude;
	protected int smokeLevel;
	
	private static final int tolerance = 5;
	
	
	@Override
	public void update(int smokeLevel,int idSonda, String latitude, String longitude) {
		this.smokeLevel=smokeLevel;
		this.idSonda=idSonda;
		this.latitude=latitude;
		this.longitude=longitude;
		if(smokeLevel>tolerance) {
			setAlarm();
		}
	}

	public void setAlarm() {
		System.out.println("http://host/alarm?=idsonda="+idSonda+"&lat="+latitude+"&lon="+longitude+"&smokelevel="+smokeLevel);

	}
	
}
