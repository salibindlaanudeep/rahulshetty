
package com.spring.student;

import java.util.List;
import com.spring.course.Course;

public interface StudentDao {
    
    public void addStudent (Student st);
    
    public void editStudent (Student student);
    
    public List<Student> listStudents();
    
    public Student getStudentById(int studentId);
    
    public void deleteStudent(Student student);
    
    public List<Student> listStudentsByCourse(Course course);
    
}
