package com.example.servletjspdemo.domain;

public class Bike {
	
	private String Name = "unknown";
	private int wheel = 22;
	private String Frame = "steel";
	
	public Bike() {
		super();
	}
	
	public Bike(String Name, int wheel, String Frame) {
		super();
		this.Name = Name;
		this.wheel = wheel;
		this.Frame = Frame;

	}

	public String getName() {
		return Name;
	}
	public void setName(String Name) {
		this.Name = Name;
	}
	public int getwheel() {
		return wheel;
	}
	public void setwheel(int wheel) {
		this.wheel = wheel;
	}
	public String getFrame() {
		return Frame;
	}
	public void setFrame(String Frame) {
		this.Frame = Frame;
	}
}