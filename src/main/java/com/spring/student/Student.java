package com.spring.student;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

@Entity   //@entity denotes the class ia an entity and it is connected or mapped to a database 
@Table(name = "student") // table created with name "student" in sqldevloper
public class Student {

    @Id
    @Column(name = "studentId")
    @GeneratedValue(strategy = GenerationType.AUTO) // @GeneratedValue.AUTO generates the primary key of DB

    private Long StudentId;
    private String Username;
    private String Password;
    private String Address;
    private String FirstName;
    private String LastName;
    private Long PhoneNumber;
    private String Gender;
    private String EmailId;
    private Date Birthday;

    @Column(name = "firstname", nullable = false, length = 30)
    @NotNull(message = "Field required")
    @Size(min = 1, message = "Field required")
    private String firstname;

    @Column(name = "LastName", nullable = false, length = 30)
    @NotNull(message = "Field required")
    @Size(min = 1, message = "Field required")
    private String lastname;

    @Column(name = "emailid", nullable = false, length = 30)
    @NotNull(message = "Field required")
    @Size(min = 1, message = "Field required")
    @Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Invalid email")
    private String emailid;

    @Column(name = "phonenumber", nullable = false, length = 10)
    @NotNull(message = "Field required")
    @Size(min = 1, message = "Field required")
    @Pattern(regexp = "^[0-9]{10}", message = "Phone numbers are 10 digits")
    private Long phonenumber;

    @Column(name = "address", nullable = false, length = 100)
    @NotNull(message = "Field required")
    @Size(min = 1, message = "Field required")
    private String address;

    @Column(name = "gender", nullable = false, length = 1)
    @NotNull(message = "Field required")
    @Size(min = 1, message = "Field required")
    private String gender;
    
     @Column(name = "birthday", nullable = false)
    private Date birthday;
    

    public Student() {

    }

    protected Student(String Username,Long StudentId, String Password, String FirstName, String LastName, String EmailId, String Address, Long PhoneNumber, String Gender,Date Birthday) {
       this.Password =Password;
       this.StudentId = StudentId;
       this.Username = Username;
       this.Address = address;
       this.Birthday = birthday;
       this.EmailId = emailid;
       this.FirstName = firstname;
       this.Gender = gender;
       this.LastName = lastname;
       this.PhoneNumber = phonenumber;
    }
  // Getters and setters 
    public Long getStudentId() {
        return StudentId;
    }

    public void setStudentId(Long StudentId) {
        this.StudentId = StudentId;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public Long getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(Long phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}


