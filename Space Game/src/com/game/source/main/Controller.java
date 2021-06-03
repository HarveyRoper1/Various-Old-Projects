package com.game.source.main;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Random;

import com.game.source.main.classes.EntityA;
import com.game.source.main.classes.EntityB;


public class Controller {

	private LinkedList<EntityA> a = new LinkedList<EntityA>();
	private LinkedList<EntityB> b = new LinkedList<EntityB>();
	
	EntityA entA;
	EntityB entB;
	
	Random r = new Random();
	private Textures tex;
	private Game game;
	private Bullet bullet;

	
	public Controller(Textures tex, Game game) {
		
		this.game = game;
		this.tex = tex;
		
	}
	
	public void createEnemy(int enemy_count) {
		for(int i = 0; i < enemy_count; i++) {
			addEntity(new Enemy(r.nextInt(640), -10, tex, game, this, bullet));
		} 
	}
	
	
	public void tick() {
		//A CLASS
		for(int i = 0; i < a.size(); i++) {
			entA = a.get(i);
			
			entA.tick();
		}
		//B CLASS
		for(int i = 0; i < b.size(); i++) {
			entB = b.get(i);
			
			entB.tick();
		}
	
		
		
		
	}
	
	public void render(Graphics g) {
		//A CLASS
		for(int i = 0; i < a.size(); i++) {
			entA = a.get(i);
			
			entA.render(g);
		}
		//B CLASS
		for(int i = 0; i < b.size(); i++) {
			entB = b.get(i);
			
			entB.render(g);
		}
	}
	
	public void addEntity(EntityA block) {
		a.add(block);
	}

	
	public void removeEntity(EntityA block) {
		a.remove(block);
	}
	
	public void addEntity(EntityB block) {
		b.add(block);
	}

	
	public void removeEntity(EntityB block) {
		b.remove(block);
	}
	
	public LinkedList<EntityA> getEntityA(){
		return a;
	}
	public LinkedList<EntityB> getEntityB(){
		return b;
	}
	}
	
