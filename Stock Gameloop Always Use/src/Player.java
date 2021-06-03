import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Player {

	
	private double x;
	private double y;
	private double velX;
	private double velY = 2;
	
	public Player(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public void tick() {
		
		x += velX;
		y += velY;
		
		if(x <= 0) {
			x = 0;
		}
		if(x >= 640- 20) {
			x = 640 - 20;
		}
		if(y <= 0 ) {
			y = 0;
		}
		if(y >= 480 - 32) {
			y = 480 - 32;
		}
		
		
	}
	
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillOval((int)x, (int)y, 20, 20);
	}
	
	
	public double getX() {
		return x;
	}
	public double getY() {
		return y;
	}
	public void setX(double x) {
		this.x = x;
	}
	public void setY(double y) {
		this.y = y;
	}
	
	public void setVelX(double velX) {
		this.velX = velX;
	}
	public void setVelY(double velY) {
		this.velY = velY;
	}

	public Rectangle getBounds() {
		
		return new Rectangle((int)x, (int)y, 28, 28);
		
	}
	
}
