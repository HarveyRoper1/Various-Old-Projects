import java.awt.Color;
import java.awt.Graphics;

public class Obstacle {

	private int x;
	private int y;
	
	private int width;
	private int height = 30;
	
	private double velX;
	private double velY;
	
	public Obstacle(int x, int y, int width, int velX, int velY) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.velX = velX;
		this.velY = velY;
	}
	
	public void render(Graphics g) {
		
		g.setColor(Color.CYAN);
		g.fillRect(x, y, width, height);
		
	}
	
	public void tick() {
		
		/*
		if(x < 0) {
			x = 0;
			velX = -velX;
		}
		else if(x > 640 - width) {
			x = 640 - width;
			velX = -velX;
		}
		else {
			x += velX;
		}
		
		if(y < 0) {
			y = 0;
			velY = -velY;
		}
		else if(y > (640/12*9) - height) {
			y  = (640/12*9) - height;
			velY = -velY;
		}
		else {
			y += velY;
		}
		
		*/
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	
}
