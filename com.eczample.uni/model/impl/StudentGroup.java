package model.impl;

import java.util.ArrayList;
import java.util.List;

public class StudentGroup {
 protected Teacher teacher;
 protected List<Student> studentsGroup = new ArrayList<>();

    public StudentGroup(Teacher teacher,List<Student> studentsGroup) {
        this.studentsGroup = studentsGroup;
        this.teacher = teacher;
    }


    @Override
    public String toString() {
        return "StudentGroup{" +
                ", teacher=" + teacher +"\n"+
                "studentsGroup=" + studentsGroup +
                '}';
    }
}
