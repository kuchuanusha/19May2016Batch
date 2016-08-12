package com.flp.fms.dao;



import java.util.List;

import com.flp.fms.domain.Actor;

public interface IActorDao {
	
	  Actor addActor(Actor actor);
  boolean modifyActor(Actor actor);
	 boolean removeActor(int actorId);
  Actor searchActor(int actorId);
  List<Actor> getAllActors();
	 Actor findActorByName(String firstName, String lastName);

}
