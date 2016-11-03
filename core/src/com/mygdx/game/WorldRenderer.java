package com.mygdx.game;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class WorldRenderer {

	private ClearThisSky clearThisSky;
	private World world;
	private BitmapFont fontScore;
	private BitmapFont fontTime;
	
	public WorldRenderer(ClearThisSky clearThisSky, World world) {
		this.clearThisSky = clearThisSky;
		this.world = world;
		fontScore = new BitmapFont();
		fontTime = new BitmapFont();
	}
	
	public void render(float delta) {
		SpriteBatch batch = clearThisSky.batch;
		batch.begin();
		fontScore.draw(batch, "" + world.getScore(), 700, 60);
		fontTime.draw(batch, "" + world.getTime(), 700, 60);
		batch.end();
	}
}
