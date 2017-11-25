package org.springframework.samples.petclinic.membership;

import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;

import com.google.common.collect.Lists;

@Controller
public class StudentController {
	
	private static final String VIEWS_STUDENT_CREATE_OR_UPDATE_FORM = "students/createOrUpdateOwnerForm";
	private final StudentRepository students;
	
	@Autowired
	public StudentController(StudentRepository students) {
		this.students = students;
	}
	
	@InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }
	
	@GetMapping("/students")
    public String processFindForm(Student student, BindingResult result, Map<String, Object> model) {

        Collection<Student> results = Lists.newArrayList(this.students.findAll());
        model.put("selections", results);
        return "students/studentsList";
    }
}
