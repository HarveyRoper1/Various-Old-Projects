package com.game.source.main;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import com.game.source.main.classes.EntityB;

public class Enemy extends GameObject implements EntityB{

	Random r = new Random();
	
	private int speed = r.nextInt(4) + 2;
	
	private Game game;
	private Controller c;
	private Textures tex;   
	private Bullet b;

	
	public Enemy(double x, double y, Textures tex, Game game, Controller c, Bullet b) {
		super(x,y);
		this.tex = tex;
		this.game = game;
		this.c = c;
		this.b = b;

	}
	
	public void tick() {
		
		y += speed;
		
		if(y > 480) {
			speed = r.nextInt(4) + 1;
			x = r.nextInt(640);
			y = 0;
		}
		
		
		
	}
	
	
	public void render(Graphics g) {
		g.drawImage(tex.enemy, (int)x, (int)y, null);
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 32, 32);
			
	}
	
	
	public double getY() {
		return y;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	public double getX() {
		return x;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
}
