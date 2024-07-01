package controller;

import java.util.List;

import model.impl.Student;
import service.StudentService;

public class StudentController {

    private StudentService service = new StudentService();

    public Student createStudent(String name, String lastName) {
        return service.createStudent(name, lastName);

    }

    public Student getById(int id, List<Student> students) {

        Student student = null;
        try {
            student = service.getById(id,students);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return student;
    }

    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }

    public List<Student> getNotInGroup(List<Student> b){
        return service.getNotInGroup(b);
    }
}