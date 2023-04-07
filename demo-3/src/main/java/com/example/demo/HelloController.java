package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/hello")
public class HelloController {
	@RequestMapping(method = RequestMethod.GET)
	public void sayHello() {
		System.out.println("Hello");
	}
	
	@RequestMapping(value = "hello1" , method = RequestMethod.GET)
	public String sayHello1() {
		System.out.println("Hello 1");
		return "Welcome";
	}
	
	@RequestMapping(value = "hello2" , method = RequestMethod.GET)
	public ModelAndView sayHello2(){
		ModelAndView mandv = new ModelAndView();
		mandv.addObject("obj1" , "Welcome to obj1");
		mandv.setViewName("Welcome1");
		return mandv;
	}
	
	@RequestMapping(value="hello21" , method = RequestMethod.GET)
	public ResponseEntity<String> sayHello21(){
		return ResponseEntity.ok("This is a response entity");
	}
	
	@RequestMapping(value = "hello3" , method = RequestMethod.GET)
	public ModelAndView sayHello3(ModelAndView mandv){
		mandv.addObject("obj2" , "Welcome to obj2");
		mandv.setViewName("Welcome2");
		return mandv;
	}
	
	@RequestMapping(value = "hello4" , method = RequestMethod.GET)
	public ModelAndView sayHello6(ModelAndView mandv, HttpServletRequest request) {
		mandv.addObject("obj6" , "Welcome to obj6");
		mandv.setViewName("Welcome3");
		HttpSession session = request.getSession();
		request.setAttribute("requestObj", "welcome to request object");
		session.setAttribute("sessionObj", "Welcome to session");
		return mandv;
	}
	
	@RequestMapping(value = "repeat" , method = RequestMethod.GET)
	public ModelAndView repeat(ModelAndView mandv, HttpServletRequest request) {
		mandv.addObject("obj6" , "Welcome to obj6 in session");
		mandv.setViewName("Welcome3");
		request.setAttribute("requestObj", "welcome to request object in repeat");
		return mandv;
	}
	
	@RequestMapping(value = "hello7" , method = RequestMethod.GET)
	public ResponseEntity<User> sayHello7(){
		User user = new User();
		user.setRollNo(01);
		user.setAdderss("Chennai");
		user.setName("Nandha");
		return ResponseEntity.ok(user);	
	}
	
	@RequestMapping(value = "hello8" , method = RequestMethod.POST)
	public ResponseEntity<User> sayHello8(@RequestBody User user){
		System.out.println(user);
		user.setName(user.getName() + " Kumar");
		return ResponseEntity.ok(user);
	}
	
//	@RestController
	@RequestMapping(value = "hello9" , method = RequestMethod.POST)
	public User sayHello9(@RequestBody User user){
		user.setRollNo(22);
		user.setName(user.getName() + " Kumar");
		user.setAdderss("Chennai");
		return user;
	}
}

class User{
	private int rollNo;
	private String name;
	private String adderss;
	public int getRollNo() {
		return rollNo;
	}
	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAdderss() {
		return adderss;
	}
	public void setAdderss(String adderss) {
		this.adderss = adderss;
	}
}
