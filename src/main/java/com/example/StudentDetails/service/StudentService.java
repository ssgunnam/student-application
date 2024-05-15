package com.example.StudentDetails.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepo;

    public List<Student> getAllStudent(){
        List<Student>students = studentRepo.findAll();
        return students;
    }

    public void addStudent(Student student){
        studentRepo.save(student);

    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepo.findById(id);
    }
    public void updateStudent(Long id, Student studentDetails) {
        Optional<Student> optionalStudent = studentRepo.findById(id);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            student.setName(studentDetails.getName());
            student.setAge(studentDetails.getAge());
            studentRepo.save(student);
        }
    }

    public void deleteStudent(Long id) {
        studentRepo.deleteById(id);
    }
}

