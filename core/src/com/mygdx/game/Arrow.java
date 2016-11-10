package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

public class Arrow {
	
	private Vector2 position;
	private int rotation;
	private float x;
	private float y;
	 
    public Arrow(int rotation) {
    	this.rotation = rotation;
    	x = (float) (160*Math.cos(Math.toRadians(rotation)));
    	y = (float) (160*Math.sin(Math.toRadians(rotation)));
        position = new Vector2(x, y);
    }    
 
    public void update() {
    	x = (float) (15*Math.cos(Math.toRadians(rotation)));
    	y = (float) (15*Math.sin(Math.toRadians(rotation)));
    	position.add(x,y);    
    }
    
    public Vector2 getPosition() {
    	return position;
    }
    
    public int getRotation() {
    	return rotation;
    }
    
    public boolean disappear() {
    	if (position.x >= ClearThisSky.WIDTH | position.y >= ClearThisSky.HEIGHT) {
    		return true;
    	}
    	return false;
    }
}
