package com.gontuseries.studentadmissioncontroller;

import java.beans.PropertyEditorSupport;

public class StudentNameEditor extends PropertyEditorSupport {
	
	//when you will submit the admission form-->
	//Spring MVC will run setAsText function of ths class -->
	//Before performing data binding task for studentName property of student object
@Override
public void setAsText(String studentName) throws IllegalArgumentException{
	if(studentName.startsWith("Mr.") || studentName.startsWith("Ms.")){
		setValue(studentName);
	}
	else{
		studentName="Mr."+studentName;//what ever value you will  provide to setValue -- spring MVC will use the
		                              // same value to perform data binding task for studentName property
		setValue(studentName);
	}
	
}
}
