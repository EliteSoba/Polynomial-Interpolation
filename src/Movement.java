import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Contains the same figure through multiple times
 *
 */
public class Movement {

	ArrayList<Figure> frames;
	Color c;
	Figure[] figs;
	
	public Movement(String in, Color c) {
		this.c = c;
		figs = new Figure[51];
		frames = new ArrayList<Figure>();
		generateFrames(in);
	}
	
	private void generateFrames(String input) {
		try {
			Scanner sc = new Scanner(new File(input));
			
			
			String line = sc.nextLine();
			while (sc.hasNext()) {
				int t = Integer.parseInt(line);
				if (t == -1) {
					return;
				}
				Figure f = new Figure(t);
				while ((line = sc.nextLine()).contains(" ")) {
					Scanner s = new Scanner(line);
					int x = s.nextInt();
					int y= s.nextInt();
					f.add(x, y);
					s.close();
				}
				
				frames.add(f);
			}
			sc.close();
		} catch (FileNotFoundException e) {
		}
		if (frames.size() > 1) {
			for (int i = 0; i < 51; i++) {
				figs[i] = new Figure(i);
			}
			for (int i = 0; i < frames.get(0).points.size(); i++) {
				interpolate(i);
			}
		}
		else {
			for (int i = 0; i < 51; i++) {
				figs[i] = frames.get(0);
			}
		}
	}
	
	public void interpolate(int p) {
		ArrayList<Point> points = new ArrayList<Point>();
		for (Figure f : frames) {
			points.add(f.points.get(p));
		}
		
		
		//Coef
		int n = points.size();
		double[] ax = new double[n];
		double[] ay = new double[n];
		
		for (int i = 0; i < n; i++) {
			ax[i] = points.get(i).x;
			ay[i] = points.get(i).y;
		}
		
		for (int j = 1; j < n ; j++) {
			for (int i = n-1; i >= j; i--) {
				ax[i] = ((ax[i] - ax[i-1])*1.0) / (frames.get(i).t - frames.get(i-j).t);
				ay[i] = ((ay[i] - ay[i-1])*1.0) / (frames.get(i).t - frames.get(i-j).t);
			}
		}
		
		
		for (int j = 0; j <= 50; j++) {
			double tempx = ax[n-1];
			double tempy = ay[n-1];
			for (int i = n-2; i >= 0; i--) {
				tempx = tempx * (j - frames.get(i).t) + ax[i];
				tempy = tempy * (j - frames.get(i).t) + ay[i];
			}
			figs[j].add((int)tempx, (int)tempy);
		}
		
	}
	
	public void paint(Graphics g, int t) {
//		if (figs[t] != null) {
			figs[t].draw(g, c);
//		}
	}
	
}
