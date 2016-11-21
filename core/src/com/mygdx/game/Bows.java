package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Bows {
	private Texture bowImg;
	World world;;

	public Bows(World world) {
        bowImg = new Texture("Bow.png");
        this.world = world;

	}
	public void bowsRenderer(SpriteBatch batch) {
        batch.draw(bowImg, -10, -10, 0, 0, bowImg.getWidth()/2, bowImg.getHeight()/2, 1, 1, world.getRotation()-45, 1, 1, bowImg.getWidth(), bowImg.getHeight(), false, false);
	}
	
	public Texture getBowImg() {
		return bowImg;
	}
}
