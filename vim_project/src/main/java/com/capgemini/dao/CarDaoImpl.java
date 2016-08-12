package com.capgemini.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.capgemini.createentity.EntityManagerCreator;
import com.capgemini.model.Car;

public class CarDaoImpl implements ICarDao {
	
	EntityManagerCreator creator=new EntityManagerCreator();
	EntityManager em=creator.openEntityManger();

	
	public boolean addCar(Car car)
	{
		if(car == null)
		{
			return false;
		}
		else
		{
			em.getTransaction().begin();
			em.persist(car);
			em.getTransaction().commit();
			return true;
		}
	}
	
	
	public boolean editCar( Car car)
	{
		if(car == null)
		{
			return false;
		}
		else
		{
			em.getTransaction().begin();
			em.persist(car);
			em.getTransaction().commit();
			return true;
		}
	}
	
	
	public boolean deleteCar(Car car)
	{
		if(car == null)
		{
			return false;
		}
		else
		{
			em.getTransaction().begin();
			em.remove(car);
			em.getTransaction().commit();
			return true;
		}
		
	}
	
	
	public List<Car> viewCar()
	{
		TypedQuery<Car> query=em.createQuery("select c from Car c",Car.class);
		
		if(query.getResultList().size()>0)
		{
			return query.getResultList();
		}
		return null;
	}
	
	public Car findCar(int carId){
		return em.find(Car.class,carId);
		
	}
}
