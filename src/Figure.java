import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Polygon;
import java.util.ArrayList;

/**
 * Defines a figure at a particular point in time.
 *
 */
public class Figure {
	
	public ArrayList<Point> points;
	public int t;
	public Figure(int t) {
		points = new ArrayList<Point>();
		this.t = t;
	}
	
	public void add(int x, int y) {
		points.add(new Point(x, y));
	}
	
	public void draw(Graphics g, Color c) {
		g.setColor(c);
		
		if (points.size() == 1) {
			g.fillOval(points.get(0).x, 720-points.get(0).y, 10, 10);
		}
		else if (points.size() == 2) {
			g.drawLine(points.get(0).x, 720-points.get(0).y, points.get(1).x, 720-points.get(1).y);
		}
		else {
//			Point prev = points.get(points.size()-1);
			
			Polygon poly = new Polygon();
			
			
			for (Point p : points) {
				poly.addPoint(p.x, 720-p.y);
//				g.drawLine(prev.x, 720-prev.y, p.x, 720-p.y);
//				prev = p;
			}
			g.fillPolygon(poly);
		}
	}
	
}
