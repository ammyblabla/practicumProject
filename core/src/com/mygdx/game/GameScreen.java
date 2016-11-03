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
	private Texture arrowImg;
    private Texture BG;
	private int x;
    private int y;
    private int rotation = 0;
    private int irotation = 1;
    private Arrow arrow;
	 
    public GameScreen(ClearThisSky clearThisSky) {
        this.clearThisSky = clearThisSky;
        
        arrowImg = new Texture("Arrow.png");
        bowImg = new Texture("Bow.png");
        BG = new Texture("BG.jpg");
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
        batch.draw(BG,0,0);
        batch.draw(bowImg, -10, -10, 0, 0, bowImg.getWidth()/2, bowImg.getHeight()/2, 1, 1, rotation-45, 1, 1, bowImg.getWidth(), bowImg.getHeight(), false, false);
        batch.draw(arrowImg, x, y, arrowImg.getWidth()/20, arrowImg.getHeight()/20, arrowImg.getWidth()/10, arrowImg.getHeight()/10, 1, 1, rotation, 1, 1, arrowImg.getWidth(), arrowImg.getHeight(), false, false);
        batch.end();
    }
    
    private void update(float delta) {
    	if(rotation >= 90) {
    		irotation = -1;
    	}
    	else if(rotation <= 0) {
    		irotation = 1;
    	}
    	rotation += (irotation*2);
    	
    	if(Gdx.input.isKeyPressed(Keys.SPACE)) {
    		arrow = new Arrow(x,y);
        }
    }
}
