import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;


public class Project5 extends JFrame implements ActionListener{
	
	Panel x;
	int t;
	public Project5() {
		this.setVisible(true);
		this.setSize(1280, 720);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		x = new Panel();
		x.generatePoints("car.in", Color.red);
		x.generatePoints("wheel.in", Color.black);
		x.generatePoints("wheel2.in", Color.black);
		x.generatePoints("cliff.in", new Color(140, 85, 51));
		this.add(x);
		t = 0;
		(new Timer(50, this)).start();
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		
		Project5 test = new Project5();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		x.setTime(t++);
		if (t >= 50) {
			t = 50;
		}
		x.repaint();
		
	}

}
