
package com.spring.course;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity  //@entity denotes the class ia an entity and it is connected or mapped to a database 
@Table(name="course") // table created with name "student" in sqldevloper
public class Course {
    
    @Id
    @Column(name = "courseId")
    @GeneratedValue(strategy = GenerationType.AUTO)// @GeneratedValue.AUTO generates the primary key of DB 
    private Integer courseId;
    
    @Column(name="courseName", nullable=false, length=50)
    @NotNull(message="Field required")
    @Size(min=1, message="Field required")
    private String courseName;
    
    @Column(name="courseCredits", nullable=false)
    @NotNull(message="Field required")
    @Min(value=1, message="Credit must be a number between 1 and 8")
    @Max(value=8, message="Credit must be a number between 1 and 8")
    private Integer courseCredits;

    public Course() {
    }

    public Course(Integer courseId, String courseName, Integer courseCredits) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseCredits = courseCredits;
    }

    // getters and setters 
    
    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getCourseCredits() {
        return courseCredits;
    }

    public void setCourseCredits(Integer courseCredits) {
        this.courseCredits = courseCredits;
    }
}
