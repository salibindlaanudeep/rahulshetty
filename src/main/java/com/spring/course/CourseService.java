
package com.spring.course;

import java.util.List;
import com.spring.student.Student;
import com.spring.student.StudentController;

public interface CourseService {
    public void addCourse (Course course);
    public void editCourse (Course course);
    public List<Course> listCourses();
    public Course getCourseById(int courseId);
    public List<Course> listCoursesAvailableStudent(int studentId);
    public List<Course> listCoursesAvailableTeacher(int teacherId);
    public void deleteCourse (Course course);
}
