package kr.ac.hansung.cse.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.ac.hansung.cse.model.Customer;
import kr.ac.hansung.cse.repo.CustomerRepository;

@RestController
@RequestMapping("/api")
public class CustomerController {
	
	static Logger logger = LoggerFactory.getLogger(CustomerController.class);
 
	@Autowired
	CustomerRepository repository;
 	
	// produces=MediaType.APPLICATION_JSON_VALUE : responceBody가 JSON 형태 => 넘겨줄 때 JSON 형태로 넘겨 줌
	@GetMapping(value="/customers", produces=MediaType.APPLICATION_JSON_VALUE)	
	public ResponseEntity<List<Customer>>  getAll() {
		
		logger.debug("Calling getAll( )" );
				
		List<Customer> list = new ArrayList<>();
		// CustomerRepository가 상속받는 CrudRepository에 findAll()이란 함수 존재 (전체 조회)
		Iterable<Customer> customers = repository.findAll();
 
		customers.forEach(list::add); // 각각에 대해 for each 수행 => list에 add 함
		
		return new ResponseEntity<List<Customer>>(list, HttpStatus.OK);
	}
	
	// 하나의 customer 생성
	@PostMapping(value="/customers")
	// @RequestBody 사용 => customer의 firstName, lastName 받음
	public ResponseEntity<Void> postCustomer(@RequestBody Customer customer) { 
 
		logger.debug("Calling postCustomer( )" );
		
		String firstName = customer.getFirstName();
		String lastName = customer.getLastName();
				
		// CustomerRepository가 상속받는 CrudRepository에 save()란 함수 존재 (id는 자동 생성 됨)
		repository.save(new Customer(firstName, lastName));
	
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
 
	// lastName으로 customer 조회
	// produces=MediaType.APPLICATION_JSON_VALUE : responceBody가 JSON 형태 => 넘겨줄 때 JSON 형태로 넘겨 줌
	@GetMapping(value="/customers/{lastName}", produces=MediaType.APPLICATION_JSON_VALUE) 
	public ResponseEntity<List<Customer>> findByLastName(@PathVariable String lastName) {
 
		logger.debug("Calling findByLastName( )" );
		
		List<Customer> customers = repository.findByLastName(lastName);
		return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
	}
	
	// id을 받아서 customer 삭제
	@DeleteMapping(value="/customers/{id}")
	public ResponseEntity<Void> deleteCustomer(@PathVariable long id){
		
		logger.debug("Calling deleteCustomer( )" );
		repository.delete(id);
		
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}