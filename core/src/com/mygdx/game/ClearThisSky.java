package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ClearThisSky extends Game {
    public SpriteBatch batch;
    public static final int WIDTH = 1366; //1920;
    public static final int HEIGHT = 768; //1080;
 
    @Override
    public void create () {
    	batch = new SpriteBatch();
        setScreen(new GameScreen(this));
    }
 
    @Override
    public void render () {
    	super.render();
    }
 
    @Override
    public void dispose () {
        batch.dispose();
    }
}