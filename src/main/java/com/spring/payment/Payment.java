
package com.spring.payment;

import com.spring.student.Student;
import java.sql.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "payment")
public class Payment {
    
    @Id
    @Column(name = "paymentId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer paymentId;    
    
    @Column(name="paymentAmount") 
    @NotNull(message="Field required") 
    private Integer paymentAmount;


    @Column(name = "paymentDate", nullable = false)
    private Date paymentDate;
  
    @ManyToOne  
    @JoinColumn(name = "paymentStudentId")
    @NotNull(message="Field required")    
    private Student paymentStudent;



    
    public Payment() {
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public Integer getPaymentAmount() {
        return paymentAmount;
    }

    public void setPaymentAmount(Integer paymentAmount) {
        this.paymentAmount = paymentAmount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Student getPaymentStudent() {
        return paymentStudent;
    }

    public void setPaymentStudent(Student paymentStudent) {
        this.paymentStudent = paymentStudent;
    }
    
    
    
}
