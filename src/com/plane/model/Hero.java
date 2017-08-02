package com.plane.model;

import java.awt.image.BufferedImage;

import com.plane.layout.Layout;

public class Hero extends Fly {
	
	public static Hero h;
	
	protected int index = 0;

	int life = 3;
	private int doublefire = 0;
	protected BufferedImage[] images = {

	};
	private int score;

	public Hero(BufferedImage img, BufferedImage hero0, BufferedImage hero1) {
		this.image = img;
		images = new BufferedImage[] { hero0, hero1 };
		width = image.getWidth();
		hight = image.getHeight();

		x = Layout.WIDTH / 2 - (width / 2);
		y = Layout.HIGHT - 2 * hight;
		h = this;
	}
	
	public static Hero getH() {
		return h;
	}

	public int getLife() {
		return life;
	}

	public void setLife(int life) {
		this.life = life;
	}

	public int getDoublefire() {
		return doublefire;
	}

	public void setDoublefire(int doublefire) {
		this.doublefire = doublefire;
	}

	public BufferedImage[] getImages() {
		return images;
	}

	public void setImages(BufferedImage[] images) {
		this.images = images;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public void step() {
		if (images.length > 0) {
			image = images[index++ / 10 % images.length];
		}
	}

}
