package service;

import model.impl.Student;
import model.impl.StudentGroup;
import model.impl.Teacher;

import java.util.List;

public class StudentGroupService {

    public StudentGroup CreateStudentGroup (Teacher teacher, List<Student> students){

        StudentGroup studentGroup = new StudentGroup(teacher,students);

        return studentGroup;
    }




}
