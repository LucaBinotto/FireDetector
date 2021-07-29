package it.epicode.be.model;

import java.util.ArrayList;

import it.epicode.be.observer.Observer;
import it.epicode.be.observer.Subject;

public class Sonda implements Subject {
	private ArrayList<Observer> observers;
	private static int sondaIDtracker =0;
	private int idSonda;
	private String latitude;
	private String longitude;
	private int smokeLevel;

	public Sonda(String latitude, String longitude) {
		this.latitude=latitude;
		this.longitude=longitude;
		observers = new ArrayList<>();
		this.idSonda= ++sondaIDtracker;
	}

	@Override
	public void register(Observer obs) {
		observers.add(obs);
	}

	@Override
	public void unregister(Observer obs) {
		observers.remove(obs);
	}

	@Override
	public void notifyObserver() {
		for (Observer obs : observers) {
			obs.update(smokeLevel, idSonda, latitude, longitude);
		}
	}

	public void setSmokeLevel(int smokeLevel) {
		this.smokeLevel = smokeLevel;
		notifyObserver();
	}
}
