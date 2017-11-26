package org.springframework.samples.petclinic.membership;

import java.util.Collection;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.google.common.collect.Lists;

@Controller
public class StudentController {
	
	private static final String VIEWS_STUDENT_CREATE_OR_UPDATE_FORM = "students/createOrUpdateStudentForm";
	private final StudentRepository students;
	
	@Autowired
	public StudentController(StudentRepository students) {
		this.students = students;
	}
	
	@InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }
	
	@GetMapping("/students/new")
    public String initCreationForm(Map<String, Object> model) {
		Student student = new Student();
        model.put("student", student);
        return VIEWS_STUDENT_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/students/new")
    public String processCreationForm(@Valid Student student, BindingResult result) {
        if (result.hasErrors()) {
            return VIEWS_STUDENT_CREATE_OR_UPDATE_FORM;
        } else {
            this.students.save(student);
            return "redirect:/students/" + student.getId();
        }
    }
	
	@GetMapping("/students")
    public String processFindForm(Student student, BindingResult result, Map<String, Object> model) {

        Collection<Student> results = Lists.newArrayList(this.students.findAll());
        model.put("selections", results);
        return "students/studentsList";
    }
	
	@GetMapping("/students/{studentId}/edit")
    public String initUpdateStudentForm(@PathVariable("studentId") int studentId, Model model) {
		Student student = this.students.findOne(studentId);
        model.addAttribute(student);
        return VIEWS_STUDENT_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/students/{studentId}/edit")
    public String processUpdateStudentForm(@Valid Student student, BindingResult result, @PathVariable("studentId") int studentId) {
    	student.setId(studentId);
        if (result.hasErrors()) {
            return VIEWS_STUDENT_CREATE_OR_UPDATE_FORM;
        } else {
            this.students.save(student);
            return "redirect:/students/{studentId}";
        }
    }
    
    @GetMapping("/students/{studentId}/delete")
    public String processDeleteStudent(@PathVariable("studentId") int studentId) {
    	this.students.delete(studentId);
    	return "redirect:/students";
    }

    @GetMapping("/students/{studentId}")
    public ModelAndView showStudent(@PathVariable("studentId") int studentId) {
        ModelAndView mav = new ModelAndView("students/studentDetails");
        mav.addObject(this.students.findOne(studentId));
        return mav;
    }
}
