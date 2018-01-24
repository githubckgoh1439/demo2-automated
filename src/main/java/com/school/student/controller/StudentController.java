package com.school.student.controller;


import com.school.student.model.Student;
import com.school.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/school")
public class StudentController {
	
    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/students")
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable(value = "id") Long studentId) {
        Student student = studentRepository.findOne(studentId);
        if(student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(student);
    }

    @PostMapping("/students")
    public Student createStudent(@Valid @RequestBody Student _student) {
        return studentRepository.save(_student);
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable(value = "id") Long studentId,
                                           @Valid @RequestBody Student studentDetails) {
        Student student = studentRepository.findOne(studentId);
        if(student == null) 
        {
            return ResponseEntity.notFound().build();
        }
        
        student.setStudentCode(studentDetails.getStudentCode());
        student.setName(studentDetails.getName());
        student.setIC(studentDetails.getIC());
        student.setAge(studentDetails.getAge());
        student.setSex(studentDetails.getSex());
        student.setPhone(studentDetails.getPhone());
        student.setAddress(studentDetails.getAddress());
        student.setYear(studentDetails.getYear());
        student.setStudentClass(studentDetails.getStudentClass());
        student.setEmergencyContact(studentDetails.getEmergencyContact());
        
        Student updatedStudent = studentRepository.save(student);
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<Student> deleteStudent(@PathVariable(value = "id") Long studentId) {
        Student student = studentRepository.findOne(studentId);
        if(student == null) {
            return ResponseEntity.notFound().build();
        }

        studentRepository.delete(student);
        return ResponseEntity.ok().build();
    }
    
    
}
