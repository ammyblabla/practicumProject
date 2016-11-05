package com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class WorldRenderer {

	private ClearThisSky clearThisSky;
	private World world;
	private SpriteBatch batch;
	
	private Texture birdImg;
	private Texture planeImg;
	private Texture bowImg;
	private Texture arrowImg;
    private Texture BG;
    
	private BitmapFont fontScore;
	private BitmapFont fontTime;
	
	private int x;
	private int y;
	
	public WorldRenderer(ClearThisSky clearThisSky, World world) {
		this.clearThisSky = clearThisSky;
		this.world = world;
		this.batch = clearThisSky.batch;
		
		birdImg = new Texture("Bird.png");
		planeImg = new Texture("Plane.png");
		arrowImg = new Texture("Arrow_cut.png");
        bowImg = new Texture("Bow.png");
        BG = new Texture("BG.jpg");
        
		fontScore = new BitmapFont();
		fontTime = new BitmapFont();
	}
	
	public void render(float delta) {
		batch.begin();
		batch.draw(BG,-230,0);
        batch.draw(bowImg, -10, -10, 0, 0, bowImg.getWidth()/2, bowImg.getHeight()/2, 1, 1, world.getRotation()-45, 1, 1, bowImg.getWidth(), bowImg.getHeight(), false, false);
        targetRender(world.getBird(), birdImg);
        targetRender(world.getPlane(), planeImg);
        arrowRender(world.getArrow());
		fontScore.draw(batch, "Score: " + world.getScore(), clearThisSky.WIDTH * 2/3, clearThisSky.HEIGHT - 60);
		fontTime.draw(batch, "Time: " + world.getTime(), clearThisSky.WIDTH * 1/3, clearThisSky.HEIGHT - 60);
		batch.end();
	}
	
	private void targetRender(ArrayList<Target> arrayOfTarget, Texture img) {
		for (Target target : arrayOfTarget) {
			batch.draw(img, target.getPosition().x, target.getPosition().y);
		}
	}
	
	private void arrowRender(ArrayList<Arrow> arrayOfArrow) {
		for (Arrow arrow : arrayOfArrow) {
//			batch.draw(arrowImg, arrow.getPosition().x, arrow.getPosition().y, arrowImg.getWidth()/20, arrowImg.getHeight()/20, arrowImg.getWidth()/10, arrowImg.getHeight()/10, 1, 1, arrow.getRotation(), 1, 1, arrowImg.getWidth(), arrowImg.getHeight(), false, false);
			batch.draw(arrowImg, arrow.getPosition().x, arrow.getPosition().y, 0, 0, arrowImg.getWidth()/10, arrowImg.getHeight()/10, 1, 1, arrow.getRotation(), 1, 1, arrowImg.getWidth(), arrowImg.getHeight(), false, false);
		}
	}
}
