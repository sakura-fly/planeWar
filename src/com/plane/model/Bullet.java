package com.plane.model;

public class Bullet extends Fly{

	@Override
	public void step() {
		y -= ySpeed;
	}

}
