
package com.spring.course;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.spring.student.StudentService;
import com.spring.student.Student;
import com.spring.student.StudentServiceImp;
import com.spring.teacher.TeacherService;
import com.spring.teacher.TeacherServiceImp;


@Controller
public class CourseController {
    
    private CourseService courseService;
    private StudentService studentService;
    private TeacherService teacherService;

    @Autowired(required = true)
    @Qualifier(value = "courseService")
    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
}
    
    @Autowired(required = true)
    @Qualifier(value = "teacherService")
    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    
    @Autowired(required = true)
    @Qualifier(value = "studentService")
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }
    
    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
    
    @RequestMapping(value = "/course/add", method = RequestMethod.GET)
    public String courseForm(Model model) {
        model.addAttribute("course", new Course());
        return "course_form";
    }
    
    @RequestMapping(value = "/course/add", method = RequestMethod.POST)
    public String addCourse(
            @Valid @ModelAttribute("course") Course course,
            BindingResult bindingResult) {
        
        if (bindingResult.hasErrors()){
            return "course_form";
        }
        else {
            courseService.addCourse(course);        
            return "redirect:/course/list";
        }
    }

    
    @RequestMapping(value = "/course/{id}", method = RequestMethod.GET)
    public String editCourse(@PathVariable("id") int id, Model model) {
        Course course =  this.courseService.getCourseById(id);
        model.addAttribute("course", course);   
        model.addAttribute("teacherList", this.teacherService.listTeachersByCourse(course));
        model.addAttribute("studentList", this.studentService.listStudentsByCourse(course));       
        return "course_form";
    }    
    
    @RequestMapping(value = "/course/list", method = RequestMethod.GET)
    public String listCourses(Model model) {
        model.addAttribute("listCourses", courseService.listCourses());
        return "course_list";
    }
    
    @RequestMapping(value = "/course/edit", method = RequestMethod.POST)
    public String editCourse(
            @Valid @ModelAttribute("course") Course course,
            BindingResult bindingResult) {
        
        if (bindingResult.hasErrors()){
            return "course_form";
        }
        else {
            courseService.editCourse(course);        
            return "redirect:/course/list";
        }
    }

    @RequestMapping(value = "/course/delete/{id}", method = RequestMethod.POST)
    public String deleteCourse(@PathVariable("id") int id, Model model) {
        Course course = courseService.getCourseById(id);
        courseService.deleteCourse(course);
        return "redirect:/course/list";
    }    
}
