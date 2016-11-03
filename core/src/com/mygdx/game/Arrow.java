package com.mygdx.game;

import com.badlogic.gdx.math.Vector2;

public class Arrow {
	
	private Vector2 position;
	 
    public Arrow(int x, int y) {
        position = new Vector2(x,y);
    }    
 
    public Vector2 getPosition() {
        return position;    
    }
}
