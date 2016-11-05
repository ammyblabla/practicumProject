package com.mygdx.game;

import java.util.Random;

import com.badlogic.gdx.math.Vector2;

public class Target {

	private Vector2 position;
	Random rand;
	private int x;
	private int y;
	
	public Target() {
		rand = new Random();
        position = new Vector2(rand.nextInt(ClearThisSky.WIDTH), rand.nextInt((ClearThisSky.HEIGHT*2/3)+ClearThisSky.HEIGHT*1/3));
    }    
 
    public void update() {
    	x = (rand.nextInt(3)-1)*20;
    	y = (rand.nextInt(3)-1)*20;
    	position.add(x,y);
    }
    
    public Vector2 getPosition() {
    	return position;
    }
}
