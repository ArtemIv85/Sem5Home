package service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import model.DB.DataBase;
import model.impl.Student;

public class StudentService {

    public Student createStudent(String name, String lastName){// отвечает только за создание студента (чистый метод)
        int id=DataBase.studentLastId+1;
        Student student = new Student(id, name, lastName);
        DataBase.studentsDB.add(student);
        DataBase.studentLastId=id;
        return student;
    }

    public Student getById(int id, List<Student> students) throws Exception {
        Student student = students//список студентов
                .stream()//запускаем поток для вычислений
                // пример лямда-выражения (s -> s.getId() == id)
                .filter(s -> s.getId() == id)//вызываем метод filter фильтруя по условию (s = student(переменная))
                .findFirst()//вернуть первого найденого студента
                .orElse(null);// если не нашли вернуть null (orElse закрывет поток stream)
        if (student == null) {
            throw new Exception("Студент не найден");//выбрасываем проверяемое исключение, которое компилятор требует отработать
        }
        return student;
    }

    public List<Student> getAllStudents(){
        return DataBase.studentsDB;
    }

    public List<Student> getNotInGroup(List<Student> b){
        List<Student> a = DataBase.studentsDB;

        for (int i=0; i<b.size();i++){
            for (int j=0;j<a.size();j++){
                if (b.get(i).equals(a.get(j))){
                    a.remove(j);
                }

            }
        }
        return a;
    }
}
