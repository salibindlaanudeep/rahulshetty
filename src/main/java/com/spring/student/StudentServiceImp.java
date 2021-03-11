
package com.spring.student;

import java.util.List;
import com.spring.course.Course;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class StudentServiceImp {
    
     private StudentDao studentDao;

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }
    
    
    //@Override
    public void addStudent(Student student) {
        studentDao.addStudent(student);
    }

    //@Override
    public List<Student> listStudents() {
        return studentDao.listStudents();
    }

    //@Override
    public Student getStudentById(int studentId) {
        return studentDao.getStudentById(studentId);
    }

    //@Override
    public void editStudent(Student student) {
        studentDao.editStudent(student);
    }
    
    //@Override
    public void deleteStudent(Student student){
        studentDao.deleteStudent(student);
    }
    
    //@Override
    public List<Student> listStudentsByCourse(Course course){
        return studentDao.listStudentsByCourse(course);
    }
}
