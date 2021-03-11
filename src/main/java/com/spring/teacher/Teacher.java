
package com.spring.teacher;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity //@entity denotes the class ia an entity and it is connected or mapped to a database 
@Table(name = "teacher") // table created with name "student" in sqldevloper
public class Teacher {
    
    @Id 
    @Column(name = "teacherId") // coulumn name 
    @GeneratedValue(strategy = GenerationType.AUTO)// @GeneratedValue.AUTO generates the primary key of DB 
    private Integer teacherId;

    @Column(name = "teacherFirstName", nullable = false, length = 20) //creates column teacher's First name 
    @Size(min = 1, message = "Field required")
    private String teacherFirstName;

    @Column(name = "teacherLastName", nullable = false, length = 20) // creates column teacher's Last name 
    @NotNull(message = "Field required")
    @Size(min = 1, message = "Field required")
    private String teacherLastName;

    @Column(name = "teacherAddress", nullable = false, length = 20) // creates column teacher's Address
    @NotNull(message = "Field required")
    @Size(min = 1, message = "Field required")
    private String teacherAddress;

    @Column(name = "teacherCity", nullable = false, length = 20) // creates coulmn for teacher's city 
    @NotNull(message = "Field required")
    @Size(min = 1, message = "Field required")
    private String teacherCity;

    @Column(name = "teacherCountry", nullable = false, length = 20) // creates column  for teacher's country
    @NotNull(message = "Field required")
    @Size(min = 1, message = "Field required")
    private String teacherCountry;

    @Column(name = "teacherPhone", nullable = false, length = 10) // creates column  for teacher's Phone number 
    @NotNull(message = "Field required")
    @Size(min = 1, message = "Field required")
    @Pattern(regexp="^[0-9]{10}", message = "Phone numbers are 10 digits")
    private String teacherPhone;

    @Column(name = "teacherSalary", nullable = false) // creates column for teacher's salary
    @Min(value=1, message="Salary must be a positive number")
    @Max(value=99999, message="Salary must be a positive number")
    private int teacherSalary;

    public Teacher(){
        
    }
 // Getters and Setters
    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherFirstName() {
        return teacherFirstName;
    }

    public void setTeacherFirstName(String teacherFirstName) {
        this.teacherFirstName = teacherFirstName;
    }

    public String getTeacherLastName() {
        return teacherLastName;
    }

    public void setTeacherLastName(String teacherLastName) {
        this.teacherLastName = teacherLastName;
    }

    public String getTeacherAddress() {
        return teacherAddress;
    }

    public void setTeacherAddress(String teacherAddress) {
        this.teacherAddress = teacherAddress;
    }

    public String getTeacherCity() {
        return teacherCity;
    }

    public void setTeacherCity(String teacherCity) {
        this.teacherCity = teacherCity;
    }

    public String getTeacherCountry() {
        return teacherCountry;
    }

    public void setTeacherCountry(String teacherCountry) {
        this.teacherCountry = teacherCountry;
    }

    public String getTeacherPhone() {
        return teacherPhone;
    }

    public void setTeacherPhone(String teacherPhone) {
        this.teacherPhone = teacherPhone;
    }

    public int getTeacherSalary() {
        return teacherSalary;
    }

    public void setTeacherSalary(int teacherSalary) {
        this.teacherSalary = teacherSalary;
    }
    }
    
