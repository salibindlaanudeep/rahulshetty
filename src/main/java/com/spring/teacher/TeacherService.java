
package com.spring.teacher;

import java.util.List;
import com.spring.course.Course;

public interface TeacherService {
    
     public void addTeacher (Teacher teacher);
    public void editTeacher (Teacher teacher);
    public List<Teacher> listTeachers();
    public Teacher getTeacherById(int teacherId);
    public void deleteTeacher(Teacher teacher);
    public List<Teacher> listTeachersByCourse(Course course);
    
}
