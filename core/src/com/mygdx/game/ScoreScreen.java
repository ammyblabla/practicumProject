package com.mygdx.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ScoreScreen extends ScreenAdapter {
	
	private SpriteBatch batch;
	private ClearThisSky clearThisSky;
	private BitmapFont scoreText;
	private Graphics g1;
	private int score;
	private Texture BG;
	
	public ScoreScreen(ClearThisSky clearThisSky, World world) {
		this.clearThisSky = clearThisSky;
		this.batch = clearThisSky.batch;
		BG = new Texture("BG.jpg");
		
//		anim1 a=new anim1();
//	    Graphics g1 = anim1.getGraphics();
		
		scoreText = new BitmapFont();
		score = world.getScore();
		scoreText.setColor(128, 128, 128, (float) 0.87);
		scoreText.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
		scoreText.getData().setScale(12);
//		scoreText.setFont(new Font("gnyrwn971.ttff", 1, 25));
//		scoreText.setColor(new Color(128, 0, 0));
	}
	
	@Override
    public void render(float delta) {
		Gdx.gl.glClearColor(10/255.0f, 15/255.0f, 230/255.0f, 1f); // Sets a Color to Fill the Screen with (RGB = 10, 15, 230), Opacity of 1 (100%)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); // Fills the screen with the selected color
        
		batch.begin();
		batch.draw(BG,-230,0);
		scoreText.draw(batch, "Your score: " + score, clearThisSky.WIDTH/2, clearThisSky.HEIGHT/2, 1, 1, false);
//		scoreText.draw
		batch.end();
	}

}
