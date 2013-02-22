package com.westernarc.easterrun.Actors;

import com.badlogic.gdx.graphics.g3d.model.still.StillModel;

public class ActorAnimation {
	public StillModel[] modelList;
	public int animid;
	public int startIndex;
	public int endIndex;
	
	public int currentFrame;
	
	public ActorAnimation(int an, int si, int ei) {
		animid = an;
		startIndex = si;
		endIndex = ei;
		
		if(si == 0) si = 1;
		
		modelList = new StillModel[si + ei];
		
		currentFrame = startIndex;
	}
}
