package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen extends ScreenAdapter {

	private ClearThisSky clearThisSky;
	private Texture bowImg;
	private int x;
    private int y;
	 
    public GameScreen(ClearThisSky clearThisSky) {
        this.clearThisSky = clearThisSky;
        bowImg = new Texture("Bow.png");
        x = 100;
        y = 100;
    }
    
    @Override
    public void render(float delta) {
    	update(delta);
    	
    	Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT); //clean screen
    	
    	SpriteBatch batch = clearThisSky.batch;
        batch.begin();
        batch.draw(bowImg, x, y);
        batch.end();
    }
    
    private void update(float delta) {
    	if(Gdx.input.isKeyPressed(Keys.LEFT)) {
            x -= 10;
        }
        if(Gdx.input.isKeyPressed(Keys.RIGHT)) {
            x += 10;
        } 
    }
}
