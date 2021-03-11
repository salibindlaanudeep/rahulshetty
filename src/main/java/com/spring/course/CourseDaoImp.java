package com.spring.course;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CourseDaoImp implements CourseDao {

    private SessionFactory sessionFactory; //session factory is used to create hibernate session and connect to DB

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override    // overrides an element declared in superclass......
    public void addCourse(Course course) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(course);  //similar to save(adds an object to the entity)
    }

    @Override
    public List<Course> listCourses() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Course> coursesList = session.createQuery("from Course").list(); // creates a query to list all the courses 
        return coursesList; // returns the  list of the courses 
    }

    @Override
    public Course getCourseById(int courseId) {
        Session session = this.sessionFactory.getCurrentSession();
        Course st = (Course) session.load(Course.class, new Integer(courseId));  // creates a query to add ID to the course 
        return st;
    }

    @Override
    public void editCourse(Course course) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(course); //edit and update 
    }

    @Override
    public List<Course> listCoursesAvailableStudent(int studentId) { // courses available for student 
        Session session = this.sessionFactory.getCurrentSession();
        String sql = " select * from course where courseid not in "
                + " (select resultCourseId from result where resultStudentId= :studentId)";
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(Course.class);
        query.setParameter("studentId", studentId);
        List Course = query.list();
        return Course;
    }

    @Override
    public List<Course> listCoursesAvailableTeacher(int teacherId) {    // courses of teacher

        Session session = this.sessionFactory.getCurrentSession();
        String sql = " select * from course where courseid not in "
                + " (select teachercourseCourseId from teachercourse where teachercourseTeacherId= :teacherId)";
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(Course.class);
        query.setParameter("teacherId", teacherId);
        List Course = query.list();
        return Course;
    }

    @Override
    public void deleteCourse(Course course) {
        Session session = this.sessionFactory.getCurrentSession();
        String sql = " DELETE FROM result  WHERE resultCourseId = :courseId ";
        SQLQuery query = session.createSQLQuery(sql);
        query.setParameter("courseId", course.getCourseId());
        query.executeUpdate();

        sql = " DELETE FROM teachercourse  WHERE teachercourseCourseId = :courseId ";
        query = session.createSQLQuery(sql);
        query.setParameter("courseId", course.getCourseId());
        query.executeUpdate();

        session.delete(course);      // deletes the course from the course  list 
    }
}
