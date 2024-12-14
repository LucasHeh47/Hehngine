package com.lucasj.hehngine.entities.components;

import com.lucasj.hehngine.Game;
import com.lucasj.hehngine.entities.Entity;
import com.lucasj.hehngine.math.Vector2D;

public class PhysicsComponent extends EntityComponent {
	
	public Vector2D velocity;
	public Vector2D acceleration;
	
	/***
	 * 
	 * @param entity
	 */
	public PhysicsComponent(Game game, Entity entity) {
		super(game, entity);
		this.addRequiredComponentClass(TransformComponent.class);
	}

	/***
	 * 
	 * @param entity
	 * @param velocity
	 * @param acceleration
	 */
	public PhysicsComponent(Game game, Entity entity, Vector2D vel, Vector2D accel) {
		super(game, entity);
		this.velocity = vel;
		this.acceleration = accel;
	}

	@Override
	public void update(double deltaTime) {
		this.velocity = this.velocity.add(acceleration);
		
	}
	
	
	
}
