import java.awt.Color;
import java.awt.Graphics;

public class Enemy {

	private double x;
	private double y;
	
	Player p;
	
	
	public Enemy(Player p, double x, double y) {
		this.p = p;
		this.x = x;
		this.y = y;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.fillOval((int)x, (int)y, 20, 20);
	}
	
	public void tick() {
		
	}
	
}
