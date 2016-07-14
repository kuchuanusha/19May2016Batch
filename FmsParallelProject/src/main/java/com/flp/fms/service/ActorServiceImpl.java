package com.flp.fms.service;
import com.flp.fms.domain.*;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.flp.fms.dao.ActorDaoImplForList;
import com.flp.fms.dao.IActorDao;

public class ActorServiceImpl implements IActorService {
	
	
	IActorDao actorDao;
	
	public ActorServiceImpl() 
	{
		
		actorDao=new ActorDaoImplForList();
	}
	public Actor addActor(String first_name, String last_name){
		
		return actorDao.addActor(first_name,last_name);
		
	}
	
	public void modifyActor()
	{
		
		
	}

 
	public boolean removeActor(int actor_id){
	 return actorDao.removeActor(actor_id);
    }
	
	public Actor searchActor(int actor_id){
		return actorDao.searchActor(actor_id);
	}
 
	public List<Actor> getAllActors(){
		return actorDao.getAllActors();
		
	}
	

}
