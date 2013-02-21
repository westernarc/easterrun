package com.westernarc.easterrun.Actors;

import com.badlogic.gdx.graphics.g3d.model.still.StillModel;

public class AnimActor extends Actor {
	public StillModel[] modelList;
	public int startIndex;
	public int endIndex;
	public float animFrameRate;
	public int currentFrame;
	
	private float animFrameTimer;
	public static final float constDefaultFrameRate = 1/50f; 
	
	public AnimActor(int start, int end) {
		startIndex = start;
		endIndex = end;
		
		//If start frame is zero, add 1 to the model count
		if(start == 0) start = 1;
		modelList = new StillModel[end + start];
		
		currentFrame = startIndex;
		animFrameRate = constDefaultFrameRate;
	}
	
	public void update(float tpf) {
		super.update(tpf);
		
		//Update animation frames
		animFrameTimer += tpf;
		if(animFrameTimer > animFrameRate) {
			currentFrame++;
			animFrameTimer = 0;
		}
		if(currentFrame > endIndex) currentFrame = startIndex;
		
		//Set the model to the next frame in the animation
		model = modelList[currentFrame];
	}
}
