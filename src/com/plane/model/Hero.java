package com.plane.model;

import java.awt.image.BufferedImage;

import com.plane.layout.Layout;

public class Hero extends Fly {
	
	protected int index = 0;

	int life = 3;
	private int doublefire = 0;
	protected BufferedImage[] images = {

	};

	public Hero(BufferedImage img, BufferedImage hero0, BufferedImage hero1) {
		this.image = img;
		images = new BufferedImage[] { hero0, hero1 };
		width = image.getWidth();
		hight = image.getHeight();

		x = Layout.WIDTH / 2 - (width / 2);
		y = Layout.HIGHT - 2 * hight;
	}

	@Override
	public void step() {
		if (images.length > 0) {
			image = images[index++ / 10 % images.length];
		}
	}

}
