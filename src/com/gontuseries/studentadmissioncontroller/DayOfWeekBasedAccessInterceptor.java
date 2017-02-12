package com.gontuseries.studentadmissioncontroller;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class DayOfWeekBasedAccessInterceptor extends HandlerInterceptorAdapter {
@Override
public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handler) throws Exception{
	Calendar cal=Calendar.getInstance();
	int dayOfWeek=cal.get(cal.DAY_OF_WEEK);
	if(dayOfWeek==2){
		
		response.getWriter().write("The Web Site is closed on Sunday; please try it on any other week day!!");
		return false;
	}
	
	return true;
		
		
		
	}
@Override
 public void postHandle(HttpServletRequest request,HttpServletResponse response,Object handler,ModelAndView modelAndView) throws Exception{
	//this method would be called after Spring MVC executes the request handler method for the request
	System.out.println("HandlerInterceptorAdapter:Spring MVC called postHandle method for "+request.getRequestURI().toString());
 }

@Override
public void afterCompletion(HttpServletRequest request,HttpServletResponse response,Object handler,Exception ex) throws Exception{
	//this method would be called after the response object is produced by the view for the request
	System.out.println("HandlerInterceptorAdapter:Spring MVC called afterCompletion method for "+request.getRequestURI().toString());
}
}
