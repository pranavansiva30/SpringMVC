package com.gontuseries.studentadmissioncontroller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentAdmissionController {
@InitBinder
public void initBinder(WebDataBinder binder){
	//binder.setDisallowedFields(new String []{"studentMobile"});
	SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-mm-dd");
	binder.registerCustomEditor(Date.class,"studentDOB",new CustomDateEditor(dateFormat, false));
	binder.registerCustomEditor(String.class,"studentName",new StudentNameEditor());
}
@RequestMapping(value="/admissionForm.html",method=RequestMethod.GET)
public ModelAndView getAdmissionForm(){
	ModelAndView model=new ModelAndView("AdmissionForm");
	return model;
	
	
}
@RequestMapping(value="/admissionFormException.html",method=RequestMethod.GET)
public ModelAndView getAdmissionFormException() throws Exception{
	ModelAndView model=new ModelAndView("AdmissionFormException");
	String exceptionOccured="ARITHMETIC_EXCEPTION";
	if(exceptionOccured.equalsIgnoreCase("NULL_POINTER")){
		throw new NullPointerException("Null Pointer Exception");
	}
	else if(exceptionOccured.equalsIgnoreCase("IO_EXCEPTION")){
		throw new IOException("Io Exception");
	}
	else if(exceptionOccured.equalsIgnoreCase("ARITHMETIC_EXCEPTION")){
		throw new ArithmeticException("Arithmetic Exception");
	}
	return model;
	
	
}
@ModelAttribute
public void addingCommonObjects(Model model){
	model.addAttribute("headerMessage","Faculty of Science,University of Colombo")	;
}
@RequestMapping(value="/submitAdmissionForm.html",method=RequestMethod.POST)
public ModelAndView submitAdmissionForm(@Valid @ModelAttribute("student1") Student student1,BindingResult result){
	if(result.hasErrors()){
		ModelAndView model=new ModelAndView("AdmissionForm");
		return model;
	}
	ModelAndView model=new ModelAndView("AdmissionSuccess");	
	return model;
}
/*these two methods also give same out put
@RequestMapping(value="/submitAdmissionForm.html",method=RequestMethod.POST)
public ModelAndView submitAdmissionForm(Student student1){
	ModelAndView model=new ModelAndView("AdmissionSuccess");	
	model.addObject("student1",student1);
	return model;}
}
@RequestMapping(value="/submitAdmissionForm.html",method=RequestMethod.POST)
public ModelAndView submitAdmissionForm(@RequestParam( value="studentName",defaultValue="abc") String name,@RequestParam("studentHobby") String hobby){
	Student student1=new Student();
	student1.setStudentHobby(hobby);
	student1.setStudentName(name);
	ModelAndView model=new ModelAndView("AdmissionSuccess");	
	model.addObject("student1",student1);
	return model;
}*/
@ResponseBody
@RequestMapping(value="/students",method=RequestMethod.GET)
public ArrayList<Student> getStudentsList(){
	Student student1=new Student();
	student1.setStudentName("kumar");
	Student student2=new Student();
	student2.setStudentName("ram");
	Student student3=new Student();
	student3.setStudentName("rahul");
	ArrayList<Student> studentsList=new ArrayList<Student>();
	studentsList.add(student1);
	studentsList.add(student2);
	studentsList.add(student3);
	return studentsList;
}

}
