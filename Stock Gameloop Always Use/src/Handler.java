import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Handler {

	private boolean Spaced = false;
	
	ArrayList<Obstacle> obstacles = new ArrayList<>();

	Random r = new Random();
	
	private int i = 0;
	private int j = 0;
	
	public void tick() {
		for(Obstacle obs : obstacles) {
			obs.tick();
		}
	}
	
	public void render(Graphics g) {
		for(Obstacle obs : obstacles) {
			obs.render(g);
		}
	}
	
	public List<Obstacle> createRandomObstacles(){
		
		
		
	}
	
	
	public void createPlatform() {
		
		for(int i = 0 ; i < 5; i++) {
			
			obstacles.add(new Obstacle(r.nextInt(300), r.nextInt(300), r.nextInt(100)+150, r.nextInt(3) + 1, r.nextInt(3) + 1));
			
		}
		
		while(!Spaced) {
			for(Obstacle obs : obstacles) {
				i++;
				for(Obstacle obs2 : obstacles) {
					j++;
					if(i != j) {
						while(new Rectangle(obs.getX(), obs.getY(), obs.getWidth(), 30).intersects(new Rectangle(obs2.getX(), obs2.getY(), obs2.getWidth(), 30))) {
						obs.setX(r.nextInt(300));
						obs.setY(r.nextInt(300));
						}
					}
					Spaced = true;
				}
			}
		
		}
			
		}

}

