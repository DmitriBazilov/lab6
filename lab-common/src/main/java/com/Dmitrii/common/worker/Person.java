package com.Dmitrii.common.worker;

/**
 *
 * Класс Человека.
 */
public class Person {

	private Integer weight;
	private Color eyeColor;
	private Color hairColor;
	private Location location;

	public Person() {
	}

	public Person(Integer weight, Color eyeColor, Color hairColor, Location location) {
		this.weight = weight;
		this.eyeColor = eyeColor;
		this.hairColor = hairColor;
		this.location = location;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setEyeColor(Color color) {
		this.eyeColor = color;	
	}

	public Color getEyeColor() {
		return eyeColor;
	}

	public void setHairColor(Color color) {
		this.hairColor = color;
	}

	public Color getHairColor() {
		return hairColor;
	}

	public void setLocation(Location loc) {
		location = loc;
	}

	public Location getLocation() {
		return location;
	}

	@Override
	public String toString() {
		return "Person{" + "weight=" + weight + ", eyeColor=" + eyeColor + ", hairColor=" + hairColor + ", location=" + location + '}';
	}
}
