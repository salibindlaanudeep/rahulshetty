
package com.spring.teacher;

import com.spring.course.Course;
import com.spring.course.CourseDao;
import com.spring.course.CourseDaoImp;
import com.spring.course.CourseService;
import com.spring.course.CourseServiceImp;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service // with this annotation we can directly call a DAO class to save an object to DB
@Transactional // this annotation is mainly for starting and committing the the transaction 

public class TeachercourseServiceImp {
    private TeacherDao teacherDao;

    public void setTeacherDao(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
}
    
    
    public void addTeacher(Teacher teacher) {
        teacherDao.addTeacher(teacher);
    }

    public List<Teacher> listTeachers() {
        return teacherDao.listTeachers();
    }

    public Teacher getTeacherById(int teacherId) {
        return teacherDao.getTeacherById(teacherId);
    }

    public void editTeacher(Teacher teacher) {
        teacherDao.editTeacher(teacher);
    }
    
    public void deleteTeacher(Teacher teacher){
        teacherDao.deleteTeacher(teacher);
    }
    
    public List<Teacher> listTeachersByCourse(Course course){
        return teacherDao.listTeachersByCourse(course);
    }
}

