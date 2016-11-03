package com.mygdx.game;

import java.util.TimerTask;
import java.util.Timer;

public class World {

	public static final int TARET_CLOUD = 0;
	public static final int TARGET_BIRD = 1;
	public static final int TARGET_PLANE = 2;
	
	private ClearThisSky clearThisSky;
	private int score;
	private int time;
	
	World(ClearThisSky clearThisSky) {
		Timer myTimer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				time++;
				System.out.println(time);
			}
		};
		
		score = 0;
		time = 0;
		myTimer.scheduleAtFixedRate(task, 1000, 1000);
	}
	
	public int getScore() {
		return score;
	}
	
	public void increaseScore(int TARGET) {
		score += TARGET;
	}
	
	public String getTime() {
		return "TIME" + time;
	}
}
