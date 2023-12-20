package com.reactDemo.service;

import com.reactDemo.exception.StudentAlreadyExistException;
import com.reactDemo.exception.studentNotFoundException;
import com.reactDemo.model.Student;
import com.reactDemo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class StudentService implements IStudentService {
    private  final StudentRepository studentRepository;
    @Override
    public List<Student> getStudents() {

        return  studentRepository.findAll();
    }

    @Override
    public Student addStudent(Student student) {
        if(studentAlreadyExist(student.getEmail())){
            throw  new StudentAlreadyExistException(student.getEmail() + "already exist!");
        }
        return studentRepository.save(student);
    }


    @Override
    public Student updateStudent(Student student, Long id) {
        return studentRepository.findById(id).map(st -> {
                st.setFirstName(student.getFirstName());
        st.setLastName(student.getLastName());
        st.setEmail(student.getEmail());
        st.setDepartment(student.getDepartment());
        return  studentRepository.save(st);
        }).orElseThrow(()-> new studentNotFoundException("Sorry! student could not be found!"));
    }

    @Override
    public Student getSingleStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(()-> new studentNotFoundException("Student not found with this id:" +id));
    }

    @Override
    public void deleteStudent(Long id) {
    if (!studentRepository.existsById(id)){
        throw new studentNotFoundException("Sorry, student not found!");
    }
    studentRepository.deleteById(id);
    }
    private boolean studentAlreadyExist(String email) {
        return studentRepository.findByEmail(email).isPresent();
    }
}


