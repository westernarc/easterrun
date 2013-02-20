package com.westernarc.easterrun.Actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g3d.materials.Material;
import com.badlogic.gdx.graphics.g3d.model.still.StillModel;
import com.badlogic.gdx.math.Vector3;

public class Actor {
	public Vector3 position;
	public Vector3 velocity;
	public Vector3 acceleration;
	
	public StillModel model;
	public Material material;
	public Texture texture;
	
	public enum Type {Player, Egg, Ground, Bomb};
	public Type actorType;
	
	//Whether or not the actor can be collided with
	public boolean collisionActive;
	
	public Actor() {
		position = new Vector3(0,0,0);
		velocity = new Vector3(0,0,0);
		acceleration = new Vector3(0,0,0);
		
		collisionActive = true;
	}
	public Actor(Type t) {
		this();
		actorType = t;
	}
	public void move(float x, float y, float z) {
		position.add(x,y,z);
	}
	
	public Actor clone() {
		Actor newActor = new Actor();
		newActor.position.set(this.position);
		newActor.material = this.material;
		newActor.texture = this.texture;
		newActor.model = this.model;
		newActor.actorType = this.actorType;
		
		return newActor;
	}
	
	public boolean collidesWith(Actor a) {
		//Actors that are not collisionActive cannot collide; return false immediately
		if(!collisionActive) return false;
		
		//TODO Currently, all actors have a size of 4
		if(Math.abs(a.position.x - position.x) < 4 && Math.abs(a.position.z - position.z) < 4) {
			return true;
		} else {
			return false;
		}
	}
	
	public void update(float tpf) {
		position.add(velocity.cpy().mul(tpf));
		velocity.add(acceleration.cpy().mul(tpf));
	}
}
