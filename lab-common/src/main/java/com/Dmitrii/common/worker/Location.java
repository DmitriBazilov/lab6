package com.Dmitrii.common.worker;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * Местонахождение в 3-мерном пространстве.
 */
public class Location {

	private Double x;
	private long y;
	private int z;

	public Location() {
	}

	public Location(Double x, long y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public void setX(Double x) {
		this.x = x;
	}

	public void setY(long y) {
		this.y = y;
	}

	public void setZ(int z) {
		this.z = z;
	}
	
	public Double getX() {
		return x;
	}
	
	public long getY() {
		return y;
	}
	
	public int getZ() {
		return z;
	}
	
	public String toString() {
		return x.toString() + " " + Long.toString(y) + " " + Integer.toString(z);
	}
}
