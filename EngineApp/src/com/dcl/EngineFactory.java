package com.dcl;

//Object Creational Logic
//Factory Class/Utility class/ Helper Class
public class EngineFactory {

	public static Engine getEngine(String engine) {

		if(engine.equalsIgnoreCase("Petrol")) {
			return new Petrol();
		}
		else if(engine.equalsIgnoreCase("Diesel")) {
			return new Diesel();
		}
		else if(engine.equalsIgnoreCase("CNG")) {
			return new CNG();
		}
		else {
			System.out.println("No such type of engines available");
			return null;
		}
	}
}
