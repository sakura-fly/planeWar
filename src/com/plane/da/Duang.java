package com.plane.da;

import com.plane.model.Fly;

public class Duang {
	public boolean daung(Fly h, Fly e) {
		int x = e.getX() + e.getWidth() / 2;
		int y = e.getY() + e.getHight() / 2;
		return x > h.getX() && y > h.getY() && x < (h.getX() + h.getWidth()) && y < (h.getY() + h.getHight());
	}
}
