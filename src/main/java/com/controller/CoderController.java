package com.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Coder;
import com.service.CoderService;

@RestController
@RequestMapping("/api")
public class CoderController {
	
	@Autowired
	CoderService coderservice;
	
	@RequestMapping("/Hello")
	public String helloCoder()
	{
		String msg="Welcome to Spring Data Jpa";
		return msg;
	}
	
	@PostMapping("/addCoder")
	public ResponseEntity<Coder> addCoder(@RequestBody Coder c)
	{
		Coder c1=coderservice.addCoder(c);
		ResponseEntity re=new ResponseEntity<Coder>(c1,HttpStatus.OK);
		return re;
	}
	
	@GetMapping("/getCoders")
	public ResponseEntity<List<Coder>> getCoders()
	{
		List<Coder> lc1=coderservice.getCoders();
		ResponseEntity re=new ResponseEntity<List<Coder>>(lc1,HttpStatus.OK);
		return re;
	}
	
	@GetMapping(path="/getCoder/{cid}")
	public ResponseEntity<Coder> getCoderById(@PathVariable int cid) throws Throwable
	{
		Coder c1=coderservice.getCoderById(cid);
		
		ResponseEntity re=new ResponseEntity<Coder>(c1,HttpStatus.OK);
		return re;
	}
	
	@PostMapping(path="/addCoders")
	public ResponseEntity<List<Coder>> addCoders(@RequestBody List<Coder> ls)
	{
		List<Coder> le=coderservice.addCoders(ls);
		
		ResponseEntity re=new ResponseEntity<List<Coder>>(le,HttpStatus.OK);
		return re;
	}
	
	@PutMapping(path="/updateCoder")
	public ResponseEntity<Coder> updateCoder(@RequestBody Coder e) throws Throwable
	{
		Coder e1=coderservice.updateCoder(e);
		
		ResponseEntity re=new ResponseEntity<Coder>(e1,HttpStatus.OK);
		return re;
	}
	
	@DeleteMapping(path="/deleteCoder")
	public ResponseEntity<String> deleteCoder(@RequestBody Coder e)
	{
		coderservice.deleteCoder(e);
		
		ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
	}
	
	@DeleteMapping(path="/deleteCoderById/{eid}")
	public ResponseEntity<String> deleteCoderById(@PathVariable int eid)
	{
		coderservice.deleteCoderById(eid);
		
		ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
	}
	
	  @GetMapping("/getCodername/{cname}")
	  public ResponseEntity<Coder>  getCoderByCname(@PathVariable String cname) 
	  { 
		  Coder c=coderservice.getCoderByCname(cname); 
		  ResponseEntity re=new ResponseEntity<Coder>(c,HttpStatus.OK); 
		  return re;   
	  }
	  	
	  @GetMapping("/getCoderstech/{tech}") 
	  public ResponseEntity<List<Coder>> findByTechSorted(@PathVariable String tech) 
	  { 
		  List<Coder> lc=coderservice.findByTechSorted(tech); 
		  ResponseEntity re=new ResponseEntity<List<Coder>>(lc,HttpStatus.OK); 
		  return re; 
		  }	
}