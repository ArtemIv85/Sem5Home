package controller;

import model.impl.Teacher;
import service.TeacherService;
public class TeacherController {

    private TeacherService service = new TeacherService();



    public Teacher getById(int id) {

        Teacher teacher = null;
        try {
            teacher = service.getById(id);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return teacher;
    }
}
