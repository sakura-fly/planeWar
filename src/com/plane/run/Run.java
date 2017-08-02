package com.plane.run;

import javax.swing.JFrame;

import com.plane.layout.Layout;
import com.plane.util.Contants;

public class Run {
	public static void main(String[] args) {
		JFrame frame = new JFrame(Contants.GAME_NAME);
		Layout game = new Layout();
		frame.add(game);
		frame.setSize(Layout.WIDTH, Layout.HIGHT);
		frame.setAlwaysOnTop(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setResizable(false);
		
		game.reaction();
	}
}
