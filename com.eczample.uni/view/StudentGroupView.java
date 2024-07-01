package view;

import controller.StudentController;
import controller.StudentGroupController;
import controller.TeacherController;
import model.DB.DataBase;
import model.impl.Student;
import model.impl.StudentGroup;
import model.impl.Teacher;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentGroupView {
    Teacher teacher;
    List<Student> students = new ArrayList<>();
    StudentGroupController groupController = new StudentGroupController();


    public  void start(){


        Scanner scanner = new Scanner(System.in);
        while (true) {

            System.out.println("Настройки для создания группы");
            System.out.println("1 - Выбрать преподавателя по id из списка");
            System.out.println("2 - Добавить студента в группу");
            System.out.println("3 - Просмотреть набранную группу");
            System.out.println("4 - создать набранную группу");
            System.out.println("5 - Вернуться в предыдущее меню");

            switch (scanner.nextInt()) {
                case 1 -> SelectTeacher(); //Выбрать учителя
                case 2 -> students.add(SelectStudent(students)); // Добавить нового студента в группу
                case 3 -> System.out.println(students);//Просмотреть набранную группу
                case 4 -> DataBase.studentGroups.add(groupController.CreateStudentGroup(teacher,students));//Создает объект StudentGroup
                case 5 -> new StudentView().start();// выход из приложения

                default -> System.out.println("Операция не поддерживается");
            }
        }


    }

    public void SelectTeacher(){
        int id;
        TeacherController teacherController = new TeacherController();
        System.out.println(DataBase.teachersDB);
        System.out.println("Введите номер id преподавателя");
        Scanner scanner = new Scanner(System.in);

        id= scanner.nextInt();
        teacher = teacherController.getById(id);

    }

    public Student SelectStudent(List<Student> students){
        Student student;
        int id;
        StudentController controller = new StudentController();
        List<Student> selectedStudents = controller.getNotInGroup(students); //формирование листа студентов которые еще не в группе
        System.out.println(selectedStudents);// Вывод на печать группы студенотов которые еще не выбраны


        Scanner scanner = new Scanner(System.in);
        id= scanner.nextInt();
        student = controller.getById(id,selectedStudents);

        return student;
    }
}
