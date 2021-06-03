package com.game.source.main;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.game.source.main.classes.EntityA;

public class Bullet extends GameObject implements EntityA{

	
	private Textures tex;
	private Game game;
	private Controller c;
	private Enemy e;
	private int collisions = 0;
	
	public Bullet(double x, double y, Textures tex, Game game, Controller c, Enemy e) {
		
		super(x,y);
		this.tex = tex;
		this.game = game;
		this.c = c;
		this.e = e;
	}
	
	public void tick() {
		y -= 5;
	
		
		if(Physics.Collision(this, game.eb)) {
			System.out.println(collisions);
			System.out.println("Collide");
	        if(game.getEnemy_killed() >= collisions) {
	        	System.out.println("A");
	            c.removeEntity(this);
	            c.removeEntity(e);
	            collisions++;
	            System.out.println(collisions);
            }
		}
	}
		
	public void render(Graphics g) {
		g.drawImage(tex.missile, (int)x, (int)y, null);
	}
	
	
	public double getY() {
		return y;
	}

	public double getX() {
		
		return x;
	}
	
	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 28, 28);
	}
}
