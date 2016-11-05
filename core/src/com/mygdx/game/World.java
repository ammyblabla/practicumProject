package com.mygdx.game;

import java.util.TimerTask;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

import java.util.ArrayList;
import java.util.Timer;

public class World {

	public static final int TARET_CLOUD = 0;
	public static final int TARGET_BIRD = 1;
	public static final int TARGET_PLANE = 2;
	
	private ClearThisSky clearThisSky;
	private ArrayList<Arrow> arrow;
	private ArrayList<Target> bird;
	private ArrayList<Target> plane;
	private Timer mainTimer;
	private TimerTask mainTask;
	private TimerTask arrowTask;
	private int score;
	private int time;
	private int irotation = 1;
    private int rotation = 0;
    private int arrowTime;
    private int arrowRelease;
    private int x;
    private int y; //x=rcos0 y=rsin0 tan0=y/x r^2 = x^2+y^2 Math.cos(Math.toRadians(354))
	
	World(ClearThisSky clearThisSky) {
		arrow = new ArrayList<Arrow>();
		bird = new ArrayList<Target>();
		plane = new ArrayList<Target>();
		makeTimer();
		
		score = 0;
		time = 0;
		mainTimer.scheduleAtFixedRate(mainTask, 1000, 1000);
		mainTimer.scheduleAtFixedRate(arrowTask, 0, 350);
		genTarget(5, 3);
	}
	
	private void genTarget(int numBird, int numPlane) {
		for (int i = 0; i < numBird; i++) {
			bird.add(new Target(this));
		}
		for (int j = 0; j < numPlane; j++) {
			plane.add(new Target(this));
		}
	}
	
	private void makeTimer() {
		mainTimer = new Timer();
		mainTask = new TimerTask() {
			@Override
			public void run() {
				time++;
			}
		};
		arrowTask = new TimerTask() {
			@Override
			public void run() {
				arrowTime++;
			}
		};
	}
	
	private void setRotation() {
		if(rotation >= 90) {
    		irotation = -1;
    	}
    	else if(rotation <= 0) {
    		irotation = 1;
    	}
    	rotation += (irotation*2);
	}
	
	public void update(float delta) { //<-----------------------------------------update----------------------------------------
		setRotation();
		updateArrow();
		updateTarget();
		updateAttacked();
    	
		if(Gdx.input.isKeyPressed(Keys.SPACE) & arrowRelease != arrowTime) {
			arrowRelease = arrowTime;
    		arrow.add(new Arrow(rotation));
        }
	}
	
	public void updateArrow() {
		for (Arrow a : arrow) {
			a.update();
		}
	}
	
	public void updateTarget() {
		for (Target b : bird) {
			b.update();
		}
		for (Target p : plane) {
			p.update();
		}
	}
	
	public void updateAttacked() {
		boolean alreadyAttack = false;
		for (int a = 0; a < arrow.size(); a++) {
			for (int b = 0; b < bird.size(); b++) {
				if(isAttacked(arrow.get(a), bird.get(b))) {
					arrow.remove(a);
					bird.remove(b);
					increaseScore(TARGET_BIRD);
					alreadyAttack = true;
					break;
				}
			}
			for (int p = 0; p < plane.size() & !alreadyAttack; p++) {
				if(isAttacked(arrow.get(a), plane.get(p))) {
					arrow.remove(a);
					plane.remove(p);
					increaseScore(TARGET_PLANE);
					break;
				}
			}
		}
	}
	
	public boolean isAttacked(Arrow arrow, Target target) {
		int range = 40;
		if ((arrow.getPosition().x <= target.getPosition().x+range) & (arrow.getPosition().x >= target.getPosition().x-range) & (arrow.getPosition().y <= target.getPosition().y+range) & (arrow.getPosition().y >= target.getPosition().y-range)) {
			System.out.println("Attack!");
			return true;
		}
		return false;
	}
	
	public int getScore() {
		return score;
	}
	
	public void increaseScore(int TARGET) {
		score += TARGET;
	}
	
	public int getTime() {
		return time;
	}
	
	public int getRotation() {
		return rotation;
	}
	
	public ArrayList<Target> getBird() {
		return bird;
	}
	
	public ArrayList<Target> getPlane() {
		return plane;
	}
	
	public ArrayList<Arrow> getArrow() {
		return arrow;
	}
	
	public ClearThisSky getClearThisSky() {
		return clearThisSky;
	}
}
