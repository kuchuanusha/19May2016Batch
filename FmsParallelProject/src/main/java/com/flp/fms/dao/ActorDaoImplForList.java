package com.flp.fms.dao;



import java.util.List;

import com.flp.fms.domain.*;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;



public class ActorDaoImplForList implements IActorDao {
	
	private EntityManager em;
	private EntityManagerFactory emf;
	
	public ActorDaoImplForList() {
		this.emf = Persistence.createEntityManagerFactory("hello");
		this.em = emf.createEntityManager();
	}
	
	
	public Actor addActor(String first_name,String last_name)
	{
		Actor actor=findActorByName(first_name);
		if(actor == null)
		{
			actor=new Actor(first_name,last_name);
		}
		em.getTransaction().begin();
		em.persist(actor);
		em.getTransaction().commit();
		return actor;
	}
	
	public void modifyActor()
	{
		
		
	}

 
	public boolean removeActor(int actor_id){
		Actor actor=searchActor(actor_id);
		if(actor!=null)
		{
			em.getTransaction().begin();
			em.remove(actor);
			em.getTransaction().commit();
			return true;
		}
		else
			return false;
    }
	public Actor findActorByName(String first_name){
		return em.find(Actor.class, first_name);
	}
	
	public Actor searchActor(int actor_id){
		return em.find(Actor.class, actor_id);
		
	}
 
	public List<Actor> getAllActors(){
		
		TypedQuery<Actor> query = em.createQuery("Select actor from Actor actor",Actor.class);
		return query.getResultList();
	}
	

	
	

}
