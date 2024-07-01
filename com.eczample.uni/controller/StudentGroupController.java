package controller;

import model.impl.Student;
import model.impl.StudentGroup;
import model.impl.Teacher;
import service.StudentGroupService;

import java.util.List;

public class StudentGroupController {

    private StudentGroupService service = new StudentGroupService();




    public StudentGroup CreateStudentGroup (Teacher teacher,List<Student> students){

        return service.CreateStudentGroup(teacher,students);
    }





}
