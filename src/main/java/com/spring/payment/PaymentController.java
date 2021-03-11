package com.spring.payment;

import com.spring.course.CourseService;
import com.spring.student.StudentService;
import com.spring.student.Student;
import com.spring.course.Course;
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
public class PaymentController {

    private PaymentService paymentService;
    private CourseService courseService;
    private StudentService studentService;

    @Autowired(required = true)
    @Qualifier(value = "paymentService")
    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
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

    @RequestMapping(value = "/payment/add", method = RequestMethod.GET)
    public String paymentForm(Model model) {
        model.addAttribute("payment", new Payment());
        model.addAttribute("courseList", this.courseService.listCourses());
        return "payment_form";
    }

    @RequestMapping(value = "/payment/add/{studentId}", method = RequestMethod.GET)
    public String addPayment(@PathVariable("studentId") int studentId, Model model) {
        Payment payment = new Payment();
        payment.setPaymentStudent(this.studentService.getStudentById(studentId));
        model.addAttribute("courseList", this.courseService.listCoursesAvailableStudent(studentId));
        model.addAttribute("payment", payment);
        return "payment_form";
    }

    @RequestMapping(value = "/payment/add", method = RequestMethod.POST)
    public String addPayment(
            @Valid @ModelAttribute("payment") Payment payment,
            BindingResult bindingPayment) {

        if (bindingPayment.hasErrors()) {
            if (payment.getPaymentStudent().getStudentId() != 0) {
                return "redirect:/payment/add/" + payment.getPaymentStudent().getStudentId();
            } else {
                return "payment_form";
            }
        } else {
            paymentService.addPayment(payment);
            return "redirect:/student/list";
        }
    }

    @RequestMapping(value = "/payment/{id}")
    public String editPayment(@PathVariable("id") int id, Model model) {
        Payment payment = this.paymentService.getPaymentById(id);
        model.addAttribute("payment", payment);
        model.addAttribute("courseList", this.courseService.listCourses());
        return "payment_form";
    }

    @RequestMapping(value = "/payment/edit", method = RequestMethod.POST)
    public String editPayment(
            @Valid @ModelAttribute("payment") Payment payment,
            BindingResult bindingPayment) {
        paymentService.editPayment(payment);
        return "redirect:/student/list";
    }

    @RequestMapping(value = "/payment/list", method = RequestMethod.GET)
    public String listCourses(Model model) {
        model.addAttribute("listPayments", paymentService.listPayments());
        return "payment_list";
    }

    @RequestMapping(value = "/payment/delete/{id}", method = RequestMethod.POST)
    public String deletePayment(@PathVariable("id") int id, Model model) {
        Payment payment = paymentService.getPaymentById(id);
        paymentService.deletePayment(payment);
        return "redirect:/payment/list";
    }

}
