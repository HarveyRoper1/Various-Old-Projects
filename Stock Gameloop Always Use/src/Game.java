import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.Timer;

public class Game extends Canvas implements Runnable, KeyListener, ActionListener {

	public static final long serialVersionUID = 1L;
	public static final int WIDTH = 320;
	public static final int HEIGHT = WIDTH / 12 * 9;
	public static final int SCALE = 2;
	public final String TITLE = "Game lol";
	
	private boolean running = false;
	private Thread thread;
	
	private boolean play = false;
	private int score = 0;
	private int totalBricks;
	private Timer timer;
	private int delay = 5;
	
	Graphics gr;
	private BufferedImage image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	
	private int playerX = 310;
	private int ballposX = 350;
	private int ballposY = 350;
	private int ballXdir = -1;
	private int ballYdir = -2;
	
	Random r = new Random();	
	
	Player player;
	Enemy enemy;
	
	Handler handler;
	
	
	public void init() {
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay, this);
		timer.start();
		
		player = new Player(200,200);
		enemy = new Enemy(player, 100,100);
		handler = new Handler();
		
		handler.createPlatform();
		
		}
	
	public synchronized void start() {
		if(running) {
			return;
	}
		running = true;
		thread = new Thread(this);
		thread.start();
		
	}
	
	
	
	private synchronized void stop() {
		if(!running) {
			return;
		}
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.exit(1);
	}
	
	
	
	public void run() {
		init();
		long lastTime = System.nanoTime();
		final double amountOfTicks =  60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		int updates = 0;
		int frames = 0;
		long timer = System.currentTimeMillis();
		
		
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			if(delta >= 1) {
				tick();
				updates++;
				delta--;
			}
			render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println(updates + " ticks, Fps " + frames);
				updates = 0;
				frames = 0;
			}
		}
		stop();
	}
	
	private void tick() {
		player.tick();
		handler.tick();
	}
	
	private void render() {
		
		BufferStrategy bs = this.getBufferStrategy();
		
		if(bs == null) {
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		/////////////////////////////
		
		g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		
		player.render(g);
		
		handler.render(g);
		
		/////////////////////////////
		g.dispose();
		bs.show();
		
	}



	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_RIGHT) {
			player.setVelX(5);
		}else if(key == KeyEvent.VK_LEFT) {
			player.setVelX(-5);
		}else if(key == KeyEvent.VK_DOWN) {
			player.setVelY(5);
		}else if(key == KeyEvent.VK_UP) {
			player.setVelY(-5);
		}
	}



	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_RIGHT) {
			player.setVelX(0);
		}else if(key == KeyEvent.VK_LEFT) {
			player.setVelX(0);
		}else if(key == KeyEvent.VK_DOWN){
			player.setVelY(2);
		}else if(key == KeyEvent.VK_UP){
			player.setVelY(2);
		} 
		
	}



	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	

}
