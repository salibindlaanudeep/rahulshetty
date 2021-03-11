
package com.spring.teacher;
import com.spring.course.Course;
import com.spring.course.CourseDao;
import com.spring.course.CourseDaoImp;
import com.spring.course.CourseService;
import com.spring.course.CourseServiceImp;
import com.spring.student.Student;
import com.spring.student.StudentController;
import com.spring.student.StudentService;
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


@Controller // processing and rendering the web requests.. here when teacher requests for any service  make them as a private class and import the required  
public class TeacherController {
    
     private TeacherService teacherService;
    private TeachercourseService teachercourseService;
    
    @Autowired(required = true) //@autowired injects the object dependencies independently... 
    @Qualifier(value = "teacherService")
    public void setTeacherService(TeacherService teacherService) {
        this.teacherService = teacherService;  // @autowired uses setter to inject (can  also use constructor)...
    }

    @Autowired(required = true)
    @Qualifier(value = "teachercourseService")    
    public void setTeachercourseService(TeachercourseService teachercourseService) {
        this.teachercourseService = teachercourseService;
    }
 @InitBinder //@initBinder controls and formats each and every request in the Controller
    public void initBinder(WebDataBinder dataBinder){
   //StringTrimmerEditor treats the blank spaces or null spaces as NULL of any column if it denotes that value shouldn't be null     
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }    
    
    @RequestMapping(value = "/teacher/add", method = RequestMethod.GET)
    public String teacherForm(Model model) {
        model.addAttribute("teacher", new Teacher());
        return "teacher_form";
    }
    
    @RequestMapping(value = "/teacher/add", method = RequestMethod.POST)
    public String addTeacher(
            @Valid @ModelAttribute("teacher") Teacher s,
            BindingResult bindingResult) {
        
        if (bindingResult.hasErrors()) {
            return "teacher_form";
        } else {          
            teacherService.addTeacher(s);        
            return "redirect:/teacher/list";
        }
    }
    
    @RequestMapping(value = "/teacher/{id}")
    public String editTeacher(@PathVariable("id") int id, Model model) {
        model.addAttribute("teacher", this.teacherService.getTeacherById(id));
        model.addAttribute("teachercourseList", this.teachercourseService.listTeachercourseByTeacher(id));
        return "teacher_form";
    }    
    
    @RequestMapping(value = "/teacher/list", method = RequestMethod.GET)
    public String listTeachers(Model model) {
        model.addAttribute("listTeachers", teacherService.listTeachers());
        return "teacher_list";
    }
    
    @RequestMapping(value = "/teacher/edit", method = RequestMethod.POST)
    public String editTeacher(
            @Valid @ModelAttribute("teacher") Teacher teacher,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "teacher_form";
        } else {      
            teacherService.editTeacher(teacher);        
            return "redirect:/teacher/list";
        }
    }

    @RequestMapping(value = "/teacher/delete/{id}", method = RequestMethod.POST)
    public String deleteCourse(@PathVariable("id") int id, Model model) {
        Teacher teacher = teacherService.getTeacherById(id);
        teacherService.deleteTeacher(teacher);
        return "redirect:/teacher/list";
    }    
}

    

