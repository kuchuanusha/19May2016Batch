package com.flp.fms.service;


import java.util.List;

import com.flp.fms.domain.Actor;


public interface IActorService {
	
	abstract  Actor addActor(String first_name,String last_name);
	abstract  void modifyActor();
	abstract boolean removeActor(int actor_id);
	abstract  Actor searchActor(int actor_id);
	abstract List<Actor> getAllActors();

}
