package com.plane.model;

import java.awt.image.BufferedImage;

import com.plane.layout.Layout;

public class Plane extends Fly implements Enemy {
	
	
	public Plane(BufferedImage img) {
		image = img;
		hight = img.getHeight();
		width = img.getWidth();
		y=-hight;
		x=(int)(Math.random()*(Layout.WIDTH-width));
	}

	private int scpre = 5;

	@Override
	public int getScore() {
		// TODO Auto-generated method stub
		return scpre;
	}

	@Override
	public void step() {
		x += xSpeed;
		y += ySpeed;
		if (x < 0) {
			xSpeed = -xSpeed;
		}
		if (x > Layout.WIDTH - width) {
			xSpeed = -xSpeed;
		}
	}

}
