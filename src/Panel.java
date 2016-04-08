import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JPanel;


public class Panel extends JPanel {

	ArrayList<Movement> objs;
	int t;
	public Panel() {
		objs = new ArrayList<Movement>();
		t = 0;
	}
	
	public void generatePoints(String input, Color c) {
		objs.add(new Movement(input, c));
	}
	
	public void setTime(int time) {
		t = time;
		
	}
	
	public void paint(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, 1280, 720);
		//g.fillRect(0, 0, 100, 100);
		for (Movement obj : objs) {
//			for (int i = 0; i <= 50; i++) {
				obj.paint(g, t);
//			}
		}
	}
}
