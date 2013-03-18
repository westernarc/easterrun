package com.westernarc.easterrun.Actors;

import com.badlogic.gdx.graphics.g3d.materials.Material;
import com.badlogic.gdx.graphics.g3d.model.still.StillModel;
import com.badlogic.gdx.math.Vector3;

public class PlayerActor extends Actor {
	public enum anims {walk, run, fly, jump}
	public anims currentAnim;
	public int currentFrame;
	
	public Vector3 rotation;
	
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
		jumpFrames = new StillModel[7];
		currentAnim = anims.walk;
		
		currentFrame = 1;
		animFrameRate = constDefaultFrameRate;
		
		rotation = new Vector3();
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
			if(currentFrame > 6) currentFrame = 6;
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
		if(currentAnim != anim && anim == anims.jump) {
			currentFrame = 1;
		}
		currentAnim = anim;
	}
	
	public void setMaterial(Material newMat) {
		for(int curFrame = 1; curFrame < 20; curFrame++) {
			walkFrames[curFrame].setMaterial(newMat);
		}
		for(int curFrame = 1; curFrame < 10; curFrame++) {
			runFrames[curFrame].setMaterial(newMat);
		}
		for(int curFrame = 1; curFrame < 5; curFrame++) {
			flyFrames[curFrame].setMaterial(newMat);
		}
		for(int curFrame = 1; curFrame < 7; curFrame++) {
			jumpFrames[curFrame].setMaterial(newMat);
		}
	}
}
