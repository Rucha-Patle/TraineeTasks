package com.SpringBootCURD.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBootCURD.entity.Bus;
import com.SpringBootCURD.service.BusService;


@RestController
public class BusController {

	@Autowired
	private BusService bs;

	@GetMapping("/allBus")
	public List<Bus> getAllBus() {
		return bs.getAllBus();
	}

	@PostMapping("/saveBus")
	public String SaveBusData(@RequestBody Bus bus) {
		return bs.SaveBusData(bus);
	}
	
	@PutMapping("/updatebus/{id}")
	public ResponseEntity<String> updateBusData(@PathVariable int id,@RequestBody Bus bus) {
		try{
			bus.setId(id);
			bs.updateBusData(bus);
			return ResponseEntity.ok("Bus data updated");
		}catch(Exception e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Bus of this id is not present, please enter again");
		}
	}
	
	@DeleteMapping("/deleteBus/{id}")
	public ResponseEntity<String> DeleteBusById(@PathVariable("id") int id)
	{
		try {
		bs.DeleteBusById(id);
		return ResponseEntity.ok("Bus Data deleted");
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Bus of this id is not present, please enter again");
		}
	}
	
	@GetMapping("/bus/{id}")
	public ResponseEntity<Bus> getBusbyId(@PathVariable int id) {
		Bus bus=bs.getBusbyId(id);
		if(bus==null)
		{
			return ResponseEntity.notFound().build();
			}
		else {
			return ResponseEntity.ok(bus);
		}
	}
}
