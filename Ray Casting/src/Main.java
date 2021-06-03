import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;
import java.awt.image.BufferStrategy;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.JFrame;

public class Main implements Runnable, MouseMotionListener{
	
	
	private static final int WIDTH = 1200, HEIGHT = 1200;
	private static final int numLines = 12;
	
	private int mx = 0;
	private int my = 0;
	
	private Canvas canvas;
	
	private Random r = new Random();
	
	private LinkedList<Line2D.Float> lines;
	
	public Main() {
		lines = buildLines();
		
		JFrame frame = new JFrame("Ray Casting");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(canvas = new Canvas());
		canvas.addMouseMotionListener(this);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setBounds(10,10,WIDTH,HEIGHT);
		new Thread(this).start();
	}
	
	public void run() {
		while(true) {
			render();
		}
		
	}
	
	public LinkedList<Line2D.Float> buildLines() {
		LinkedList<Line2D.Float>lines = new LinkedList<>();
		for(int i = 0; i < numLines; i++) {
			
			int x1 = r.nextInt(800);
			int y1 = r.nextInt(800);
			int x2 = r.nextInt(800);
			int y2 = r.nextInt(800);
			
			lines.add(new Line2D.Float(r.nextInt(WIDTH),r.nextInt(HEIGHT),r.nextInt(WIDTH),r.nextInt(HEIGHT)));
		}
		return lines;
	}
	
	public void render() {
		BufferStrategy bs = canvas.getBufferStrategy();
		if(bs == null) {
			canvas.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		///
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
		
		for(Line2D.Float line : lines) {
			g.setColor(Color.white);
			g.drawLine((int)line.x1, (int)line.y1, (int)line.x2, (int)line.y2);
		}
		
		
		LinkedList<Line2D.Float> rays = calcRays(lines, mx, my, 100, 3000);
		g.setColor(Color.WHITE);
		for(Line2D.Float ray : rays) {
			g.drawLine((int)ray.x1, (int)ray.y1, (int)ray.x2, (int)ray.y2);

		}
		///
		g.dispose();
		bs.show();
	}
	
	
	private LinkedList<Line2D.Float> calcRays(LinkedList<Line2D.Float> lines, int mx, int my, int resolution, int maxDist){
		LinkedList<Line2D.Float> rays = new LinkedList<>();
		
		for(int i = 0 ; i < resolution; i++) {
			double dir = (Math.PI*2) * (double) i / resolution;
			float minDist = maxDist;
			for(Line2D.Float line : lines) {
				float dist = getRayCast(mx, my, mx+(float) Math.cos(dir) * maxDist, my+(float) Math.sin(dir) * maxDist, line.x1, line.y1, line.x2, line.y2);
				if(dist < minDist && dist > 0) {
					minDist = dist;
				}
			}
			rays.add(new Line2D.Float(mx, my, mx+(float) Math.cos(dir) * minDist, my+(float) Math.sin(dir) * minDist));
		}
		return rays;
	}
	
	public static void main(String[] args) {
		new Main();
	}

	
	public static float dist(float x1, float y1, float x2, float y2) {
	    return (float) Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
	}

	public static float getRayCast(float p0_x, float p0_y, float p1_x, float p1_y, float p2_x, float p2_y, float p3_x, float p3_y) {
	    float s1_x, s1_y, s2_x, s2_y;
	    s1_x = p1_x - p0_x;
	    s1_y = p1_y - p0_y;
	    s2_x = p3_x - p2_x;
	    s2_y = p3_y - p2_y;

	    float s, t;
	    s = (-s1_y * (p0_x - p2_x) + s1_x * (p0_y - p2_y)) / (-s2_x * s1_y + s1_x * s2_y);
	    t = (s2_x * (p0_y - p2_y) - s2_y * (p0_x - p2_x)) / (-s2_x * s1_y + s1_x * s2_y);

	    if (s >= 0 && s <= 1 && t >= 0 && t <= 1) {
	        // Collision detected
	        float x = p0_x + (t * s1_x);
	        float y = p0_y + (t * s1_y);

	        return dist(p0_x, p0_y, x, y);
	    }

	    return -1; // No collision
	}

	public void mouseDragged(MouseEvent e) {
		mx = e.getX();
		my = e.getY();
	}

	public void mouseMoved(MouseEvent e) {
		mx = e.getX();
		my = e.getY();
	}
	
	
	
}
