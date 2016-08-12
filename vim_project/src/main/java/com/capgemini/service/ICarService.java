package com.capgemini.service;

import java.util.List;
import java.util.Map;

import com.capgemini.model.Car;

public interface ICarService {

	boolean addCar(Map carDetails);

	boolean editCar(Map carDetails);

	boolean deleteCar(int carId);

	List<Car> viewCar();

}