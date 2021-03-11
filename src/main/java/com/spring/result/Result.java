package com.spring.result;

import com.spring.course.Course;
import com.spring.student.Student;
import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "result")
public class Result {

    @Id
    @Column(name = "resultId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer resultId;

    @Column(name = "resultSession", nullable = true)
    @Min(value = 101, message = "Session must be a number between 101 and 1299")
    @Max(value = 1299, message = "Session must be a number between 101 and 1299")

    private Integer resultSession;

    @Column(name = "resultMark", nullable = true)
    @Min(value = 0, message = "Mark must be a number between 0 and 20")
    @Max(value = 20, message = "Mark must be a number between 0 and 20")

    private Integer resultMark;

    @ManyToOne
    @JoinColumn(name = "resultStudentId")
    @NotNull(message = "Field required")
    private Student resultStudent;

    @ManyToOne
    @JoinColumn(name = "resultCourseId")
    @NotNull(message = "Field required")
    private Course resultCourse;

    public Result() {
    }

    public Integer getResultId() {
        return resultId;
    }

    public void setResultId(Integer resultId) {
        this.resultId = resultId;
    }

    public Integer getResultSession() {
        return resultSession;
    }

    public void setResultSession(Integer resultSession) {
        this.resultSession = resultSession;
    }

    public Integer getResultMark() {
        return resultMark;
    }

    public void setResultMark(Integer resultMark) {
        this.resultMark = resultMark;
    }

    public Student getResultStudent() {
        return resultStudent;
    }

    public void setResultStudent(Student resultStudent) {
        this.resultStudent = resultStudent;
    }

    public Course getResultCourse() {
        return resultCourse;
    }

    public void setResultCourse(Course resultCourse) {
        this.resultCourse = resultCourse;
    }

}
