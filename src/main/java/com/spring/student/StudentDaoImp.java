
package com.spring.student;

import java.util.List;
import com.spring.course.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.hibernate.SQLQuery;

@Repository
public class StudentDaoImp implements StudentDao {
    
    private SessionFactory sessionFactory;
	
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
    
  
    @Override
    @Transactional
    public void addStudent(Student st) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(st);  
    }
     @Override
    @Transactional
    public List<Student> listStudents() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Student> studentsList = session.createQuery("from Student").list();
        return studentsList;
}
    
    
    @Override
    @Transactional
    public Student getStudentById(int studentId) {
        Session session = this.sessionFactory.getCurrentSession();
        Student st = (Student) session.load(Student.class, studentId);
        return st;
    }
    
    
    @Override
    @Transactional
    public void editStudent(Student student) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(student);
    }
     @Override
    public void deleteStudent(Student student) {
        Session session = this.sessionFactory.getCurrentSession();
        String sql = " DELETE FROM result  WHERE resultStudentId = :studentId ";
        SQLQuery query = session.createSQLQuery(sql);
        query.setParameter("studentId", student.getStudentId());
        query.executeUpdate();
        
        session.delete(student);      
    }    
    @Override
    public List<Student> listStudentsByCourse(Course course){
        Session session = this.sessionFactory.getCurrentSession();
        String sql = " SELECT distinct s.* FROM student s, result r "
                + " where s.studentId = r.resultStudentId "
                + " and r.resultCourseid= :courseId";
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(Student.class);
        query.setParameter("courseId", course.getCourseId());
        List studentList = query.list();
        return studentList;    
        
    }
}
