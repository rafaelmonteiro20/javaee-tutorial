package com.counter.ejb;

import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Startup
@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
public class ContadorService {

	private int hits = 1;
	
	@Lock(LockType.WRITE)
	public int getHits() {
		return hits++;
	}
	
}
