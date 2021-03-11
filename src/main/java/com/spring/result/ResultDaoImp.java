package com.spring.result;

import com.spring.course.CourseDao;
import com.spring.student.StudentDao;
import java.util.List;
import org.hibernate.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ResultDaoImp {

    private SessionFactory sessionFactory;
    private StudentDao studentDao;
    private CourseDao courseDao;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    // @Override
    public void addResult(Result result) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(result);
    }

    // @Override
    public List<Result> listResults() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Result> resultsList = session.createQuery("from Result").list();
        return resultsList;
    }

    //@Override
    public Result getResultById(int resultId) {
        Session session = this.sessionFactory.getCurrentSession();
        Result st = (Result) session.load(Result.class, new Integer(resultId));
        return st;
    }

    // @Override
    public void editResult(Result result) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(result);
    }

    // @Override
    public List<Result> listResultByStudent(int studentId) {
        Session session = this.sessionFactory.getCurrentSession();
        List<Result> resultList = session.createQuery("from Result R where R.resultStudent.studentId =" + studentId).list();
        return resultList;
    }

    // @Override
    public void deleteResult(Result result) {
        Session session = this.sessionFactory.getCurrentSession();
        session.delete(result);
    }

}
