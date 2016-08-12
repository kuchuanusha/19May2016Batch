package com.capgrmini.CapStoreFinalProject.View;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.flp.fms.view.UserInteraction;

public class BootClass {

	static UserInteraction userinteraction=new UserInteraction();

	public static void main(String[] args) {
		userinteraction.refundAmount();
	}

}
