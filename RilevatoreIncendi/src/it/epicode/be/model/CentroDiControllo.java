package it.epicode.be.model;

import it.epicode.be.observer.Observer;
import it.epicode.be.observer.Subject;

public abstract class CentroDiControllo implements Observer  {

	protected Subject lastUpdatedSonda;
	
	
	private static final int TOLERANCE = 5;
	
	
	@Override
	public void update(Subject sonda) {
		this.lastUpdatedSonda=sonda;
		
		if(lastUpdatedSonda.getSmokeLevel()>TOLERANCE) {
			setAlarm();
		}
	}

	public abstract void setAlarm();

	public int getSmokeLevel() {
		return lastUpdatedSonda.getSmokeLevel();
	}
	
	
	
}
