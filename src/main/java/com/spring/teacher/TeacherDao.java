
package com.spring.teacher;

import java.util.List;
import com.spring.course.Course;
import com.spring.course.CourseDaoImp;
import com.spring.course.CourseService;
import com.spring.course.CourseServiceImp;

public interface TeacherDao {
    
     public void addTeacher (Teacher teacher);
    
    public void editTeacher (Teacher teacher);
    
    public List<Teacher> listTeachers();
    
    public Teacher getTeacherById(int teacherId);
    
    public void deleteTeacher(Teacher teacher);
    
    public List<Teacher> listTeachersByCourse(Course course);
}
