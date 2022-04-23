package com.Dmitrii.common.worker;

import java.util.Comparator;

/**
 *
 * Координаты 2-мерного пространства.
 */
public class Coordinates implements Comparable<Coordinates>{

	private double x;
	private long y;

	public Coordinates() {
	}

	public Coordinates(double x, long y) {
		this.x = x;
		this.y = y;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(long y) {
		this.y = y;
	}
	
	public double getX() {
		return x;
	}
	
	public long getY() {
		return y;
	}

	@Override
	public int compareTo(Coordinates c) {
		return Comparator.comparing(Coordinates::getX).thenComparing(Coordinates::getY).compare(this, c);
	}
	
	@Override
	public String toString() {
		return "Coordinates{" + "x=" + x + ", y=" + y + '}';
	}

	
}
