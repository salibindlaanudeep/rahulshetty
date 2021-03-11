package com.spring.payment;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PaymentServiceImp implements PaymentService {

    private PaymentDao paymentDao;

    public void setPaymentDao(PaymentDao paymentDao) {
        this.paymentDao = paymentDao;
    }

    @Override
    public void addPayment(Payment payment) {
        paymentDao.addPayment(payment);
    }

    @Override
    public List<Payment> listPayments() {
        return paymentDao.listPayments();
    }

    @Override
    public Payment getPaymentById(int paymentId) {
        return paymentDao.getPaymentById(paymentId);
    }

    @Override
    public void editPayment(Payment payment) {
        paymentDao.editPayment(payment);
    }

    @Override
    public List<Payment> listPaymentByStudent(int studentId) {
        return paymentDao.listPaymentByStudent(studentId);
    }

    @Override
    public void deletePayment(Payment payment) {
        paymentDao.deletePayment(payment);
    }

}
