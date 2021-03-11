
package com.spring.result;

import com.spring.course.CourseService;
import com.spring.student.StudentService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ResultController {
     private ResultService resultService;
    private CourseService courseService;
    private StudentService studentService;

    @Autowired(required = true)
    @Qualifier(value = "resultService")
    public void setResultService(ResultService resultService) {
        this.resultService = resultService;
    }

    @Autowired(required = true)
    @Qualifier(value = "courseService")
    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }

    @Autowired(required = true)
    @Qualifier(value = "studentService")
    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(value = "/result/add", method = RequestMethod.GET)
    public String resultForm(Model model) {
        model.addAttribute("result", new Result());
        model.addAttribute("courseList", this.courseService.listCourses());
        return "result_form";
    }

    @RequestMapping(value = "/result/add/{studentId}", method = RequestMethod.GET)
    public String addResult(@PathVariable("studentId") int studentId, Model model) {
        Result result = new Result();
        result.setResultStudent(this.studentService.getStudentById(studentId));
        model.addAttribute("courseList", this.courseService.listCoursesAvailableStudent(studentId));
        model.addAttribute("result", result);
        return "result_form";
    }

    @RequestMapping(value = "/result/add", method = RequestMethod.POST)
    public String addResult(
            @Valid @ModelAttribute("result") Result result,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            if (result.getResultStudent().getStudentId() !=0){
                 return "redirect:/result/add/" + result.getResultStudent().getStudentId() ;
            }
            else {
                return "result_form";
            }
        } else {
            resultService.addResult(result);
            return "redirect:/student/list";
        }
    }

    @RequestMapping(value = "/result/{id}")
    public String editResult(@PathVariable("id") int id, Model model) {
        Result result = this.resultService.getResultById(id);
        model.addAttribute("result", result);
        model.addAttribute("courseList", this.courseService.listCourses());
        return "result_form";
    }

    @RequestMapping(value = "/result/edit", method = RequestMethod.POST)
    public String editResult(
            @Valid @ModelAttribute("result") Result result,
            BindingResult bindingResult) {
        resultService.editResult(result);
        return "redirect:/student/list";
    }

    @RequestMapping(value = "/result/list", method = RequestMethod.GET)
    public String listCourses(Model model) {
        model.addAttribute("listResults", resultService.listResults());
        return "result_list";
    }

    @RequestMapping(value = "/result/delete/{id}", method = RequestMethod.POST)
    public String deleteResult(@PathVariable("id") int id, Model model) {
        Result result = resultService.getResultById(id);
        resultService.deleteResult(result);
        return "redirect:/result/list";
    }
}
