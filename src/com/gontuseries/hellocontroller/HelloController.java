package com.gontuseries.hellocontroller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;



@Controller
@RequestMapping("/greet")
public class HelloController{

	@RequestMapping("/welcome/{countryName}/{name}")
	protected ModelAndView helloWorld(@PathVariable String name,@PathVariable String countryName){
		ModelAndView modelandview=new ModelAndView("HelloPage");
		modelandview.addObject("welcomeMessage", "Hello " +name +"you are from "+countryName);
		return modelandview;
	}
	@RequestMapping("/hi/{countryName}/{name}")
	protected ModelAndView hiWorld(@PathVariable Map<String, String> pathVars){
		ModelAndView modelandview=new ModelAndView("HelloPage");
		String name=pathVars.get("name");
		String countryName=pathVars.get("countryName");
		modelandview.addObject("welcomeMessage","Hi " +name +"you are from "+countryName);
		return modelandview;
	}

}
/*
public class HelloController extends AbstractController{

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView modelandview=new ModelAndView("HelloPage");
		modelandview.addObject("welcomeMessage", "Hi User,welcome to the first Spring MVC Application");
		return modelandview;
	}

}
*/