package com.plane.model;

import java.awt.image.BufferedImage;

public class Bullet extends Fly{
	
	
	public Bullet(BufferedImage img) {
		this.image = img;
		this.width = img.getWidth();
		this.hight = img.getHeight();
	}
	
	public Bullet(int x, int y,BufferedImage img) {
		this.x = x;
		this.y = y;
		this.image = img;
	}

	@Override
	public void step() {
		y -= ySpeed;
	}

}
