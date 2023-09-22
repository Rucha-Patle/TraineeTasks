package com.SpringBootCURD.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBootCURD.dao.BusDao;
import com.SpringBootCURD.entity.Bus;


@Service
public class BusService {

	@Autowired
	private BusDao bd;

	public List<Bus> getAllBus() {
		return bd.getAllBus();
	}

	public String SaveBusData(Bus bus) {
		return bd.SaveBusData(bus);
	}

	public void updateBusData(Bus bus) {
		bd.updateBusData(bus);
	}

	public void DeleteBusById(int id) {
		bd.DeleteBusById(id);
	}

	public Bus getBusbyId(int id) {
		return bd.getBusbyId(id);
	}
}
