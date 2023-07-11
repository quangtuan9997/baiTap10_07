package baitap10_7.service;

import baitap10_7.model.Student;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Component
@Primary
@Order(1)
public class StudentServiceIMPL {
 List<Student> listStudent=new ArrayList<>();
    public List<Student> findAll(){
        return listStudent;
    }
    public Student save(Student student){
        if (listStudent.size()==0){
            student.setId(1L);
            listStudent.add(student);
            return student;
        }
        student.setId(listStudent.get(listStudent.size()-1).getId()+1);
        listStudent.add(student);
        return student;
    }

    public Student findById(Long id){
        for (Student s :listStudent) {
            if(s.getId()==id);
            return s;
        }
        return null;
    }



    public boolean deleteById(Long id) {
        for (int i = 0; i < listStudent.size(); i++) {
            if (listStudent.get(i).getId()==id){
                listStudent.remove(i);
                return true;
            }
        }
        return false;
    }
}
