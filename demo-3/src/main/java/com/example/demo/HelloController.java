package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/hello")
public class HelloController {
	
	@RequestMapping(method = RequestMethod.GET)
	public void sayHello() {
		System.out.println("Hello");
	}
	
	@RequestMapping(value = "page1" , method = RequestMethod.GET)
	public String sayHello1() {
		System.out.println("Page 1");
		return "Welcome";
	}
	
	@RequestMapping(value = "page2" , method = RequestMethod.GET)
	public ModelAndView sayHello2(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("obj1" , "Welcome to obj1");
		modelAndView.setViewName("Welcome1");
		return modelAndView;
	}
	
	@RequestMapping(value="page3" , method = RequestMethod.GET)
	public ResponseEntity<String> sayHello21(){
		return ResponseEntity.ok("This is a response entity");
	}
	
	@RequestMapping(value = "page4" , method = RequestMethod.GET)
	public ModelAndView sayHello3(ModelAndView mandv){
		mandv.addObject("obj2" , "Welcome to obj2");
		mandv.setViewName("Welcome2");
		return mandv;
	}
	
	@RequestMapping(value = "page5" , method = RequestMethod.GET)
	public ModelAndView sayHello6(ModelAndView modelAndView, HttpServletRequest request) {
		modelAndView.addObject("obj3" , "Welcome to obj3");
		modelAndView.setViewName("Welcome3");
		HttpSession session = request.getSession();
		request.setAttribute("requestObj", "welcome to request object");
		session.setAttribute("sessionObj", "Welcome to session");
		return modelAndView;
	}
	
	@RequestMapping(value = "page5Repeat" , method = RequestMethod.GET)
	public ModelAndView repeat(ModelAndView modelAndView, HttpServletRequest request) {
		modelAndView.addObject("obj3" , "Welcome to obj3 in session");
		modelAndView.setViewName("Welcome3");
		request.setAttribute("requestObj", "welcome to request object in repeat");
		return modelAndView;
	}
	
	@RequestMapping(value = "page6" , method = RequestMethod.GET)
	public ResponseEntity<User> sayHello7(){
		User user = new User();
		user.setRollNo(01);
		user.setAdderss("Chennai");
		user.setName("Nandha");
		return ResponseEntity.ok(user);	
	}
	
	@RequestMapping(value = "page7" , method = RequestMethod.POST)
	public ResponseEntity<User> sayHello8(@RequestBody User user){
		System.out.println(user);
		user.setName(user.getName() + " Kumar");
		return ResponseEntity.ok(user);
	}
	
//	@RestController
	@RequestMapping(value = "page8" , method = RequestMethod.POST)
	public User sayHello9(@RequestBody User user){
		user.setName(user.getName() + " Kumar");
		return user;
	}
	
	@GetMapping(value = "page9")
	public void sayHello10(@RequestParam int rollNo, String name, String adderss) {
		System.out.println(rollNo);
		System.out.println(name);
		System.out.println(adderss);
	}
	
	@GetMapping(value = "page10/{id}")
	public void sayHello11(@PathVariable("id") int rollNo) {
		System.out.println(rollNo);
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