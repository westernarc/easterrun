package com.westernarc.easterrun.Actors;

import com.badlogic.gdx.graphics.g3d.model.still.StillModel;

public class PlayerActor extends Actor {
	public enum anims {walk, run, fly, jump}
	public anims currentAnim;
	public int currentFrame;
	
	public StillModel[] walkFrames;
	public StillModel[] runFrames;
	public StillModel[] flyFrames;
	public StillModel[] jumpFrames;
	
	public float animFrameRate;	
	private float animFrameTimer;
	public static final float constDefaultFrameRate = 1/50f; 
	
	
	public PlayerActor() {
		walkFrames = new StillModel[20];
		runFrames = new StillModel[10];
		flyFrames = new StillModel[5];
		jumpFrames = new StillModel[2];
		currentAnim = anims.walk;
		
		currentFrame = 1;
		animFrameRate = constDefaultFrameRate;
	}
	
	public void update(float tpf) {
		super.update(tpf);
		
		animFrameTimer += tpf;
		if(animFrameTimer > animFrameRate) {
			animFrameTimer = 0;
			currentFrame++;
		}
		switch(currentAnim) {
		case fly:
			if(currentFrame > 4) currentFrame = 1;
			model = flyFrames[currentFrame];
			break;
		case jump:
			if(currentFrame > 1) currentFrame = 1;
			model = jumpFrames[currentFrame];
			break;
		case run:
			if(currentFrame > 9) currentFrame = 1;
			model = runFrames[currentFrame];
			break;
		case walk:
			if(currentFrame > 19) currentFrame = 1;
			model = walkFrames[currentFrame];
			break;
		default:
			if(currentFrame > 19) currentFrame = 1;
			model = walkFrames[currentFrame];
			break;
		}
	}

	public void setAnim(anims anim) {
		currentAnim = anim;
	}
}
