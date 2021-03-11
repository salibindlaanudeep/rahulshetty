
package com.spring.teacher;

import com.spring.course.Course;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional

public class TeacherServiceImp implements TeacherService {
    
    private TeacherDao teacherDao;

    public void setTeacherDao(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }
    
    
    @Override
    public void addTeacher(Teacher teacher) {
        teacherDao.addTeacher(teacher);
    }

    @Override
    public List<Teacher> listTeachers() {
        return teacherDao.listTeachers();
    }

    @Override
    public Teacher getTeacherById(int teacherId) {
        return teacherDao.getTeacherById(teacherId);
    }

    @Override
    public void editTeacher(Teacher teacher) {
        teacherDao.editTeacher(teacher);
    }
    
    @Override
    public void deleteTeacher(Teacher teacher){
        teacherDao.deleteTeacher(teacher);
    }
    
    @Override
    public List<Teacher> listTeachersByCourse(Course course){
        return teacherDao.listTeachersByCourse(course);
    }
    
}
