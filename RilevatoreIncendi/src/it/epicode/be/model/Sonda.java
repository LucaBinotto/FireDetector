package it.epicode.be.model;

import java.util.ArrayList;

import it.epicode.be.observer.Subject;

public class Sonda extends Subject {
	
	public Sonda(String latitude, String longitude) {
		super();
		this.latitude=latitude;
		this.longitude=longitude;
		observers = new ArrayList<>();
		this.idSonda= ++sondaIDtracker;
	}

	
}
