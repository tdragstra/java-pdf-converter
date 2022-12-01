package com.achmeaDemo.demoFulllStack.persist;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.achmeaDemo.demoFulllStack.rest.Polis;

@Component
public interface polisReposito extends CrudRepository<Polis, Long> {

}
