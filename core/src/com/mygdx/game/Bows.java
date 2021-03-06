package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Bows {
	private Texture bowImg;
	World world;
    private int rotation = 0;


	public Bows(World world) {
        bowImg = new Texture("Bow.png");
        this.world = world;

	}
	public void bowsRenderer(SpriteBatch batch) {
        batch.draw(bowImg, -10, -10, 0, 0, bowImg.getWidth()/2, bowImg.getHeight()/2, 1, 1, rotation-45, 1, 1, bowImg.getWidth(), bowImg.getHeight(), false, false);
	}
	
	public void setRotation() {
		if(Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)  && rotation>0){
    		rotation -= 10;
    	}
		else if(Gdx.input.isKeyJustPressed(Input.Keys.LEFT) && rotation<90){
    		rotation += 10;
    	}
	}
	public Texture getBowImg() {
		return bowImg;
	}
	
	public int getRotation() {
		return rotation;
	}
}
