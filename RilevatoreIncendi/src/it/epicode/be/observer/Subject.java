package it.epicode.be.observer;

import java.util.ArrayList;

public class Subject {
	protected ArrayList<Observer> observers;
	protected static int sondaIDtracker =0;
	protected int idSonda;
	protected String latitude;
	protected String longitude;
	protected int smokeLevel;
	
	protected Subject() {}
	private Subject(int idSonda, String latitude, String longitude, int smokeLevel) {
		this.idSonda = idSonda;
		this.latitude = latitude;
		this.longitude = longitude;
		this.smokeLevel = smokeLevel;
	}

	public void register(Observer obs) {
		observers.add(obs);
	}

	public void unregister(Observer obs) {
		observers.remove(obs);
	}
	
	public void notifyObserver() {
		for (Observer obs : observers) {
			obs.update(new Subject(idSonda,latitude,longitude,smokeLevel));
		}
	}
	public int getIdSonda() {
		return idSonda;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public int getSmokeLevel() {
		return smokeLevel;
	}
	public void setSmokeLevel(int smokeLevel) {
		this.smokeLevel = smokeLevel;
		notifyObserver();
	}
	
	
	
}
