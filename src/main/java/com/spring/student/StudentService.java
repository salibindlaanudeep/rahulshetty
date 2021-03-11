
package com.spring.student;

import java.util.List;
import com.spring.course.Course;

public interface StudentService {
     public void addStudent (Student student);
    public void editStudent (Student course);
    public List<Student> listStudents();
    public Student getStudentById(int studentId);
    public void deleteStudent(Student student);
    public List<Student> listStudentsByCourse(Course course);
}
