package it.epicode.be.model;

import it.epicode.be.observer.Observer;
import it.epicode.be.observer.Subject;

public abstract class CentroDiControllo implements Observer  {

	protected int idSonda;
	protected String latitude;
	protected String longitude;
	protected int smokeLevel;
	
	private static final int TOLERANCE = 5;
	
	
	@Override
	public void update(Subject sonda) {
		this.smokeLevel=sonda.getSmokeLevel();
		this.idSonda=sonda.getIdSonda();
		this.latitude=sonda.getLatitude();
		this.longitude=sonda.getLongitude();
		if(smokeLevel>TOLERANCE) {
			setAlarm();
		}
	}

	public abstract void setAlarm();

	public int getSmokeLevel() {
		return smokeLevel;
	}
	
	
	
}
