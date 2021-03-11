package com.spring.course;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CourseServiceImp implements CourseService {

    private CourseDao courseDao;

    public void setCourseDao(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    @Override
    public void addCourse(Course course) {
        courseDao.addCourse(course);
    }

    @Override
    public List<Course> listCourses() {
        return courseDao.listCourses();
    }

    @Override
    public Course getCourseById(int courseId) {
        return courseDao.getCourseById(courseId);
    }

    @Override
    public void editCourse(Course course) {
        courseDao.editCourse(course);
    }

    @Override
    public List<Course> listCoursesAvailableStudent(int studentId) {
        return courseDao.listCoursesAvailableStudent(studentId);
    }

    @Override
    public List<Course> listCoursesAvailableTeacher(int teacherId) {
        return courseDao.listCoursesAvailableTeacher(teacherId);
    }

    @Override
    public void deleteCourse(Course course) {
        courseDao.deleteCourse(course);
    }
}
