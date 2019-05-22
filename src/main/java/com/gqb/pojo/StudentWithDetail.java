package com.gqb.pojo;

public class StudentWithDetail extends Student {
    private StudentDetail studentDetail;

    public StudentDetail getStudentDetail() {
        return studentDetail;
    }

    public void setStudentDetail(StudentDetail studentDetail) {
        this.studentDetail = studentDetail;
    }

    @Override
    public String toString() {
        return "StudentWithDetail{" +
                "Student{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                "} " +
                studentDetail +
                '}';
    }
}
