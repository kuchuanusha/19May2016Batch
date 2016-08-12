package com.flp.fms.service;


import java.util.List;
import java.util.Map;

import com.flp.fms.Exceptions.FieldEmptyException;
import com.flp.fms.Exceptions.NegativeFieldException;
import com.flp.fms.Exceptions.RecordNotFoundException;
import com.flp.fms.domain.Actor;


public interface IActorService {
	
	 Actor addActor(String firstName,String lastName) throws FieldEmptyException;
	 String modifyActor(Map<Integer, Object> actorList) throws RecordNotFoundException;
	 boolean removeActor(int actor_id) throws NegativeFieldException, FieldEmptyException, RecordNotFoundException;
	  Actor searchActor(int actor_id) throws RecordNotFoundException, NegativeFieldException, FieldEmptyException;
	 List<Actor> getAllActors();

}
