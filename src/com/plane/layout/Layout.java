package com.plane.layout;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.JLabel;

import com.plane.model.Bee;
import com.plane.model.Bullet;
import com.plane.model.Fly;
import com.plane.model.Hero;
import com.plane.model.Plane;

public class Layout extends JLabel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int index = 0;

	public static final int WIDTH = 400;
	public static final int HIGHT = 654;

	public BufferedImage backgroud;
	public BufferedImage start;
	public BufferedImage airplane;
	public BufferedImage bee;
	public BufferedImage bullet;
	public BufferedImage gameover;
	public BufferedImage hero0;
	public BufferedImage hero1;
	public BufferedImage pause;

	private List<Fly> flys = new ArrayList<>();
	private List<Bullet> bullets = new ArrayList<>();
	private Hero h;

	private int v = 10;

	public Layout() {
		try {
			// System.out.println("img" + File.separator + "background.png");
			backgroud = ImageIO.read(Layout.class.getResource("img" + File.separator + "background.png"));
			airplane = ImageIO.read(Layout.class.getResource("img" + File.separator + "airplane.png"));
			bee = ImageIO.read(Layout.class.getResource("img" + File.separator + "bee.png"));
			bullet = ImageIO.read(Layout.class.getResource("img" + File.separator + "bullet.png"));
			gameover = ImageIO.read(Layout.class.getResource("img" + File.separator + "gameover.png"));
			hero0 = ImageIO.read(Layout.class.getResource("img" + File.separator + "hero0.png"));
			hero1 = ImageIO.read(Layout.class.getResource("img" + File.separator + "hero1.png"));
			pause = ImageIO.read(Layout.class.getResource("img" + File.separator + "pause.png"));
			start = ImageIO.read(Layout.class.getResource("img" + File.separator + "start.png"));

			h = new Hero(hero0, hero0, hero1);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseMoved(MouseEvent e) {
				// System.out.println(e.getX() + "," + e.getY());
				h.setX(e.getX() - (h.getWidth() / 2));
				h.setY(e.getY() - (h.getHight() / 2));
			}

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(backgroud, 0, 0, null);
		paintHero(g);
		paintFlys(g);
	}

	private void paintFlys(Graphics g) {
		for(Fly f : flys){
			g.drawImage(f.getImage(), f.getX(), f.getY(), null);
		}
	}

	private void paintHero(Graphics g) {
		g.drawImage(h.getImage(), h.getX(), h.getY(), null);
	}

	public void reaction() {

		Timer timer = new Timer();
		timer.schedule(new TimerTask() {

			@Override
			public void run() {

				repaint();
				flyAction();
				stepAction();
				index++;
				System.out.println("flys num is : " + flys.size());
			}

		}, v, v);

	}

	private void flyAction() {
		if (index % 40 == 0) {
			flys.add(nextOne());
		}
	}

	private void stepAction() {
		for (Fly f : flys) {
			f.step();
			System.out.println("f" + f.getX() + "," + f.getY());
		}
		h.step();
	}

	private Fly nextOne() {
		// TODO Auto-generated method stub
		Random ran = new Random();

		int type = ran.nextInt(10);

		if (type == 0) {
			return new Bee(bee);
		} else {
			return new Plane(airplane);
		}

	}

}