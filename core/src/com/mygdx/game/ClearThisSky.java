package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ClearThisSky extends Game {
    public SpriteBatch batch;
    public static final int WIDTH = 1366; //1920;
    public static final int HEIGHT = 768; //1080;
    
    private GameScreen gameScreen;
 
    @Override
    public void create () {
    	batch = new SpriteBatch();
    	gameScreen = new GameScreen(this);
        setScreen(gameScreen);
    }
 
    @Override
    public void render () {
    	super.render();
    	if(gameScreen.gameEnd()) {
    		setScreen(new ScoreScreen(this, gameScreen.getWorld()));
    	}
    }
 
    @Override
    public void dispose () {
        batch.dispose();
    }
   
}