package com.achmeaDemo.demoFulllStack.persist;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.achmeaDemo.demoFulllStack.rest.Polis;

@Service
public class polisService {
	
	// has a relatie
	// autowired dependancy injection
	
	@Autowired
	polisReposito pr;

	public Optional<Polis> polisOpslaan(Polis polis) {
		System.out.println("Ik ga iets opslaan");
		pr.save(polis);
		return pr.findById(polis.id());
	}

}
