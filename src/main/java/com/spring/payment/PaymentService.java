package com.spring.payment;

import java.util.List;

public interface PaymentService {

    public void addPayment(Payment payment);

    public void editPayment(Payment payment);

    public List<Payment> listPayments();

    public Payment getPaymentById(int paymentId);

    public List<Payment> listPaymentByStudent(int studentId);

    public void deletePayment(Payment payment);
}
