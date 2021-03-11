
package com.spring.course;

import java.util.List;

public interface CourseDao {
    
     public void addCourse (Course course);
    
    public void editCourse (Course course);
    
    public List<Course> listCourses();
    
    public Course getCourseById(int courseId);
    
    public List<Course> listCoursesAvailableStudent(int studentId); 
    
    public List<Course> listCoursesAvailableTeacher(int teacherId);
    
    public void deleteCourse (Course course);
}
