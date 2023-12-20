package com.reactDemo.repository;

import com.reactDemo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Object> findByEmail(String email);
}
