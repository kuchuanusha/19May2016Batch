package com.capgemini.dao;

import java.util.List;
import java.util.Map;

import com.capgemini.model.Car;

public interface ICarDao {

	boolean addCar(Car car);

	boolean editCar(Car car);

	boolean deleteCar(Car car);

	List<Car> viewCar();
	
	Car findCar(int carId);

}