package com.spring.teacher;

import com.spring.course.Course;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.hibernate.SQLQuery;
import org.springframework.transaction.annotation.Transactional;

@Repository  // indicates that  the class provides the mechanism for storage,update,delete,search and retrieve on objects in the class  
@Transactional  // this annotation is mainly for starting and committing the the transaction 

// class TeacherDao Implements the interface TeacherDao
public class TeacherDaoImp implements TeacherDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    // Adds new teacher to the Database by admin
    public void addTeacher(Teacher st) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(st);
    }

    @Override
    // lists all the teachers in the Database 
    public List<Teacher> listTeachers() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Teacher> teachersList = session.createQuery("from Teacher").list();
        return teachersList;
    }

    @Override
    // retrieve or find the teacher using their ID in the Database 
    public Teacher getTeacherById(int teacherId) {
        Session session = this.sessionFactory.getCurrentSession();
        Teacher st = (Teacher) session.load(Teacher.class, teacherId);
        return st;
    }

    @Override
    // edit teacher info in the database 
    public void editTeacher(Teacher teacher) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(teacher);
    }

    @Override
    // delete teacher from the database 
    public void deleteTeacher(Teacher teacher) {
        Session session = this.sessionFactory.getCurrentSession();
        String sql = " DELETE FROM teachercourse  WHERE teachercourseTeacherId = :teacherId ";
        SQLQuery query = session.createSQLQuery(sql);
        query.setParameter("teacherId", teacher.getTeacherId());
        query.executeUpdate();
        session.delete(teacher);
    }
    /*
     * @param course
     * @return
     */
    @Override
    
    public List<Teacher> listTeachersByCourse(Course course) { // teachers by course 
        Session session = this.sessionFactory.getCurrentSession();
        String sql = " SELECT distinct t.* FROM teacher t, teachercourse c "
                + " where t.teacherid=c.teachercourseteacherid "
                + " and c.teachercourseCourseid= :courseId";
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(Teacher.class);
        query.setParameter("courseId", course.getCourseId()); 
        List teachersList = query.list();
        return teachersList; // returns the list of teachers

    }
}
