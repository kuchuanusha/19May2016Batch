package com.capgemini.service;

import java.util.List;
import java.util.Map;

import com.capgemini.dao.CarDaoImpl;
import com.capgemini.dao.ICarDao;
import com.capgemini.model.Car;

public class carServiceImpl implements ICarService {
	
	ICarDao carDao;
	
	public carServiceImpl()
	{
		carDao=new CarDaoImpl();
	}
	
	
	public boolean addCar(Map carDetails)
	{
		Car car=new Car();
		
		car.setMake((String) carDetails.get("make"));
		car.setModel((String) carDetails.get("model"));
		car.setModelYear((String) carDetails.get("modelYear"));
		
		if(carDao.viewCar() != null)
		{
			if(!carDao.viewCar().contains(car))
			{
				return carDao.addCar(car);
			}
			else
			{
				return false;
			}
		}
		return carDao.addCar(car);
	}
	
	
	public boolean editCar(Map carDetails)
	{
		
		Car car=carDao.findCar((Integer) carDetails.get("id"));
		
		if(car == null)
		{
			return false;
		}
		else
		{
			car.setMake((String) carDetails.get("make"));
			car.setModel((String) carDetails.get("model"));
			car.setModelYear((String) carDetails.get("modelYear"));	
			return carDao.editCar(car);
		}
		
	}
	
	
	public boolean deleteCar(int carId)
	{
		Car car=carDao.findCar(carId);
		if(car == null)
		{
			return false;
		}
		else
		{
			return carDao.deleteCar(car);
		}
		
	}
	
	public List<Car> viewCar()
	{
		return carDao.viewCar();
		
	}
	

}
