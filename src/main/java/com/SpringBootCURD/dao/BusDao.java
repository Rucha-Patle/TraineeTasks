package com.SpringBootCURD.dao;

import java.util.List;


import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.SpringBootCURD.entity.Bus;

@Repository
public class BusDao {

	@Autowired
	private SessionFactory sf;
	
	public List<Bus> getAllBus() {
		Session session =sf.openSession();
		Transaction tr =session.beginTransaction();
		Criteria crt =session.createCriteria(Bus.class);
		List<Bus> bus =crt.list();
		tr.commit();
		return bus;
	}

	public String SaveBusData(Bus bus) {
		Session session =sf.openSession();
		Transaction tr =session.beginTransaction();
		session.save(bus);
		tr.commit();
		return "Bus Data Saved";
	}

	public String updateBusData(Bus bus) {
		Session session =sf.openSession();
		Transaction tr =session.beginTransaction();
		try{
			session.update(bus);
			tr.commit();
			return "Bus Data Updated";
		}
		catch (Exception e) {
			return "Bus of this id is not present, please enter again";
		}
	}

	public String DeleteBusById(int id) {
		Session session =sf.openSession();
		Transaction tr =session.beginTransaction();
		Bus bus =session.get(Bus.class, id);
		try{
			session.delete(bus);
			tr.commit();
			return "Bus Data deleted";
		}
		catch (Exception e) {
			return "Bus of this id is not present, please enter again";
		}
	}

	public Bus getBusbyId(int id) {
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Bus bus=session.get(Bus.class, id);
		tr.commit();
		return bus;
	}
}
