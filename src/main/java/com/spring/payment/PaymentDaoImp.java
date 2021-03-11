package com.spring.payment;

import java.util.List;
import org.hibernate.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class PaymentDaoImp implements PaymentDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public void addPayment(Payment payment) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(payment);
    }

    @Override
    public List<Payment> listPayments() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Payment> paymentsList = session.createQuery("from Payment").list();
        return paymentsList;
    }

    @Override
    public Payment getPaymentById(int paymentId) {
        Session session = this.sessionFactory.getCurrentSession();
        Payment st = (Payment) session.load(Payment.class, new Integer(paymentId));
        return st;
    }

    @Override
    public void editPayment(Payment payment) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(payment);
    }

    @Override
    public List<Payment> listPaymentByStudent(int studentId) {
        Session session = this.sessionFactory.getCurrentSession();
        List<Payment> paymentList = session.createQuery("from Payment R where R.paymentStudent.studentId =" + studentId).list();
        return paymentList;
    }

    @Override
    public void deletePayment(Payment payment) {
        Session session = this.sessionFactory.getCurrentSession();
        session.delete(payment);
    }

}
