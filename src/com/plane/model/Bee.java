package com.plane.model;

import java.awt.image.BufferedImage;
import java.util.Random;

import com.plane.layout.Layout;

public class Bee extends Fly implements Award {

	public Bee(BufferedImage img) {
		image = img;
		width = img.getWidth();
		hight = img.getHeight();
		y = -hight;
		Random num = new Random();
		x = num.nextInt(Layout.WIDTH - width);
	}

	@Override
	public int getType() {
		// TODO Auto-generated method stub
		return (int) Math.round(2);
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
