package com.exam.architecturefinal.demo.Models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "exam")
public class Exam {
    @Id
    @Column(unique = true)
    private int examId;
    private String examCode;
    private String examName;
    private Date examDate;
    private String startTime;
    private String endTime;
    private String examDescription;

    public Exam() {
    }

    public Exam(int examId, String examCode, String examName, Date examDate, String startTime, String endTime, String examDescription) {
        this.examId = examId;
        this.examCode = examCode;
        this.examName = examName;
        this.examDate = examDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.examDescription = examDescription;
    }

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public String getExamCode() {
        return examCode;
    }

    public void setExamCode(String examCode) {
        this.examCode = examCode;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    public Date getExamDate() {
        return examDate;
    }

    public void setExamDate(Date examDate) {
        this.examDate = examDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getExamDescription() {
        return examDescription;
    }

    public void setExamDescription(String examDescription) {
        this.examDescription = examDescription;
    }
}


